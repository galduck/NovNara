<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<title>NovNara</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="script.js"></script>
</head>
<body >
	<%@ include file="../top.jsp"%>
<div class="huge-sign-up-box">
<form class=sign-up-form method="post" action="./adminLoginProc.jsp">
	<h1 class="h1_title" align="center">관리자 로그인</h1>
	<div class="big-sign-up-box">
		<div class="sign-up-box">
		    <h3 class="sign-up">관리자 ID</h3>
		    <input class="sign-up input" name="admin_id" type="text" size="15">
		</div>
		
		<div class="sign-up-box">
		    <h3 class="sign-up">관리자 Password</h3>
		    <input class="sign-up input" name="admin_pwd" type="password" size="15">
		</div>
	</div>
	<div class="sign-up-box button-box">
		<input class="btn sign-up-btn" type="submit" value="로그인">
		<input class="btn sign-up-btn" type="reset" value="다시쓰기">
	</div>
</form>
</div>
	<%@ include file="../bottom.jsp"%>

</body>
</html>