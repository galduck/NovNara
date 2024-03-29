/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.56
 * Generated at: 2022-01-22 08:06:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import novNara.NoticeBean;
import novNara.NoticeUtilMgr;

public final class noticeRead_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/notice/../top.jsp", Long.valueOf(1642838280000L));
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

      out.write("<!-- read.jsp -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      novNara.NoticeMgr mgr = null;
      mgr = (novNara.NoticeMgr) _jspx_page_context.getAttribute("mgr", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (mgr == null){
        mgr = new novNara.NoticeMgr();
        _jspx_page_context.setAttribute("mgr", mgr, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');

		request.setCharacterEncoding("UTF-8");
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		//nowPage 정수이지만 여기서는 계산이 되는 값이 아니고 
		//그대로 list.jsp로 넘기는 값이기 때문에 정수로 변환 안해된다.
		String nowPage = request.getParameter("nowPage");
		String numPerPage = request.getParameter("numPerPage");
		int num = NoticeUtilMgr.parseInt(request, "num");
		//조회수증가
		mgr.upCount(num);
		
		NoticeBean bean = mgr.getNotice(num);
		String name = bean.getName();
		String subject = bean.getSubject();
		String regdate = bean.getRegdate();
		String content = bean.getContent();
		String filename = bean.getFilename();
		int filesize = bean.getFilesize();
		String ip = bean.getIp();
		int count = bean.getCount();
		
		//읽어온 게시물을 답변과 수정, 삭제를 위해서 session 저장
		session.setAttribute("bean", bean);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>NovNara</title>\r\n");
      out.write("<link href=\"../css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	function down(filename) {\r\n");
      out.write("		document.downFrm.filename.value=filename;\r\n");
      out.write("		document.downFrm.submit();\r\n");
      out.write("	}\r\n");
      out.write("	function list() {\r\n");
      out.write("		document.listFrm.action = \"noticeList.jsp\";\r\n");
      out.write("		document.listFrm.submit();\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
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
      out.write("<div align=\"center\">\r\n");
      out.write("<h3 class=\"h1_title\">공지사항</h3>\r\n");
      out.write("<table align=\"center\" width=\"600\" cellspacing=\"3\">\r\n");
      out.write(" <tr>\r\n");
      out.write("  <td class=\"table_td\"  colspan=\"2\">\r\n");
      out.write("   <table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"> \r\n");
      out.write("    <tr> \r\n");
      out.write("  <td class=\"table_td\"  align=\"center\" bgcolor=\"#EAE1D8\" width=\"15%\">작성자</td>\r\n");
      out.write("  <td class=\"table_td\"  >관리자</td>\r\n");
      out.write("  <td class=\"table_td\"  align=\"center\" bgcolor=\"#EAE1D8\" width=\"15%\"> 등록날짜 </td>\r\n");
      out.write("  <td class=\"table_td\" >");
      out.print(regdate);
      out.write("</td>\r\n");
      out.write(" </tr>\r\n");
      out.write(" <tr> \r\n");
      out.write("    <td class=\"table_td\"  align=\"center\" bgcolor=\"#EAE1D8\"> 제 목</td>\r\n");
      out.write("    <td class=\"table_td\"  colspan=\"3\">");
      out.print(subject);
      out.write("</td>\r\n");
      out.write("   </tr>\r\n");
      out.write("   <tr> \r\n");
      out.write("     <td class=\"table_td\"  align=\"center\" bgcolor=\"#EAE1D8\">첨부파일</td>\r\n");
      out.write("     <td class=\"table_td\"  colspan=\"3\">\r\n");
      out.write("    	");
if(filename!=null&&!filename.equals("")){
      out.write("\r\n");
      out.write("    	 <a href=\"javascript:down('");
      out.print(filename);
      out.write("')\">");
      out.print(filename);
      out.write("</a>\r\n");
      out.write("    	 <font color=\"blue\">(");
      out.print(NoticeUtilMgr.intFormat(filesize));
      out.write("bytes)</font>\r\n");
      out.write("    	 ");
}else{ 
      out.write("\r\n");
      out.write("    	 	첨부된 파일이 없습니다.\r\n");
      out.write("    	 ");
}
      out.write("\r\n");
      out.write("     </td>\r\n");
      out.write("   </tr>\r\n");
      out.write("   <tr> \r\n");
      out.write("    <td class=\"table_td\"  colspan=\"4\"><br/><pre>");
      out.print(content);
      out.write("</pre><br/></td>\r\n");
      out.write("   </tr>\r\n");
      out.write("   <tr>\r\n");
      out.write("    <td class=\"table_td\"  colspan=\"4\" align=\"right\">\r\n");
      out.write("     ");
      out.print(ip);
      out.write("로 부터 글을 남기셨습니다./ 조회수 ");
      out.print(count);
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("   </tr>\r\n");
      out.write("   </table>\r\n");
      out.write("  </td>\r\n");
      out.write(" </tr>\r\n");
      out.write(" <tr>\r\n");
      out.write("  <td class=\"table_td table_padding\"  align=\"center\" colspan=\"2\">\r\n");
      out.write("\r\n");
      out.write(" [ <a href=\"javascript:list()\" >리스트</a> | \r\n");
      out.write(" <a href=\"noticeUpdate.jsp?nowPage=");
      out.print(nowPage);
      out.write("&num=");
      out.print(num);
      out.write("&numPerPage=");
      out.print(numPerPage);
      out.write("\" >수 정</a> |\r\n");
      out.write(" <a href=\"noticeReply.jsp?nowPage=");
      out.print(nowPage);
      out.write("&numPerPage=");
      out.print(numPerPage);
      out.write("\" >답 변</a> |\r\n");
      out.write(" <a href=\"noticeDelete.jsp?nowPage=");
      out.print(nowPage);
      out.write("&num=");
      out.print(num);
      out.write("\">삭 제</a> ]<br/>\r\n");
      out.write("  </td>\r\n");
      out.write(" </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<form method=\"post\" name=\"downFrm\" action=\"download.jsp\">\r\n");
      out.write("	<input type=\"hidden\" name=\"filename\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form name=\"listFrm\">\r\n");
      out.write("	<input type=\"hidden\" name=\"nowPage\" value=\"");
      out.print(nowPage);
      out.write("\">\r\n");
      out.write("	<input type=\"hidden\" name=\"numPerPage\" value=\"");
      out.print(numPerPage);
      out.write("\">\r\n");
      out.write("	");
if(!(keyWord==null||keyWord.equals(""))){
      out.write("\r\n");
      out.write("	<input type=\"hidden\" name=\"keyField\" value=\"");
      out.print(keyField);
      out.write("\">\r\n");
      out.write("	<input type=\"hidden\" name=\"keyWord\" value=\"");
      out.print(keyWord);
      out.write("\">\r\n");
      out.write("	");
}
      out.write("\r\n");
      out.write("</form>\r\n");
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
