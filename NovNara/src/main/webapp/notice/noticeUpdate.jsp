<%@ page contentType="text/html; charset=UTF-8" %>
 <jsp:useBean id="bean" scope="session" class="novNara.NoticeBean"/>
<% 
	  int num = Integer.parseInt(request.getParameter("num"));
	  String nowPage = request.getParameter("nowPage");
	  String numPerPage = request.getParameter("numPerPage");
	  String subject = bean.getSubject();
	  String name = bean.getName(); 
	  String content = bean.getContent();
	  //read.jsp에서 session에 빈즈 단위로 저장 했기 때문에 파일명도 가져 올 수 있다.
	  String filename = bean.getFilename();
%>
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script>
	function check() {
	   if (document.updateFrm.pass.value == "") {
		 alert("수정을 위해 비밀번호를 입력하세요.");
		 document.updateFrm.pass.focus();
		 return false;
		 }
	   document.updateFrm.submit();
	}
</script>
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
<h3 class="h1_title">수정하기</h3>
<form name="updateFrm" method="post" action="noticeUpdate" enctype="multipart/form-data">
<table width="600" cellpadding="7">
 <tr>
  <td class="table_td" >
   <table>
    <tr>
     <td class="table_td" width="20%">작성자</td>
     <td class="table_td" width="80%">관리자</td>
	</tr>
	<tr>
     <td class="table_td" >제 목</td>
     <td class="table_td" >
	  <input name="subject" size="50" value="<%=subject%>" maxlength="50">
	 </td>
    <tr>
     <td class="table_td" >내 용</td>
     <td class="table_td" >
	  <textarea name="content" rows="10" cols="50"><%=content%></textarea>
	 </td>
    </tr>
    <tr>
    <td class="table_td" >첨부파일</td>
     <td>
     	<%=filename!=null?filename:"첨부된 파일이 없습니다."%>
     	<input type="file" name="filename" size="50" maxlength="50">
     </td>
    </tr>
	<tr>
     <td class="table_td" >비밀 번호</td> 
     <td class="table_td" ><input type="password" name="pass" size="15" maxlength="15">
      수정 시에는 비밀번호가 필요합니다.</td>
    </tr>
	<tr>
     <td  class="table_td" colspan="2" height="5"><hr/></td>
    </tr>
	<tr>
     <td  class="table_td" colspan="2">
	  <input class="btn" type="button" value="수정완료" onClick="check()">
      <input class="btn"  type="reset" value="다시수정"> 
      <input class="btn"  type="button" value="뒤로" onClick="history.go(-1)">
	 </td>
    </tr> 
   </table>
  </td>
 </tr>
</table>
 <input type="hidden" name="nowPage" value="<%=nowPage %>">
 <input type='hidden' name="num" value="<%=num%>">
 <input type='hidden' name="numPerPage" value="<%=numPerPage%>">
</form> 
</div>
<% } %>
	<%@ include file="../bottom.jsp" %>
</body>
</html>