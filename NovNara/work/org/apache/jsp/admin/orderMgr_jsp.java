/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-01-14 05:13:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import novNara.*;

public final class orderMgr_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/admin/top.jsp", Long.valueOf(1642137112000L));
    _jspx_dependants.put("/admin/../bottom.jsp", Long.valueOf(1642129362000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("novNara");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      novNara.OrderMgr orderMgr = null;
      orderMgr = (novNara.OrderMgr) _jspx_page_context.getAttribute("orderMgr", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (orderMgr == null){
        orderMgr = new novNara.OrderMgr();
        _jspx_page_context.setAttribute("orderMgr", orderMgr, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      novNara.ProductMgr pMgr = null;
      pMgr = (novNara.ProductMgr) _jspx_page_context.getAttribute("pMgr", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (pMgr == null){
        pMgr = new novNara.ProductMgr();
        _jspx_page_context.setAttribute("pMgr", pMgr, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>NovNara</title>\r\n");
      out.write("<link href=\"../css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script src=\"script.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body topmargin=\"100\">\r\n");
      out.write('\r');
      out.write('\n');

    String admin_id = (String)session.getAttribute("adminKey");

	if(admin_id == null) {
		response.sendRedirect("adminLogin.jsp");
	}

      out.write("\r\n");
      out.write("<form class=\"member-buttons\" name=\"input\" action=\"../admin/adminLogout.jsp\" method=\"get\">\r\n");
      out.write("	<input class=\"btn\" type=\"submit\" value=\"로그아웃\" >\r\n");
      out.write("</form>\r\n");
      out.write("<nav class=\"giant-box\">\r\n");
      out.write("    <div class=\"oatmeal-box\">\r\n");
      out.write("        <div class=\"nav-icons\">\r\n");
      out.write("            <i class=\"fas fa-shopping-basket fa-lg\"><a href=\"../cart/cartList.jsp\"></a></i>\r\n");
      out.write("         <i class=\"fas fa-bars fa-lg\" ><a href=\"../order/orderList.jsp\"></a></i>\r\n");
      out.write("        </div>  \r\n");
      out.write("        <div class=\"logo-box\">\r\n");
      out.write("            <img src=\"../img/logo2.png\" class=\"logo2\" />\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"menu\">\r\n");
      out.write("            <span class=\"home\" ><a href=\"../index.jsp\">홈</a></span>\r\n");
      out.write("            <span class=\"product\"><a href=\"memberMgr.jsp\" >회원관리</a></span>\r\n");
      out.write("            <span class=\"objet\"><a href=\"productMgr.jsp\" >상품관리</a></span>\r\n");
      out.write("            <span class=\"light\"><a href=\"orderMgr.jsp\">주문관리</a></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"search-box\">\r\n");
      out.write("            <div class=\"search\">\r\n");
      out.write("                <i class=\"fas fa-search fa-2x\"></i>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write(" <script src=\"https://kit.fontawesome.com/6478f529f2.js\"\r\n");
      out.write("crossorigin=\"anonymous\"></script>");
      out.write("\r\n");
      out.write("<div class=\"h1_title table_title\">주문 관리</div>\r\n");
      out.write("<div class=\"table_div\">\r\n");
      out.write("<table width=\"75%\" align=\"center\">\r\n");
      out.write("<tr> \r\n");
      out.write("<td align=\"center\">\r\n");
      out.write("\r\n");
      out.write("	<table width=\"95%\" align=\"center\">\r\n");
      out.write("	<tr  align=\"center\"> \r\n");
      out.write("		<td>주문번호</td>\r\n");
      out.write("		<td>주문자<td>\r\n");
      out.write("		<td>제품명</td>\r\n");
      out.write("		<td>주문수량</td>\r\n");
      out.write("		<td>주문날짜</td>\r\n");
      out.write("		<td>주문상태</td>\r\n");
      out.write("		<td>상세보기</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	");

			Vector<OrderBean> vlist = orderMgr.getOrderList();
			if(vlist.isEmpty()){
	
      out.write("\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td align=\"center\" colspan=\"7\">주문내역이 없습니다.</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	");
}else{
			for(int i=0;i<vlist.size();i++){
				OrderBean order/*주문 정보*/ = vlist.get(i);
				ProductBean product/*제품정보*/ = pMgr.getProduct(order.getProductNo());
	
      out.write("\r\n");
      out.write("	<tr align=\"center\">\r\n");
      out.write("		<td>");
      out.print(order.getNo());
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(order.getId());
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(product.getName());
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(order.getQuantity());
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(order.getDate());
      out.write("</td>\r\n");
      out.write("		<td>\r\n");
      out.write("		");

			switch(order.getState()){
				case "1" : out.println("접수중");break;
				case "2" : out.println("접수");break;
				case "3" : out.println("입금확인");break;
				case "4" : out.println("배송준비");break;
				case "5" : out.println("배송중");break;
				default : out.println("완료");
			}
		
      out.write("\r\n");
      out.write("		</td>\r\n");
      out.write("		<td><a href=\"javascript:orderDetail('");
      out.print(order.getNo());
      out.write("')\">상세보기</a></td>\r\n");
      out.write("	</tr>			\r\n");
      out.write("	");
	
				}//---for
			}//---if
	
      out.write("\r\n");
      out.write("	</table>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
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
      out.write("<form name=\"detail\" method=\"post\" action=\"orderDetail.jsp\" >\r\n");
      out.write("	<input type=\"hidden\" name=\"no\">\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
