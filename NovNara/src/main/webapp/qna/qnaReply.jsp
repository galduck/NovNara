<!-- reply.jsp -->
<%@page import="novNara.QnaBean"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!--  세션에 저장한 원글을 리턴 -->
<!-- scpoe가 session이면 같은 id가 있으면 가져와서 사용하고 없으면 생성 -->
<jsp:useBean id="bean" class="novNara.QnaBean" scope="session"/>
<%
		//QnaBean bean = (QnaBean)session.getAttribute("bean");
		String nowPage = request.getParameter("nowPage");
		String numPerPage = request.getParameter("numPerPage");
	  	String name = bean.getName(); 
		String subject = bean.getSubject();
		String content = bean.getContent();
%>
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#FFFFCC">
<%@ include file="../top.jsp" %>
<div align="center">
<h3 class="h1_title">Q & A 답변하기</h3>

<form method="post" action="QnaReply" >
<table width="600" cellpadding="7">
 <tr>
  <td>
   <table>
    <tr>
     <td class="table_td"  width="20%">작성자</td>
     <td class="table_td"  width="80%">
	  <%=name%></td>
    </tr>
    <tr>
     <td class="table_td" >제 목</td>
     <td class="table_td" >
	  <input name="subject" size="50" value="답변 : <%=subject%>" maxlength="50"></td> 
    </tr>
	<tr>
     <td class="table_td" >내 용</td>
     <td class="table_td" >
	  <textarea name="content" rows="12" cols="50">
      	<%=content %>
      	========답변 글을 쓰세요.=======
      	</textarea>
      </td>
    </tr>
    <tr>
     <td class="table_td" >비밀 번호</td> 
     <td class="table_td" >
	  <input type="password" name="pass" size="15" maxlength="15"></td> 
    </tr>
    <tr>
     <td class="table_td"  colspan="2" height="5"><hr/></td>
    </tr>
	<tr> 
     <td class="table_td"  colspan="2">
	  <input  class="btn" type="submit" value="답변등록" >
      <input  class="btn" type="reset" value="다시쓰기">
      <input  class="btn" type="button" value="뒤로" onClick="history.back()"></td>
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
<%@ include file="../bottom.jsp" %>
</body>
</html>