/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-01-18 03:38:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import novNara.NoticeBean;
import novNara.NoticeUtilMgr;

public final class noticeDelete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/notice/../top.jsp", Long.valueOf(1642471774000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("novNara.NoticeBean");
    _jspx_imports_classes.add("novNara.NoticeUtilMgr");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      novNara.NoticeMgr mgr = null;
      mgr = (novNara.NoticeMgr) _jspx_page_context.getAttribute("mgr", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (mgr == null){
        mgr = new novNara.NoticeMgr();
        _jspx_page_context.setAttribute("mgr", mgr, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
 
		request.setCharacterEncoding("UTF-8");
		String nowPage = request.getParameter("nowPage");
		int num = NoticeUtilMgr.parseInt(request, "num");
		//비번을 입력을 받아서 삭제를 처리하는 기능
		if(request.getParameter("pass")!=null){
			NoticeBean bean = (NoticeBean)session.getAttribute("bean");
			String inPass = request.getParameter("pass");//delete.jsp입력한 pass값
			String dbPass = bean.getPass();//테이블에 저장된 pass
			//inPass==dbPass : 클래스은 타입은 객체의 주소값을 비교
			//int a==int b : 자바기본형은 값을 비교 
			if(inPass.equals(dbPass)/*객체내용비교*/){
				mgr.deleteNotice(num);
				String url = "noticeList.jsp?nowPage"+nowPage;
				response.sendRedirect(url);
			}else{
      out.write("\r\n");
      out.write("				<script type=\"text/javascript\">\r\n");
      out.write("					alert(\"입력하신 비밀번호가 아닙니다.\");\r\n");
      out.write("					history.back();\r\n");
      out.write("				</script>\r\n");
      out.write("			");
}
		}else{//비번을 입력받기 위한 폼 출력

      out.write("\r\n");
      out.write("<title>JSP Notice</title>\r\n");
      out.write("<link href=\"../css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	function check() {\r\n");
      out.write("		if (document.delFrm.pass.value == \"\") {\r\n");
      out.write("			alert(\"패스워드를 입력하세요.\");\r\n");
      out.write("			document.delFrm.pass.focus();\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		document.delFrm.submit();\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body >\r\n");
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
      out.write("       			<i class=\"fas fa-question-circle fa-lg\"></i>\r\n");
      out.write("       		</div>\r\n");
      out.write("       		<div>\r\n");
      out.write("       			<a href=\"../cart/cartList.jsp\">\r\n");
      out.write("       				<i class=\"fas fa-shopping-basket fa-lg\"></i>\r\n");
      out.write("       			</a>\r\n");
      out.write("   			</div>\r\n");
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
      out.write("<div align=\"center\"><br/><br/>\r\n");
      out.write("	<h3>사용자의 비밀번호를 입력해주세요.</h3>\r\n");
      out.write("	<form name=\"delFrm\" method=\"post\">\r\n");
      out.write("		<table width=\"70%\" cellspacing=\"0\" cellpadding=\"2\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td  class=\"table_td\" align=\"center\">\r\n");
      out.write("					<table width=80%>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td  class=\"table_td\" align=\"center\">\r\n");
      out.write("								<input type=\"password\" name=\"pass\" size=\"17\" maxlength=\"15\">\r\n");
      out.write("							</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td class=\"table_td\" ><hr size=\"1\" color=\"#eeeeee\"/></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td class=\"table_td\"  align=\"center\">\r\n");
      out.write("								<input class=\"btn\" type=\"button\" value=\"삭제완료\" onClick=\"check()\"> \r\n");
      out.write("								<input class=\"btn\" type=\"reset\" value=\"다시쓰기\">\r\n");
      out.write("								<input class=\"btn\" type=\"button\" value=\"뒤로\" onClick=\"history.go(-1)\">\r\n");
      out.write("							</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</table>\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		<input type=\"hidden\" name=\"nowPage\" value=\"");
      out.print(nowPage);
      out.write("\"> \r\n");
      out.write("		<input type=\"hidden\" name=\"num\" value=\"");
      out.print(num);
      out.write("\">\r\n");
      out.write("	</form>\r\n");
      out.write("</div>\r\n");
}
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
