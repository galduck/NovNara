<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, novNara.*"%>
<jsp:useBean id="mMgr" class="novNara.MemberMgr" />
<html>
<head>
<title>NovNara</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="script.js"></script>
</head>
<body  topmargin="100">
	<%@ include file="top.jsp" %> 
	<%Vector<MemberBean> vlist = mMgr.getMemberList();%>
<div class="h1_title table_title">회원 관리</div>
<div class="table_div">
<table width="75%" align="center">
	<tr> 
	<td align="center">

		<table width="95%" align="center">
		<tr align="center"> 
			<td class="table_td">회원이름</td>
			<td class="table_td">회원아이디</td>
			<td class="table_td">패스워드</td>
			<td class="table_td">이메일</td>
			<td class="table_td">수정</td>
			<td class="table_td">메일보내기</td>
		</tr>
		<%
		for(int i=0; i<vlist.size(); i++){
			MemberBean mBean = vlist.get(i);
		%>
		<tr align="center"> 
			<td class="table_td"><%=mBean.getId()%></td>
			<td class="table_td"><%=mBean.getPwd()%></td>
			<td class="table_td">
			</td>
			<td class="table_td"><%=mBean.getEmail()%></td>
			<td class="table_td"><a href="javascript:update('<%=mBean.getId()%>')">수정하기</a></td>
			<td class="table_td">
			<a href="../admin/sendAccount.jsp?id=<%=mBean.getId()%>">메일보내기</a>
			</td>
		</tr>
		<%}%>
		</table>
	</td>
	</tr>
</table>
</div>
	<%@ include file="../bottom.jsp" %>
	<form name="update" method="post" action="../admin/memberUpdate.jsp">
	<input type=hidden name="id">
	</form>
</body>
</html>
