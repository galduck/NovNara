<!-- reply.jsp -->
<%@page import="novNara.NoticeBean"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!--  세션에 저장한 원글을 리턴 -->
<!-- scpoe가 session이면 같은 id가 있으면 가져와서 사용하고 없으면 생성 -->
<jsp:useBean id="bean" class="novNara.NoticeBean" scope="session"/>
<%
		//NoticeBean bean = (NoticeBean)session.getAttribute("bean");
		String nowPage = request.getParameter("nowPage");
		String numPerPage = request.getParameter("numPerPage");
		String subject = bean.getSubject();
		String content = bean.getContent();
%>
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="../top.jsp" %>

<% if(id == null){ %>
<h3 align="center"> 공지 작성은 관리자 권한입니다. </h3>

<%
	}else if(!id.equals("admin")){
%>
<h3 align="center"> 공지 작성은 관리자 권한입니다. </h3>
<% } else { %>	
<div align="center">
<h3 class="h1_title">답변하기</h3>
<form method="post" action="NoticeReply" >
<table width="600" cellpadding="7">
 <tr>
  <td>
   <table>
    <tr>
     <td width="20%">작성자</td>
     <td width="80%">
	  관리자</td>
    </tr>
    <tr>
     <td>제 목</td>
     <td>
	  <input name="subject" size="50" value="답변 : <%=subject%>" maxlength="50"></td> 
    </tr>
	<tr>
     <td>내 용</td>
     <td>
	  <textarea name="content" rows="12" cols="50">
      	<%=content %>
      	========답변 글을 쓰세요.=======
      	</textarea>
      </td>
    </tr>
    <tr>
     <td>비밀 번호</td> 
     <td>
	  <input type="password" name="pass" size="15" maxlength="15"></td> 
    </tr>
    <tr>
     <td colspan="2" height="5"><hr/></td>
    </tr>
	<tr> 
     <td colspan="2">
	  <input class="btn" type="submit" value="답변등록" >
      <input class="btn"  type="reset" value="다시쓰기">
      <input class="btn"  type="button" value="뒤로" onClick="history.back()"></td>
    </tr> 
   </table>
  </td>
 </tr>
</table>
 <input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>" >
 <input type="hidden" name="nowPage" value="<%=nowPage%>">
 <input type="hidden" name="numPerPage" value="<%=numPerPage%>">
 <input type="hidden" name="ref" value="<%=bean.getRef()%>">
 <input type="hidden" name="pos" value="<%=bean.getPos()%>">
 <input type="hidden" name="depth" value="<%=bean.getDepth()%>">
</form> 
</div>
<%} %>
	<%@ include file="../bottom.jsp" %>

</body>
</html>