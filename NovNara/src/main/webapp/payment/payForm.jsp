<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NovNara_결제시스템</title>
<link rel="stylesheet" href="../css/style.css" />

<style>
.payForm_div{
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 5px;
}

.pay_title{
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>
	<%@ include file="../top.jsp" %>
	<div class="pay_title">
		<h2 class="h1_title ">payForm</h2>
	</div>
<div class="payForm_div">
	<form action="../payment/payProc.jsp" method="post" >
		<div class=big-sign-up-box">
		<div class="sign-up-box">
		    <h3 class="sign-up">이름</h3>
		    <input class="sign-up input" name="name" type="text" size="30" value="홍길동">
		</div>
		<div class="sign-up-box">
		    <h3 class="sign-up">이메일</h3>
		    <input class="sign-up input" name="email" type="email" size="30" value="simba222@naver.com" >
		</div>
		<div class="sign-up-box">
		    <h3 class="sign-up">연락처</h3>
		    <input class="sign-up input" name="phone" size="30" value="010-3570-6996">
		</div>
		<div class="sign-up-box">
		    <h3 class="sign-up">주소</h3>
		    <input class="sign-up input" name="address" size="30" value="부산광역시 연제구 아시아드대로22번길 36 (거제동, 거제푸르지오)" >
		</div>
		<div class="sign-up-box">
		    <h3 class="sign-up">총 가격</h3>
		    <input class="sign-up input" name="totalprice" size="30" value="100">
		</div>
		</div>
		<div class="sign-up-box button-box">
			<input class="btn" type="submit" value="결제하기"> 
			<input class="btn" type="reset" value="취소하기">
		</div>
	</form>
</div>
	
		<%@ include file="../bottom.jsp" %>
	
</body>
</html>