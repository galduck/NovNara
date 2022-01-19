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
<div align="center">
<h3 class="h1_title">Q&A 글쓰기</h3>

<form name="postFrm" method="post" action="../qna/qnaPost" 
enctype="multipart/form-data">
<table width="600" cellpadding="3" align="center">
	<tr>
		<td class="table_td" align=center>
		<table align="center">
			<tr>
				<td class="table_td" width="20%">아이디</td>
				<td class="table_td" width="80%">
				<%=mBean.getId()%></td>
			</tr>
			<tr>
				<td class="table_td" >제 목</td>
				<td class="table_td" >
				<input  class="table_td" name="subject" size="37" maxlength="20"></td>
			</tr>
			<tr>
				<td class="table_td" >내 용</td>
				<td class="table_td" ><textarea  class="table_td" name="content" rows="10" cols="50"></textarea></td>
			</tr>
			<tr>
				<td class="table_td" >비밀 번호</td>
				<td class="table_td" ><input  class="table_td" type="password" name="pass" size="15" maxlength="15" value="1234"></td>
			</tr>
			<tr>
			 <tr>
     			<td class="table_td" >파일찾기</td> 
     			<td class="table_td" ><input  class="table_td" type="file" name="filename" size="50" maxlength="50"></td>
    		</tr>
 			<tr>
 				<td class="table_td" >내용타입</td>
 				<td class="table_td" > HTML<input  class="table_td" type=radio name="contentType" value="HTTP" >&nbsp;&nbsp;&nbsp;
  			 	TEXT<input  class="table_td" type=radio name="contentType" value="TEXT" checked>
  			 	</td>
 			</tr>
			<tr>
				<td  class="table_td" colspan="2"><hr/></td>
			</tr>
			<tr>
				<td  class="table_td" colspan="2">
					 <input class="btn" type="submit" value="등록">
					 <input  class="btn" type="reset" value="다시쓰기">
					 <input  class="btn" type="button" value="리스트" onClick="javascript:location.href='list.jsp'">
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<input type="hidden" name="ip" value="<%=request.getRemoteAddr()%>">
</form>
</div>
</body>
</html>