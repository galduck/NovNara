<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,novNara.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="mMgr" class="novNara.MemberMgr" />
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
</head>
<body>
	<br>
	<%@ include file="top.jsp"%>
	<%
		String id = request.getParameter("id");
		MemberBean mBean = mMgr.getMember(id);
	%>
	<h3 class="h1_title table_title"><%=mBean.getId()%> 회원님의 정보를 수정합니다.</h3>
	<form name="regForm" method="post" action="../admin/memberUpdateProc.jsp">
	<div class="table_div">
		<table  align="center">
			<tr>
				<td  class="table_td" align="center" >
					<table align="center"  border="1">

						<tr>
							<td class="table_td" >아이디</td>
							<td class="table_td" ><%=mBean.getId()%></td>
						</tr>
						<tr>
							<td class="table_td" >패스워드</td>
							<td class="table_td" ><input name="pwd" value="<%=mBean.getPwd()%>"></td>
						</tr>
						<tr>
							<td class="table_td" >이메일</td>
							<td class="table_td" ><input name="email" size="30"
								value="<%=mBean.getEmail()%>"></td>
						</tr>
						<tr>
							<td class="table_td" colspan="2" align="center"><input class="btn" type="submit"
								value="수정완료"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<input class="btn" type="reset" value="다시쓰기"></td>
						</tr>
						<input type="hidden" name="id" value="<%=id%>">
					</table>
				</td>
			</tr>
		</table>
	</form>
</div>
	<%@ include file="../bottom.jsp"%>
</body>
</html>
