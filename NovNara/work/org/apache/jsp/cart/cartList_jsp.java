/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-01-17 02:44:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import novNara.UtilMgr;
import novNara.ProductBean;
import java.util.Enumeration;
import novNara.OrderBean;
import java.util.Hashtable;

public final class cartList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/cart/../bottom.jsp", Long.valueOf(1642129362000L));
    _jspx_dependants.put("/cart/../top.jsp", Long.valueOf(1642387252000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Enumeration");
    _jspx_imports_classes.add("novNara.OrderBean");
    _jspx_imports_classes.add("novNara.UtilMgr");
    _jspx_imports_classes.add("novNara.ProductBean");
    _jspx_imports_classes.add("java.util.Hashtable");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- cartList.jsp -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      novNara.CartMgr cMgr = null;
      synchronized (session) {
        cMgr = (novNara.CartMgr) _jspx_page_context.getAttribute("cMgr", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (cMgr == null){
          cMgr = new novNara.CartMgr();
          _jspx_page_context.setAttribute("cMgr", cMgr, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      novNara.ProductMgr pMgr = null;
      pMgr = (novNara.ProductMgr) _jspx_page_context.getAttribute("pMgr", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (pMgr == null){
        pMgr = new novNara.ProductMgr();
        _jspx_page_context.setAttribute("pMgr", pMgr, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');

		request.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		if(session.getAttribute("idKey")==null){
			response.sendRedirect(path+"/login/login.jsp");
			return;
		}
		Hashtable<Integer, OrderBean> hCart = cMgr.getCartList();
		int totalPrice = 0;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>NovNara</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/style.css\" />\r\n");
      out.write("<script src=\"../member/script.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body  topmargin=\"100\">\r\n");
      out.write('\r');
      out.write('\n');

	String id = (String)session.getAttribute("idKey");
	
	String log="";
	if(id == null) log ="<a href=../login/login.jsp>로그인</a>";
	else log = "<a href=../login/logout.jsp>로그아웃</a>";

	String reg="";
	if(id == null) reg ="<a href=../member/member.jsp>회원가입</a>";
	else reg = "<a href=../member/memberUpdate.jsp>마이페이지</a>";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"member-buttons\">\r\n");
      out.write("    <button class=\"btn\" >");
      out.print(log );
      out.write("</button>\r\n");
      out.write("    <button class=\"btn\" >");
      out.print(reg);
      out.write("</button>\r\n");
      out.write("</div>\r\n");
      out.write("	<div class=\"giant-box\">\r\n");
      out.write("	    <div class=\"oatmeal-box\">\r\n");
      out.write("	       	<div class=\"nav-icons\">\r\n");
      out.write("	       		<div>\r\n");
      out.write("	       			<i class=\"fas fa-question-circle fa-lg\"></i>\r\n");
      out.write("	       		</div>\r\n");
      out.write("	       		<div>\r\n");
      out.write("	       			<a href=\"../cart/cartList.jsp\">\r\n");
      out.write("	       				<i class=\"fas fa-shopping-basket fa-lg\"></i>\r\n");
      out.write("	       			</a>\r\n");
      out.write("	   			</div>\r\n");
      out.write("	          	<div>\r\n");
      out.write("		          	<a href=\"../order/orderList.jsp\">\r\n");
      out.write("			          	<i class=\"fas fa-bars fa-lg\" ></i>\r\n");
      out.write("		          	</a>\r\n");
      out.write("	          	</div> \r\n");
      out.write("	          	\r\n");
      out.write("	   		</div>  \r\n");
      out.write("	            \r\n");
      out.write("	        <div class=\"logo-box\">\r\n");
      out.write("	            <img src=\"../img/logo2.png\" class=\"logo2\" />\r\n");
      out.write("	        </div>\r\n");
      out.write("	        <div class=\"menu\">\r\n");
      out.write("	            <span class=\"home\" ><a href=\"../notice/notice.jsp\">공지사항</a></span>\r\n");
      out.write("	            <span class=\"best\"><a href=\"../product/best.jsp\" >베스트</a></span>\r\n");
      out.write("	            <span class=\"product\"><a href=\"../product/product.jsp?sort=0\" >전체상품</a></span>\r\n");
      out.write("	            <span class=\"objet\"><a href=\"../product/product.jsp?sort=1\" >소품</a></span>\r\n");
      out.write("	            <span class=\"light\"><a href=\"../product/product.jsp?sort=2\" >조명</a></span>\r\n");
      out.write("	        </div>\r\n");
      out.write("	        <div class=\"search-box\">\r\n");
      out.write("	            <div class=\"search\">\r\n");
      out.write("	        		<input class=\"search_input\" type=\"text\" placeholder=\"검색어를 입력해주세요\" > \r\n");
      out.write("	                <div>\r\n");
      out.write("	                	<a href=\"#\">\r\n");
      out.write("		                	<i class=\"fas fa-search fa-2x\"></i>\r\n");
      out.write("	                	</a>\r\n");
      out.write("	                </div>\r\n");
      out.write("	            </div>\r\n");
      out.write("	        </div>\r\n");
      out.write("	    </div>\r\n");
      out.write("	</div>\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/6478f529f2.js\"\r\n");
      out.write("crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("<div class=\"table_div\">\r\n");
      out.write("<table width=\"75%\" align=\"center\" >\r\n");
      out.write("<tr>\r\n");
      out.write("<td align=\"center\" >\r\n");
      out.write("	<table width=\"95%\" align=\"center\"  border=\"1\">\r\n");
      out.write("		<tr align=\"center\" >\r\n");
      out.write("			<td class=\"order_td\">제품</font></td>\r\n");
      out.write("			<td class=\"order_td\">수량</font></td>\r\n");
      out.write("			<td class=\"order_td\">가격</font></td>\r\n");
      out.write("			<td class=\"order_td\">수정 / 삭제</font></td>\r\n");
      out.write("			<td class=\"order_td\">조회</font></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		");
if(hCart.isEmpty()){ 
      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td class=\"order_td\" colspan=\"5\" align=\"center\">장바구니는 비어 있습니다.</td>\r\n");
      out.write("		</tr>	\r\n");
      out.write("		");
}else{
				//해쉬테이블에서 저장된 객체의 키값을 가져옴.
				//Enumeration  : 줄줄이 사탕 객체
				Enumeration<Integer> hCartKey = hCart.keys();
				while(hCartKey.hasMoreElements()){
					//키값으로 주문객체를 리턴
					OrderBean order = hCart.get(hCartKey.nextElement());
					int productNo = order.getProductNo();
					//상품번호로 상품정보 리턴
					ProductBean pbean = pMgr.getProduct(productNo);
					String pName = pbean.getName();//상품이름
					int price = pbean.getPrice();//상품가격
					int quantity = order.getQuantity();//주문수량
					int subTotal = price * quantity;//주문가격
					//전체주문가격
					totalPrice+=subTotal;
		
      out.write("\r\n");
      out.write("		<tr align=\"center\">\r\n");
      out.write("		<form method=\"post\" action=\"cartProc.jsp\">\r\n");
      out.write("			<input type=\"hidden\" name=\"productNo\" \r\n");
      out.write("			value=\"");
      out.print(productNo);
      out.write("\">\r\n");
      out.write("			<td class=\"order_td\">");
      out.print(pName);
      out.write("</td>\r\n");
      out.write("			<td class=\"order_td\"><input name=\"quantity\" style = \"text-align:right;\" \r\n");
      out.write("				value=\"");
      out.print(quantity);
      out.write("\" size=\"3\">개</td>\r\n");
      out.write("			<td class=\"order_td\">");
      out.print(UtilMgr.monFormat(subTotal));
      out.write("</td>\r\n");
      out.write("			<td class=\"order_td\">\r\n");
      out.write("				<input class=\"btn\" type=\"button\" value=\"수정\" size=\"3\" onclick=\"javascript:cartUpdate(this.form)\">\r\n");
      out.write("				<input class=\"btn\" type=\"button\" value=\"삭제\" size=\"3\" onclick=\"javascript:cartDelete(this.form)\">\r\n");
      out.write("			</td>\r\n");
      out.write("			<td class=\"order_td\">\r\n");
      out.write("				<a href=\"javascript:productDetail('");
      out.print(productNo);
      out.write("')\">상세보기</a>\r\n");
      out.write("			</td>\r\n");
      out.write("			<input type=\"hidden\" name=\"flag\">\r\n");
      out.write("			</form>\r\n");
      out.write("		</tr>\r\n");
      out.write("		");
}//--while
      out.write("\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td class=\"order_td\" colspan=\"4\" align=\"right\">\r\n");
      out.write("				총 주문금액 : ");
      out.print(UtilMgr.monFormat(totalPrice));
      out.write("원	\r\n");
      out.write("			</td>\r\n");
      out.write("			<td class=\"order_td\" align=\"center\">\r\n");
      out.write("				<a href=\"../payment/payForm.jsp\">주문하기</a>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		");
}//--fi-else 
      out.write("\r\n");
      out.write("	</table>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<form name=\"detail\" method=\"post\" action=\"productDetail.jsp\" >\r\n");
      out.write("	<input type=\"hidden\" name=\"no\">\r\n");
      out.write("</form>	\r\n");
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("<footer class=\"footer\">\r\n");
      out.write("  <hr>\r\n");
      out.write("  <p class=\"copyright\">\r\n");
      out.write("  	<span class=\"span_admin\">\r\n");
      out.write("  		<button class=\"btn_admin\"><a href=\"../admin/index.jsp\">&copy; 2022. Miae Je</a></button>\r\n");
      out.write("  	</span>\r\n");
      out.write("  </p>\r\n");
      out.write("</footer>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
