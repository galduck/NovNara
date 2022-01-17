package novNara;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import novNara.DBConnectionMgr;

public class ProductMgr {

	private DBConnectionMgr pool;
	public static final String SAVEDIRECTORY = 
			"D:/Jsp/NovNara/NovNara/src/main/webapp/img";
	public static final String ENCODING = "UTF-8";
	public static final int MAXPOSTSIZE = 10*1024*1024;//10mb
	
	public ProductMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//Product List
	public Vector<ProductBean> getProductList(int sort){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<ProductBean> vlist = new Vector<ProductBean>();
		try {
			con = pool.getConnection();
			if(sort==0) {
				sql = "select no, sort, name, price, date, stock, image from tblProduct "
					+ "order by no desc";
				pstmt = con.prepareStatement(sql);
			}else {
				sql = "select no, sort, name, price, date, stock, image from tblProduct where sort = ? "
						+ "order by no desc";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, sort);
				
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setNo(rs.getInt(1));
				bean.setSort(rs.getInt(2));
				bean.setName(rs.getString(3));
				bean.setPrice(rs.getInt(4));
				bean.setDate(rs.getString(5));
				bean.setStock(rs.getInt(6));
				bean.setImage(rs.getString(7));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}
	
	//Product Detail
	//select no, name, price, detail, date, stock, image
	//from tblProduct where no=?
	public ProductBean getProduct(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		ProductBean bean = new ProductBean();
		try {
			con = pool.getConnection();
			sql = "select no, sort, name, price, detail, date, stock, image "
					+ "from tblProduct where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setNo(rs.getInt(1));
				bean.setSort(rs.getInt(2));
				bean.setName(rs.getString(3));
				bean.setPrice(rs.getInt(4));
				bean.setDetail(rs.getString(5));
				bean.setDate(rs.getString(6));
				bean.setStock(rs.getInt(7));
				bean.setImage(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
	//Product Stock Reduce(구매 -> 재고수정)
	//update tblProduct set stock = stock-? where no=?
	public void reduceProduct(OrderBean order) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			con = pool.getConnection();
			sql = "update tblProduct set stock = stock-? where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order.getQuantity());//주문개수
			pstmt.setInt(2, order.getProductNo());//상품번호
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
	}
	
	///admin mode////
	
	//Product Insert
	//insert tblProduct(name,price,detail,date,stock,image)
	 //values(?,?,?,?,?,?)
	//이미지 파일업로드 아닐경우는 이미지명 : ready.gif
	public boolean insertProduct(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			MultipartRequest multi = new MultipartRequest(req, SAVEDIRECTORY,
					MAXPOSTSIZE, ENCODING, new DefaultFileRenamePolicy());
			con = pool.getConnection();
			sql = "insert tblProduct(sort,name,price,detail,date,stock,image)"
					+ "values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(multi.getParameter("sort")) );
			pstmt.setString(2, multi.getParameter("name"));
			pstmt.setInt(3, Integer.parseInt(multi.getParameter("price")));
			pstmt.setString(4, multi.getParameter("detail"));
			pstmt.setString(5, UtilMgr.getDay());
			pstmt.setInt(6, Integer.parseInt(multi.getParameter("stock")));
			if(multi.getFilesystemName("image")!=null)
				pstmt.setString(7, multi.getFilesystemName("image"));
			else
				pstmt.setString(7, "ready.gif");
			if(pstmt.executeUpdate()==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	//Product Update : 이미지 파일 수정 유무.
	public boolean updateProduct(HttpServletRequest req) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			MultipartRequest multi = new MultipartRequest(req, SAVEDIRECTORY,
					MAXPOSTSIZE, ENCODING, new DefaultFileRenamePolicy());
			con = pool.getConnection();
			if(multi.getFilesystemName("image")!=null) {//이미지도 수정
				sql = "update tblProduct set sort=?, name=?, price=?,"
						+ "detail=?, stock=?, image=? where no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(multi.getParameter("sort")));
				pstmt.setString(2, multi.getParameter("name"));
				pstmt.setInt(3, Integer.parseInt(multi.getParameter("price")));
				pstmt.setString(4, multi.getParameter("detail"));
				pstmt.setInt(5, Integer.parseInt(multi.getParameter("stock")));
				pstmt.setString(6, multi.getFilesystemName("image"));
				pstmt.setInt(7, Integer.parseInt(multi.getParameter("no")));
			}else {//이미지 수정 아님.
				sql = "update tblProduct set sort=?, name=?, price=?,"
						+ "detail=?, stock=? where no=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(multi.getParameter("sort")));
				pstmt.setString(2, multi.getParameter("name"));
				pstmt.setInt(3, Integer.parseInt(multi.getParameter("price")));
				pstmt.setString(4, multi.getParameter("detail"));
				pstmt.setInt(5, Integer.parseInt(multi.getParameter("stock")));
				pstmt.setInt(6, Integer.parseInt(multi.getParameter("no")));
			}
			if(pstmt.executeUpdate()==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	//Product Delete : 상품 이미지는 삭제하지 않음.
	public boolean deleteProduct(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from tblProduct where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			if(pstmt.executeUpdate()==1) 
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	

	
	//Stock List
		public Vector<ProductBean> getStockList(){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			Vector<ProductBean> vlist = new Vector<ProductBean>();
			try {
				con = pool.getConnection();
				sql = "select no, sort, name, price, date, stock, image from tblProduct "
				+ "order by stock";
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					ProductBean bean = new ProductBean();
					bean.setNo(rs.getInt(1));
					bean.setSort(rs.getInt(2));
					bean.setName(rs.getString(3));
					bean.setPrice(rs.getInt(4));
					bean.setDate(rs.getString(5));
					bean.setStock(rs.getInt(6));
					bean.setImage(rs.getString(7));
					vlist.addElement(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;
		}
	
		//Search Product
		public Vector<ProductBean> getSearchList(String keyword){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			Vector<ProductBean> vlist = new Vector<ProductBean>();
			try {
				con = pool.getConnection();
				sql = "select * from tblProduct where name like ? order by no";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,  "%" + keyword + "%");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					ProductBean bean = new ProductBean();
					bean.setNo(rs.getInt(1));
					bean.setSort(rs.getInt(2));
					bean.setName(rs.getString(3));
					bean.setPrice(rs.getInt(4));
					bean.setDate(rs.getString(5));
					bean.setStock(rs.getInt(6));
					bean.setImage(rs.getString(7));
					vlist.addElement(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return vlist;
		}
		
		
		
		
}


















