package novNara;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/*Dao : Data Access Object*/
public class QnaCommentMgr {

	private DBConnectionMgr pool;

	public QnaCommentMgr() {	
		pool = DBConnectionMgr.getInstance();
	}

	//Comment Insert
		public void insertQnaComment(QnaCommentBean bean){
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				con = pool.getConnection();
				sql = "insert tblQnaComment(name,comment,regdate,num)values(?,?,now(),?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getName());
				pstmt.setString(2, bean.getComment());
				pstmt.setInt(3, bean.getNum());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
		}

		//Comment List
		public Vector<QnaCommentBean> getQnaComment(int num){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			 Vector<QnaCommentBean> vlist = new Vector<>();
			try {
				con = pool.getConnection();
				sql = "select * from tblQnaComment where num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				while(rs.next()){
					QnaCommentBean bean = new QnaCommentBean();
					bean.setCnum(rs.getInt("cnum"));
					bean.setName(rs.getString("name"));
					bean.setComment(rs.getString("comment"));
					bean.setRegdate(rs.getString("regdate"));
					bean.setNum(rs.getInt("num"));
					vlist.addElement(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;
		}

		//Comment Count : ´ñ±Û °³¼ö
		public int getQnaCommentCount(int num){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			int count  = 0;
			try {
				con = pool.getConnection();
				sql = "select count(num) from tblQnaComment where num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				if(rs.next())
					count = rs.getInt(1);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return count;
		}
		
		//Comment Delete
		public void deleteQnaComment(int cnum){
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				con = pool.getConnection();
				sql = "delete from tblQnaComment where cnum=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cnum);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
		}
		
		//Comment All Delete
		public void deleteAllQnaComment(int num){
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			try {
				con = pool.getConnection();
				sql = "delete from tblQnaComment where num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt);
			}
		}
}





















