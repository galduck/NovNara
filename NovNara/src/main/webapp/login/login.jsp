<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<link rel="stylesheet" href="../css/style.css" />
<title>NovNara</title>
</head>
<body >
	<%@ include file="../top.jsp" %>
<div class="huge-sign-up-box">
<form class=sign-up-form method="post" action="loginProc.jsp">
	<h1 class="h1_title" align="center">로그인</h1>
<div class="big-sign-up-box">
	<div class="sign-up-box">
	    <h3 class="sign-up">아이디</h3>
	    <input class="sign-up input" name="id" type="text" size="15">
	</div>
	
	<div class="sign-up-box">
	    <h3 class="sign-up">비밀 번호</h3>
	    <input class="sign-up input" name="pwd" type="password" size="15">
	</div>
</div>
	<div class="sign-up-box button-box">
		<button class="btn sign-up-btn" >로그인</button>
		<button class="btn sign-up-btn" type="reset">다시 쓰기</button>
	</div>
</form>
</div>
	<%@ include file="../bottom.jsp" %>

</body>
</html>