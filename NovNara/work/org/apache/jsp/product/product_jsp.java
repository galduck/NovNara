/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-01-19 03:08:04 UTC
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
    _jspx_dependants.put("/product/../top.jsp", Long.valueOf(1642555152000L));
    _jspx_dependants.put("/product/../bottom.jsp", Long.valueOf(1642129362000L));
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
	int sort = 0;
	//검색에 필요한 변수
	String keyWord = "";
	Vector<ProductBean> pvlist = null;
	//검색일때
	if(request.getParameter("keyWord")!=null){
		keyWord = request.getParameter("keyWord");
		pvlist = pMgr.getSearchList(keyWord);
	}else if(request.getParameter("sort")!=null){
		sort = UtilMgr.parseInt(request, "sort");
		pvlist = pMgr.getProductList(sort);
	}else{
		pvlist = pMgr.getProductList(sort);
	}


      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>NovNara</title>\r\n");
      out.write("<script src=\"script.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/style.css\" />\r\n");
      out.write("<script>\r\n");
      out.write("function check() {\r\n");
      out.write("	if(document.searchFrm.keyWord.value==\"\"){\r\n");
      out.write("		alert(\"검색어를 입력하세요.\");\r\n");
      out.write("		document.searchFrm.keyWord.focus();\r\n");
      out.write("		return;\r\n");
      out.write("	}\r\n");
      out.write("	document.searchFrm.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function list() {//검색을 통해서 url에 남은 get방식 조건값 초기화\r\n");
      out.write("	document.listFrm.action=\"../product/product.jsp\";\r\n");
      out.write("	document.listFrm.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
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
      out.write("<div class=\"member-buttons\">\r\n");
      out.write("    <button class=\"btn\" >");
      out.print(log );
      out.write("</button>\r\n");
      out.write("    <button class=\"btn\" >");
      out.print(reg);
      out.write("</button>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"giant-box\">\r\n");
      out.write("    <div class=\"oatmeal-box\">\r\n");
      out.write("       	<div class=\"nav-icons\">\r\n");
      out.write("       		<div>\r\n");
      out.write("       			<a href=\"../qna/qnaList.jsp\">\r\n");
      out.write("       				<i class=\"fas fa-question-circle fa-lg\"></i>\r\n");
      out.write("       			</a>\r\n");
      out.write("       		</div>\r\n");
      out.write("       		\r\n");
      out.write("       		<div>\r\n");
      out.write("       			<a href=\"../cart/cartList.jsp\">\r\n");
      out.write("       				<i class=\"fas fa-shopping-basket fa-lg\"></i>\r\n");
      out.write("       			</a>\r\n");
      out.write("   			</div>\r\n");
      out.write("   			<div>\r\n");
      out.write("       			<a href=\"../member/memberUpdate.jsp\">\r\n");
      out.write("       				<i class=\"fas fa-user-edit fa-lg\"></i>\r\n");
      out.write("       			</a>\r\n");
      out.write("       		</div>\r\n");
      out.write("          	<div>\r\n");
      out.write("	          	<a href=\"../order/orderList.jsp\">\r\n");
      out.write("		          	<i class=\"fas fa-bars fa-lg\" ></i>\r\n");
      out.write("	          	</a>\r\n");
      out.write("          	</div> \r\n");
      out.write("          	\r\n");
      out.write("   		</div>  \r\n");
      out.write("            \r\n");
      out.write("        <div class=\"logo-box\">\r\n");
      out.write("            <img src=\"../img/logo2.png\" class=\"logo2\" />\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"menu\">\r\n");
      out.write("            <span class=\"home\" ><a href=\"../notice/noticeList.jsp\">공지사항</a></span>\r\n");
      out.write("            <span class=\"best\"><a href=\"../product/best.jsp\" >베스트</a></span>\r\n");
      out.write("            <span class=\"product\"><a href=\"../product/product.jsp?sort=0\" >전체상품</a></span>\r\n");
      out.write("            <span class=\"objet\"><a href=\"../product/product.jsp?sort=1\" >소품</a></span>\r\n");
      out.write("            <span class=\"light\"><a href=\"../product/product.jsp?sort=2\" >조명</a></span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"search-box\">\r\n");
      out.write("            <div>\r\n");
      out.write("   				<form class=\"search\" name=\"searchFrm\" method=\"get\" action=\"../product/product.jsp\">\r\n");
      out.write("	        		<input class=\"search_input\" name=\"keyWord\" type=\"text\" placeholder=\"검색어를 입력해주세요\" > \r\n");
      out.write("					<div>\r\n");
      out.write("	                	<a href=\"javascript:check()\" >\r\n");
      out.write("		                	<i class=\"fas fa-search fa-2x\"></i>\r\n");
      out.write("	                	</a>\r\n");
      out.write("	                </div>\r\n");
      out.write("				</form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("		\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/6478f529f2.js\"\r\n");
      out.write("crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");

	Vector<ProductBean> vlist = pMgr.getSearchList(keyWord);
	int listSize = vlist.size();//브라우저 화면에 표시될 번호
	if(vlist.isEmpty()){
		out.println("등록된 게시물이 없습니다.");
	}else{

      out.write("\r\n");
      out.write("<div class=\"one_more_product_cover\">\r\n");
      out.write("<div class=\"total_product_cover\">\r\n");
      out.write("		\r\n");
      out.write("		");

					for(int i=0;i<pvlist.size();i++){
						ProductBean pbean = pvlist.get(i);
		
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"total_product\">\r\n");
      out.write("			<a href=\"../product/productDetail.jsp?no=");
      out.print(pbean.getNo() );
      out.write("\">\r\n");
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
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		");
}
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
}//--if-else
      out.write("\r\n");
      out.write("	<form name=\"listFrm\" method=\"post\">\r\n");
      out.write("		<input type=\"hidden\" name=\"reload\" value=\"true\">\r\n");
      out.write("	</form>\r\n");
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
