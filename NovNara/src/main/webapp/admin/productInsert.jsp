<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
</head>
<body topmargin="100">
	<%@ include file="top.jsp" %>
	<form method="post" action="productProc.jsp?flag=insert" enctype="multipart/form-data">
	<table width="75%" align="center" >
	<tr> 
	<td align="center">
		<table width="95%" border="1">
		<tr> 
		<td colspan="2" align="center">
			상품 등록
		</td>
		</tr>
		<tr> 
			<td align="center">구분 (1:소품, 2:등)</td>
			<td align="left"><input name="sort" size="5"></td>
		</tr>
		<tr> 
			<td align="center">상품이름</td>
			<td align="left"><input name="name" size="20"></td>
		</tr>
		<tr> 
			<td align="center">상품가격</td>
			<td align="left"><input name="price" size="20">원</td>
		</tr>
		<tr> 
			<td align="center">상품설명</td>
			<td><textarea rows="10" cols="45" name="detail"></textarea></td>
		</tr>
		<tr> 
			<td align="center">상품수량</td>
			<td><input name="stock" size="10">개</td>
		</tr>
		<tr> 
			<td align="center">상품이미지</td>
			<td><input type="file" name="image"></td>
		</tr>
		<tr> 
		<td colspan="2" align="center"> 
			<input class="btn" type="submit" value="상품등록">&nbsp;&nbsp;&nbsp;
			<input class="btn" type="reset" value="다시쓰기">
		</td>
		</tr>
		</table>
	</td>
	</tr>
	</table>
	</form>
	<%@ include file="../bottom.jsp" %>
</body>
</html>

