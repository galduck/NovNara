<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>NovNara</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="script.js"></script>
</head>

<body  topmargin="100">

	<%@ include file="../top.jsp"%>

<div class="huge-sign-up-box">
<form class="regForm" name="regForm" method="post"  action="memberProc.jsp">
	<h1 class="h1_title" align="center">회원가입</h1>
<div class=big-sign-up-box">
	<div class="sign-up-box">
	    <h3 class="sign-up">아이디</h3>
	    <input class="sign-up input" name="id" type="text" size="15">
	    <input type="button" class="btn sign-up-btn" onClick="idCheck(this.form.id.value)" value=" 아이디 중복 확인">
	</div>
	
	<div class="sign-up-box">
	    <h3 class="sign-up">비밀 번호</h3>
	    <input class="sign-up input" name="pwd" type="password" size="15">
	     <h3 class="sign-up">비밀 번호 확인</h3>
	    <input class="sign-up input" name="repwd" type="password" size="15">
	</div>
	
	<div class="sign-up-box">
	    <h3 class="sign-up">이메일</h3>
	    <input class="sign-up input" name="email" type="email" size="30">
	</div>
</div>

	<div class="sign-up-box button-box">
		<input type="button" class="btn sign-up-btn" onclick="inputCheck()"  value="회원 가입">
		<input type="reset" class="btn sign-up-btn" value="다시쓰기">
	</div>
</form>
</div>
<div>
	<div></div>
	<span>Or</span>
	<div></div>
</div>
	<%@ include file="../bottom.jsp"%>
</body>
</html>

