/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-01-12 05:18:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import novNara.UtilMgr;
import novNara.ProductBean;
import java.util.Vector;

public final class product_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/product/../top.jsp", Long.valueOf(1641880764000L));
    _jspx_dependants.put("/product/../bottom.jsp", Long.valueOf(1641958542000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Vector");
    _jspx_imports_classes.add("novNara.UtilMgr");
    _jspx_imports_classes.add("novNara.ProductBean");
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

      out.write("<!-- productList.jsp -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      novNara.ProductMgr pMgr = null;
      pMgr = (novNara.ProductMgr) _jspx_page_context.getAttribute("pMgr", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (pMgr == null){
        pMgr = new novNara.ProductMgr();
        _jspx_page_context.setAttribute("pMgr", pMgr, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');

		request.setCharacterEncoding("UTF-8");
		Vector<ProductBean> pvlist = pMgr.getProductList();

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>NovNara</title>\r\n");
      out.write("<script src=\"script.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/style.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body  topmargin=\"100\">\r\n");
      out.write("	");
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
      out.write("	<div class=\"member-buttons\">\r\n");
      out.write("        <button class=\"btn\" >");
      out.print(log );
      out.write("</button>\r\n");
      out.write("        <button class=\"btn\" >");
      out.print(reg);
      out.write("</button>\r\n");
      out.write("    </div>\r\n");
      out.write("    <nav class=\"giant-box\">\r\n");
      out.write("        <div class=\"oatmeal-box\">\r\n");
      out.write("            <div class=\"nav-icons\">\r\n");
      out.write("                <i class=\"fas fa-search fa-lg\"></i>\r\n");
      out.write("                <i class=\"fas fa-shopping-basket fa-lg\"><a href=\"../cart/cartList.jsp\"></a></i>\r\n");
      out.write("\r\n");
      out.write("                <label class=\"list\" for=\"list\"> <i class=\"fas fa-bars fa-lg\" ></i></label>\r\n");
      out.write("	                <input id=\"list\" type=\"checkbox\">\r\n");
      out.write("	                <nav id=\"main_nav\">\r\n");
      out.write("	                	<ul>\r\n");
      out.write("	                		<li><a href=\"../product/product.jsp\">전체상품</a></li>\r\n");
      out.write("    						<li><a href=\"../cart/cartList.jsp\">장바구니</a></li>\r\n");
      out.write("    						<li><a href=\"../order/orderList.jsp\">구매목록</a></li>\r\n");
      out.write("	                	</ul>\r\n");
      out.write("	                </nav>\r\n");
      out.write("                \r\n");
      out.write("            </div>  \r\n");
      out.write("            <div class=\"logo-box\">\r\n");
      out.write("                <img src=\"../img/logo2.png\" class=\"logo2\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"menu\">\r\n");
      out.write("                <span class=\"home\" ><a href=\"../index.jsp\">홈</a></span>\r\n");
      out.write("                <span class=\"best\"><a href=\"../product/best.jsp\" >베스트</a></span>\r\n");
      out.write("                <span class=\"product\"><a href=\"../product/product.jsp\" >전체상품</a></span>\r\n");
      out.write("                <span class=\"objet\"><a href=\"../product/objet.jsp\" >소품</a></span>\r\n");
      out.write("                <span class=\"light\"><a href=\"../product/light.jsp\" >조명</a></span>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"search-box\">\r\n");
      out.write("                <div class=\"search\">\r\n");
      out.write("                    <i class=\"fas fa-search fa-2x\"></i>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("    <script\r\n");
      out.write("    src=\"https://kit.fontawesome.com/6478f529f2.js\"\r\n");
      out.write("    crossorigin=\"anonymous\"\r\n");
      out.write("  ></script>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"total_product_cover\">\r\n");
      out.write("		");

					for(int i=0;i<pvlist.size();i++){
						ProductBean pbean = pvlist.get(i);
		
      out.write("\r\n");
      out.write("		<div class=\"total_product\">\r\n");
      out.write("			<a href=\"../product/productDetail.jsp?no=('");
      out.print(pbean.getNo() );
      out.write("')\">\r\n");
      out.write("			<div class=\"total_product_div total_product_img\" >					\r\n");
      out.write("				<img src=\"../img/");
      out.print(pbean.getImage() );
      out.write("\" height=\"380px\" width=\"430px\" >\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"total_product_div\">");
      out.print(pbean.getName() );
      out.write("</div>\r\n");
      out.write("			<div class=\"total_product_div\">");
      out.print(UtilMgr.monFormat(pbean.getPrice()));
      out.write("</div>\r\n");
      out.write("			<form name=\"detail\" method=\"post\" action=\"../product/productDetail.jsp\" >\r\n");
      out.write("				<input type=\"hidden\" name=\"no\">\r\n");
      out.write("			</form>\r\n");
      out.write("			</a>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		");
}
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
