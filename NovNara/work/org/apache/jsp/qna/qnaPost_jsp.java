/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-01-19 02:37:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.qna;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import novNara.*;

public final class qnaPost_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/qna/../top.jsp", Long.valueOf(1642555152000L));
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
      novNara.MemberMgr mMgr = null;
      mMgr = (novNara.MemberMgr) _jspx_page_context.getAttribute("mMgr", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (mMgr == null){
        mMgr = new novNara.MemberMgr();
        _jspx_page_context.setAttribute("mMgr", mMgr, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>NovNara</title>\r\n");
      out.write("<link href=\"../css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
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
      out.write('\r');
      out.write('\n');
      out.write('	');

		MemberBean mBean = mMgr.getMember(id);
	
      out.write("\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("<h3 class=\"h1_title\">Q&A 글쓰기</h3>\r\n");
      out.write("\r\n");
      out.write("<form name=\"postFrm\" method=\"post\" action=\"../qna/qnaPost\" \r\n");
      out.write("enctype=\"multipart/form-data\">\r\n");
      out.write("<table width=\"600\" cellpadding=\"3\" align=\"center\">\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td class=\"table_td\" align=center>\r\n");
      out.write("		<table align=\"center\">\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td class=\"table_td\" width=\"20%\">아이디</td>\r\n");
      out.write("				<td class=\"table_td\" width=\"80%\">\r\n");
      out.write("				");
      out.print(mBean.getId());
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td class=\"table_td\" >제 목</td>\r\n");
      out.write("				<td class=\"table_td\" >\r\n");
      out.write("				<input  class=\"table_td\" name=\"subject\" size=\"37\" maxlength=\"20\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td class=\"table_td\" >내 용</td>\r\n");
      out.write("				<td class=\"table_td\" ><textarea  class=\"table_td\" name=\"content\" rows=\"10\" cols=\"50\"></textarea></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td class=\"table_td\" >비밀 번호</td>\r\n");
      out.write("				<td class=\"table_td\" ><input  class=\"table_td\" type=\"password\" name=\"pass\" size=\"15\" maxlength=\"15\" value=\"1234\"></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("			 <tr>\r\n");
      out.write("     			<td class=\"table_td\" >파일찾기</td> \r\n");
      out.write("     			<td class=\"table_td\" ><input  class=\"table_td\" type=\"file\" name=\"filename\" size=\"50\" maxlength=\"50\"></td>\r\n");
      out.write("    		</tr>\r\n");
      out.write(" 			<tr>\r\n");
      out.write(" 				<td class=\"table_td\" >내용타입</td>\r\n");
      out.write(" 				<td class=\"table_td\" > HTML<input  class=\"table_td\" type=radio name=\"contentType\" value=\"HTTP\" >&nbsp;&nbsp;&nbsp;\r\n");
      out.write("  			 	TEXT<input  class=\"table_td\" type=radio name=\"contentType\" value=\"TEXT\" checked>\r\n");
      out.write("  			 	</td>\r\n");
      out.write(" 			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td  class=\"table_td\" colspan=\"2\"><hr/></td>\r\n");
      out.write("			</tr>\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td  class=\"table_td\" colspan=\"2\">\r\n");
      out.write("					 <input class=\"btn\" type=\"submit\" value=\"등록\">\r\n");
      out.write("					 <input  class=\"btn\" type=\"reset\" value=\"다시쓰기\">\r\n");
      out.write("					 <input  class=\"btn\" type=\"button\" value=\"리스트\" onClick=\"javascript:location.href='list.jsp'\">\r\n");
      out.write("				</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("		</table>\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>\r\n");
      out.write("<input type=\"hidden\" name=\"ip\" value=\"");
      out.print(request.getRemoteAddr());
      out.write("\">\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
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
