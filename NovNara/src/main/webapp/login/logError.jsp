<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String mode = request.getParameter("mode");
	String msg = "";
	String color = "red";
	if (mode.equals("0")) {
		msg = "아이디 및 비밀번호를 다시 확인해주세요.";
	} else if (mode.equals("1")) {
		msg = "비밀 번호를 다시 확인해주세요.";
		color = "red";
	}
%>
<html>
<head>
<title>로그인 에러</title>
<link rel="stylesheet" href="../css/style.css" />
</head>
<body>
	<%@ include file="../top.jsp"%>
	<br />
	<br />
	<br />
	<div align="center">
		<b>로그인에 실패하였습니다.<br /><br />
		<font color="<%=color%>"><%=msg%></font>
		<br /> <br />
		</b> 
		<input type="button" value="돌아가기" class="btn" onClick="history.back()">
	</div>
</body>
</html>