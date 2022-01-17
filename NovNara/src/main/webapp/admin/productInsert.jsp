<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
<style>
.productInsert_div{
	display: flex;
	justify-content: center;
	align-items: center;
}

.span_padding{
	padding: 5px 20px 5px 0px;
	margin: 3px 0px;
}

.product_insert_form{
	justify-content: center;
	align-items: baseline;
	
}
</style>
</head>
<body topmargin="100">
	<%@ include file="top.jsp" %>
<div class="productInsert_div">
	<form class="product_insert_form" method="post" action="productProc.jsp?flag=insert" enctype="multipart/form-data">
	<div class="h1_title">상품 등록</div>
		<span class="span_padding">구분(1:소품, 2:등):</span>
		<input class="span_padding"name="sort" size="5"> <br>
		<span class="span_padding">상품이름:</span>
		<input class="span_padding" name="name" size="20"><br>
		<span class="span_padding">상품가격:</span>
		<input class="span_padding" name="price" size="20">원<br>
		<span class="span_padding">상품설명:</span>		
		<textarea class="span_padding" rows="10" cols="45" name="detail"></textarea><br>
		<span class="span_padding">상품수량:</span>
		<input class="span_padding" name="totalPrice" value="500"> 
		<input class="span_padding" name="stock" size="10">개<br>
		<span class="span_padding">상품이미지:</span>		
		<input class="span_padding" type="file" name="image"><br>
		
			<input class="btn" type="submit" value="결제하기">&nbsp;&nbsp;&nbsp;
			<input class="btn" type="reset" value="취소하기">
	
	</form>
</div>
	<%@ include file="../bottom.jsp" %>
</body>
</html>

