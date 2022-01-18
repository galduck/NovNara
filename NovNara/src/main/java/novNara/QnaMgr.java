package novNara;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/*Dao : Data Access Object*/
public class QnaMgr {

	private DBConnectionMgr pool;
	public static final String SAVEDIRECTORY = "D:/Jsp/NovNara/NovNara/src/main/webapp/qna/qnaFileUpload";
	public static final String ENCODING = "UTF-8";
	public static final int MAXPOSTSIZE = 10*1024*1024;//10mb
	
	public QnaMgr() {	
		pool = DBConnectionMgr.getInstance();
	}
	
	//Qna Insert : ���Ͼ��ε� , contentType(text, html)
	public void insertQna(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			//���� ���ε� ���
			File dir = new File(SAVEDIRECTORY);
			if(!dir.exists()) {
				//dir.mkdir();//���������� ���縦 �ؾ��� ��������
				dir.mkdirs();//���������� ��� ��������
			}
			
			MultipartRequest multi = 
				new MultipartRequest(req, SAVEDIRECTORY, MAXPOSTSIZE, 
						ENCODING, new DefaultFileRenamePolicy());
			String filename = null;
			int filesize = 0;
			//��� �Խù��� ������ ���ε� �ϴ°� �ƴϴ�.
			if(multi.getFilesystemName("filename")!=null) {
				filename = multi.getFilesystemName("filename");
				filesize = (int)multi.getFile("filename").length();
			}
			//���� contentType : TEXT, HTML
			String content = multi.getParameter("content");//�Խù� ����
			String contentType = multi.getParameter("contentType");//�Խù� Ÿ��
			if(contentType.equalsIgnoreCase("TEXT")) {
				content = QnaUtilMgr.replace(content, "<", "&lt;");
			}
			//�亯�� ���� ref
			int ref = getMaxNum()+1;
			
			con = pool.getConnection();
			sql = "insert tblQna(name,content,subject,ref,pos,depth,";
			sql += "regdate,pass,count,ip,filename,filesize)";
			sql += "values(?, ?, ?, ?, 0, 0, now(), ?, 0, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, multi.getParameter("name"));
			pstmt.setString(2, content);
			pstmt.setString(3, multi.getParameter("subject"));
			pstmt.setInt(4, ref);
			pstmt.setString(5, multi.getParameter("pass"));
			pstmt.setString(6, multi.getParameter("ip"));
			pstmt.setString(7, filename);
			pstmt.setInt(8, filesize);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}

	//Qna Max Num : ref�� ���忡 �ʿ��� ��
	public int getMaxNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int maxNum = 0;
		try {
			con = pool.getConnection();
			sql = "select max(num) from tblQna";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) maxNum = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return maxNum;
	}
	
	//Qna Total Count : �� �Խù���
	//keyField : name, subject, content
	public int getTotalCount(String keyField, String keyWord) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int totalCount = 0;
		try {
			con = pool.getConnection();
			if(keyWord.trim().equals("")||keyWord==null) {
				//�˻��� �ƴ� ���
				sql = "select count(*) from tblQna";
				pstmt = con.prepareStatement(sql);
			} else {
				sql = "select count(*) from tblQna where " + keyField +" like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+keyWord+"%");
			}
			rs = pstmt.executeQuery();
			if(rs.next()) totalCount = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return totalCount;
	}
	
	//Qna List : keyField, keyWord, start(���۹�ȣ), cnt(�� �������� ������ �Խù� ����)
	public Vector<QnaBean> getQnaList
	(String keyField, String keyWord, int start, int cnt){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<QnaBean> vlist = new Vector<QnaBean>();
		try {
			con = pool.getConnection();
			if(keyWord.trim().equals("")||keyWord==null) {//�˻��� �ƴ� ���
				sql = "select * from tblQna order by ref desc, pos limit ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, cnt);
			} else {//�˻��� ���
				sql = "select * from tblQna  where " + keyField +" like ? ";
				sql+= "order by ref desc, pos limit ?, ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+keyWord+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, cnt);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QnaBean bean = new QnaBean();
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSubject(rs.getString("subject"));
				bean.setPos(rs.getInt("pos"));
				bean.setRef(rs.getInt("ref"));
				bean.setDepth(rs.getInt("depth"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setCount(rs.getInt("count"));
				bean.setFilename(rs.getString("filename"));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//Qna Read : �Խù� �Ѱ� �о����
	public QnaBean getQna(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		QnaBean bean = new QnaBean();
		try {
			con = pool.getConnection();
			sql = "select * from tblQna where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setNum(rs.getInt("num"));
				bean.setName(rs.getString("name"));
				bean.setSubject(rs.getString("subject"));
				bean.setContent(rs.getString("content"));
				bean.setPos(rs.getInt("pos"));
				bean.setRef(rs.getInt("ref"));
				bean.setDepth(rs.getInt("depth"));
				bean.setRegdate(rs.getString("regdate"));
				bean.setPass(rs.getString("pass"));
				bean.setIp(rs.getString("ip"));
				bean.setCount(rs.getInt("count"));
				bean.setFilename(rs.getString("filename"));
				bean.setFilesize(rs.getInt("filesize"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	//Count up : ��ȸ�� ����
 	public void upCount(int num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "update tblQna set count = count +1 where num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	
	//Qna Delete : �Խù� ����(���ε� ���ϱ��� ����)
 	public void deleteQna(int num) {
 		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			//�Խù��� �����Ǳ� ���� ���ϸ� Ȯ��
			String filename = getQna(num).getFilename();
			sql = "delete from tblQna where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			if(pstmt.executeUpdate()==1) {//���������� ������ �Ǿ��ٸ� ���ϵ� ����
				if(filename!=null&&!filename.equals("")) {
					File f = new File(SAVEDIRECTORY+filename);
					if(f.exists()) {
						QnaUtilMgr.delete(SAVEDIRECTORY+filename);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
 	}
	
	
	//Qna Update2 : �Խù� ���� (���ε� ���ϱ��� ����)
	public void updateQna2(MultipartRequest mulit) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			int num = Integer.parseInt(mulit.getParameter("num"));
			String name = mulit.getParameter("name");
			String subject = mulit.getParameter("subject");
			String content = mulit.getParameter("content");
			String filename = mulit.getFilesystemName("filename");
			if(filename!=null&&!filename.equals("")) {
				//������ ������ ����
				QnaBean bean = getQna(num);
				String tempFile = bean.getFilename();
				//�������� �ְ� �������� �ִ�.
				if(tempFile!=null&&!tempFile.equals("")) {
					File f = new File(SAVEDIRECTORY+tempFile);
					if(f.exists()) QnaUtilMgr.delete(SAVEDIRECTORY+tempFile);
				}
				int filesize = (int)mulit.getFile("filename").length();
				sql = "update tblQna set name=?, subject=?, content=?, filename=?, "
						+ "filesize=? where num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, subject);
				pstmt.setString(3, content);
				pstmt.setString(4, filename);
				pstmt.setInt(5, filesize);
				pstmt.setInt(6, num);
			}else {
				sql = "update tblQna set name=?, subject=?, content=? where num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, subject);
				pstmt.setString(3, content);
				pstmt.setInt(4, num);
			}
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
 	
	//Qna Reply : �Խù� �亯 -> ���Ͼ��ε� ��� ����
	public void replyQna(QnaBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "insert tblQna(name,content,subject,ref,pos,depth,regdate,";
			sql+= "pass,count,ip)values(?, ?, ?, ?, ?, ?, now(), ?, 0, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getContent());
			pstmt.setString(3, bean.getSubject());
			///////////////////////////////////
			pstmt.setInt(4, bean.getRef());//���۰� ������ ref -> �亯���� �׷��� ���
			pstmt.setInt(5, bean.getPos()+1);//������ pos+1
			pstmt.setInt(6, bean.getDepth()+1);//���۰��� depth+1
			///////////////////////////////////
			pstmt.setString(7, bean.getPass());
			pstmt.setString(8, bean.getIp());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
 	
	//Qna Reply Up : �亯�� ��ġ�� ����
 	public void replyUpQna(int ref, int pos) {
 		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "update tblQna set pos=pos+1 where ref=? and pos>?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pos);
			pstmt.setInt(1, ref);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
 	}
	
}
