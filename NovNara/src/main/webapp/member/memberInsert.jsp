<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,novNara.*"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="mBean" class="novNara.MemberBean" />
<jsp:setProperty name="mBean" property="*" />
<html>
<head>
<title>회원가입 확인</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="script.js"></script>
</head>
<body >
	<br>

	<%@ include file="../top.jsp"%>

				<table width="95%" align="center" >
					<form name="regForm" method="post" action="memberProc.jsp">
						<tr align="center" >
							<td colspan="3"><b> <jsp:getProperty
											name="mBean" property="id" /> 회원님이 작성하신 내용입니다. 다시 한번 확인해주십시오
								</b></font></td>
						</tr>
						<tr>
							<td>아이디</td>
							<td><input name="id"
								value="<jsp:getProperty name="mBean" property="id" />"></td>
						</tr>
						<tr>
							<td>패스워드</td>
							<td><input name="pwd"
								value="<jsp:getProperty name="mBean" property="pwd" />"></td>
						</tr>
					<tr>
						<td>이메일</td>
						<td><input name="email" size="30"
							value="<jsp:getProperty name="mBean" property="email" />"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="확인완료"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <input
							type="button" value="다시쓰기" onClick="history.back()"></td>
					</tr>
					</form>
				</table>
	
	<%@ include file="../bottom.jsp"%>
</body>
</html>
