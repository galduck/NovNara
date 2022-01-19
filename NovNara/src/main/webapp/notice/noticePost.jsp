<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,novNara.*"%>
<jsp:useBean id="mMgr" class="novNara.MemberMgr" />
<!DOCTYPE html>
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="../top.jsp" %>
	<%
		MemberBean mBean = mMgr.getMember(id);
	%>
<div class="table_title">
<h3 class="h1_title">Notice</h3>
<div align="center">

<form name="postFrm" method="post" action="noticePost" 
enctype="multipart/form-data">
<table width="600" cellpadding="3" align="center">
	<tr>
		<td class="table_td"  align=center>
		<table align="center">
			<tr>
				<td class="table_td"  width="15%">아이디</td>
				<td class="table_td"  width="90%">
				<input name="name" size="10" maxlength="8"></td>
			</tr>
			<tr>
				<td class="table_td" >제 목</td>
				<td class="table_td" >
				<input name="subject" size="50" maxlength="30"></td>
			</tr>
			<tr>
				<td class="table_td" >내 용</td>
				<td class="table_td" ><textarea name="content" rows="10" cols="50"></textarea></td>
			</tr>
			<tr>
				<td class="table_td" >비밀 번호</td>
				<td class="table_td" ><input type="password" name="pass" size="15" maxlength="15" value="1234"></td>
			</tr>
			<tr>
			 <tr>
     			<td class="table_td" >파일 찾기</td> 
     			<td class="table_td" ><input type="file" name="filename" size="50" maxlength="50"></td>
    		</tr>
 			<tr>
 				<td class="table_td" >내용 타입</td>
 				<td class="table_td" > HTML<input type=radio name="contentType" value="HTTP" >&nbsp;&nbsp;&nbsp;
  			 	TEXT<input type=radio name="contentType" value="TEXT" checked>
  			 	</td>
 			</tr>
			<tr>
				<td  class="table_td" colspan="2"><hr/></td>
			</tr>
			<tr>
				<td  class="table_td" colspan="2">
					 <input class="btn" type="submit" value="등록">
					 <input class="btn" type="reset" value="다시쓰기">
					 <input class="btn" type="button" value="리스트" onClick="javascript:location.href='noticeList.jsp'">
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>">
</form>
</div>
	<%@ include file="../bottom.jsp" %>

</body>
</html>