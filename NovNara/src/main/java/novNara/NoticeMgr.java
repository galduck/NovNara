package novNara;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NoticeMgr {



		private DBConnectionMgr pool;
		public static final String SAVEDIRECTORY = "D:/Jsp/NovNara/NovNara/src/main/webapp/notice/noticeFileUpload";
		public static final String ENCODING = "UTF-8";
		public static final int MAXPOSTSIZE = 10*1024*1024;//10mb
		
		public NoticeMgr() {	
			pool = DBConnectionMgr.getInstance();
		}
		
		//Notice Insert : 파일업로드 , contentType(text, html)
		public void insertNotice(HttpServletRequest req) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				//파일 업로드 기능
				File dir = new File(SAVEDIRECTORY);
				if(!dir.exists()) {
					//dir.mkdir();//상위폴더가 존재를 해야지 생성가능
					dir.mkdirs();//상위폴더가 없어도 생성가능
				}
				
				MultipartRequest multi = 
					new MultipartRequest(req, SAVEDIRECTORY, MAXPOSTSIZE, 
							ENCODING, new DefaultFileRenamePolicy());
				String filename = null;
				int filesize = 0;
				//모든 게시물이 파일을 업로드 하는건 아니다.
				if(multi.getFilesystemName("filename")!=null) {
					filename = multi.getFilesystemName("filename");
					filesize = (int)multi.getFile("filename").length();
				}
				//파일 contentType : TEXT, HTML
				String content = multi.getParameter("content");//게시물 내용
				String contentType = multi.getParameter("contentType");//게시물 타입
				if(contentType.equalsIgnoreCase("TEXT")) {
					content = NoticeUtilMgr.replace(content, "<", "&lt;");
				}
				//답변을 위한 ref
				int ref = getMaxNum()+1;
				
				con = pool.getConnection();
				sql = "insert tblNotice(name,content,subject,ref,pos,depth,";
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

		//Notice Max Num : ref에 저장에 필요한 값
		public int getMaxNum() {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			int maxNum = 0;
			try {
				con = pool.getConnection();
				sql = "select max(num) from tblNotice";
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
		
		//Notice Total Count : 총 게시물수
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
					//검색이 아닌 경우
					sql = "select count(*) from tblNotice";
					pstmt = con.prepareStatement(sql);
				} else {
					sql = "select count(*) from tblNotice where " + keyField +" like ?";
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
		
		//Notice List : keyField, keyWord, start(시작번호), cnt(한 페이지당 가져울 게시물 개수)
		public Vector<NoticeBean> getNoticeList
		(String keyField, String keyWord, int start, int cnt){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			Vector<NoticeBean> vlist = new Vector<NoticeBean>();
			try {
				con = pool.getConnection();
				if(keyWord.trim().equals("")||keyWord==null) {//검색이 아닌 경우
					sql = "select * from tblNotice order by ref desc, pos limit ?,?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, start);
					pstmt.setInt(2, cnt);
				} else {//검색인 경우
					sql = "select * from tblNotice  where " + keyField +" like ? ";
					sql+= "order by ref desc, pos limit ?, ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "%"+keyWord+"%");
					pstmt.setInt(2, start);
					pstmt.setInt(3, cnt);
				}
				rs = pstmt.executeQuery();
				while(rs.next()) {
					NoticeBean bean = new NoticeBean();
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
		
		//Notice Read : 게시물 한개 읽어오기
		public NoticeBean getNotice(int num) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			NoticeBean bean = new NoticeBean();
			try {
				con = pool.getConnection();
				sql = "select * from tblNotice where num=?";
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
		
		//Count up : 조회수 증가
	 	public void upCount(int num) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				con = pool.getConnection();
				sql = "update tblNotice set count = count +1 where num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
		}
		
		//Notice Delete : 게시물 삭제(업로드 파일까지 삭제)
	 	public void deleteNotice(int num) {
	 		Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				con = pool.getConnection();
				//게시물이 삭제되기 전에 파일명 확보
				String filename = getNotice(num).getFilename();
				sql = "delete from tblNotice where num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				if(pstmt.executeUpdate()==1) {//정상적으로 삭제가 되었다면 파일도 삭제
					if(filename!=null&&!filename.equals("")) {
						File f = new File(SAVEDIRECTORY+filename);
						if(f.exists()) {
							NoticeUtilMgr.delete(SAVEDIRECTORY+filename);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
	 	}
		
	
		//Notice Update : 게시물 수정 (업로드 파일까지 수정)
		public void updateNotice2(MultipartRequest mulit) {
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
					//기존에 파일은 삭제
					NoticeBean bean = getNotice(num);
					String tempFile = bean.getFilename();
					//있을수도 있고 없을수도 있다.
					if(tempFile!=null&&!tempFile.equals("")) {
						File f = new File(SAVEDIRECTORY+tempFile);
						if(f.exists()) NoticeUtilMgr.delete(SAVEDIRECTORY+tempFile);
					}
					int filesize = (int)mulit.getFile("filename").length();
					sql = "update tblNotice set name=?, subject=?, content=?, filename=?, "
							+ "filesize=? where num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, name);
					pstmt.setString(2, subject);
					pstmt.setString(3, content);
					pstmt.setString(4, filename);
					pstmt.setInt(5, filesize);
					pstmt.setInt(6, num);
				}else {
					sql = "update tblNotice set name=?, subject=?, content=? where num=?";
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
	 	
		//Notice Reply : 게시물 답변 -> 파일업로드 기능 없음
		public void replyNotice(NoticeBean bean) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				con = pool.getConnection();
				sql = "insert tblNotice(name,content,subject,ref,pos,depth,regdate,";
				sql+= "pass,count,ip)values(?, ?, ?, ?, ?, ?, now(), ?, 0, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getName());
				pstmt.setString(2, bean.getContent());
				pstmt.setString(3, bean.getSubject());
				///////////////////////////////////
				pstmt.setInt(4, bean.getRef());//원글과 동일한 ref -> 답변글의 그룹의 기능
				pstmt.setInt(5, bean.getPos()+1);//원글의 pos+1
				pstmt.setInt(6, bean.getDepth()+1);//원글과의 depth+1
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
	 	
		//Notice Reply Up : 답변글 위치값 조정
	 	public void replyUpNotice(int ref, int pos) {
	 		Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				con = pool.getConnection();
				sql = "update tblNotice set pos=pos+1 where ref=? and pos>?";
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
		
		//Post 1000 : 게시물 1000개 입력
		public void post1000(){
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				con = pool.getConnection();
				sql = "insert tblNotice(name,content,subject,ref,pos,depth,regdate,pass,count,ip,filename,filesize)";
				sql+="values('aaa', 'bbb', 'ccc', 0, 0, 0, now(), '1111',0, '127.0.0.1', null, 0);";
				pstmt = con.prepareStatement(sql);
				for (int i = 0; i < 1000; i++) {
					pstmt.executeUpdate();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
		}
		
		public static void main(String[] args) {
			NoticeMgr mgr = new NoticeMgr();
			//mgr.insertNotice(null);
			//System.out.println("폴더생성확인");
			mgr.post1000();
			//System.out.println(10.0/3);//실수/정수 -> 실수/실수
		}
	
}
