<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NovNara_결제시스템</title>
<link rel="stylesheet" href="../organize.css" />

<style>
span {
	width: 60px;
	display: inline-block;
}

.payForm_div{
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 5px;
}

</style>
</head>
<body>
	<%@ include file="../top.jsp" %>
	
<div class="payForm_div">
	<form action="payProc.jsp" method="post" >
	<h1 class="h1_title" align="center">payForm</h1>
	
	<div class=big-sign-up-box">
	<div class="sign-up-box">
	    <h3 class="sign-up">아이디</h3>
	    <input class="sign-up input" name="id" type="text" size="15">
	    <input type="button" class="btn sign-up-btn" onClick="idCheck(this.form.id.value)" value=" 아이디 중복 확인">
	</div>
	
	
	
	
	
	
	
	
	
	
		<span>이름:</span><input name="name" value="홍길동"><br> 
		<span>이메일:</span><input name="email" value="simba222@naver.com"><br>
		<span>폰넘버:</span><input name="phone" value="010-3570-6996"><br>
		<span>주소:</span><input name="address" value="부산광역시 연제구 아시아드대로22번길 36 (거제동, 거제푸르지오)"><br>
		<span>총가격:</span><input name="totalPrice" value="100"><br> 
		<input type="submit" value="결제하기"> 
		<input type="reset" value="취소하기">
	</form>
</div>
		<%@ include file="../bottom.jsp" %>
	
</body>
</html>