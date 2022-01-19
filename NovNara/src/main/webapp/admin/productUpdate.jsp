<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,novNara.*"%>
<jsp:useBean id="pMgr" class="novNara.ProductMgr" />
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
</head>
<body  topmargin="100">
<%@ include file="top.jsp"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	ProductBean product = pMgr.getProduct(no);
%>
<h3 class="h1_title table_title">상품 수정</h3>
<div class="table_div">
<table width="75%" align="center" >
	<tr>
		<td  class="table_td" align="center" >
		<form method="post" action="productProc.jsp?flag=update"
			enctype="multipart/form-data">
		<table width="95%" align="center"  border="1">
			
			<tr>
				<td  class="table_td" width="31%" align="center">상품이름</td>
				<td  class="table_td" width="69%" align="left">
					<input  class="table_td" name="name" value="<%=product.getName()%>">
				</td>
			</tr>
			<tr>
				<td  class="table_td" height="21" align="center">상품가격</td>
				<td  class="table_td" align="left">
					<input  class="table_td" name="price" size="20" value="<%=product.getPrice()%>">원
				</td>
			</tr>
			<tr>
				<td  class="table_td" align="center">상품내용</td>
				<td class="table_td" >
				<textarea class="table_td"  rows="10" cols="45" name="detail"><%=product.getDetail()%></textarea>
				</td>
			</tr>
			<tr>
				<td  class="table_td" align="center">상품입고수량</td>
				<td  class="table_td" align="left">
					<input  class="table_td" name="stock" size="10" value="<%=product.getStock()%>">개
				</td>
			</tr>
			<tr>
				<td  class="table_td" align="center">상품이미지</td>
				<td  class="table_td" align="left">
				<img src="../data/<%=product.getImage()%>"><br/>
				<input  class="table_td" type="file" name="image"></td>
			</tr>
			<tr>
				<td  class="table_td" colspan="2" align="center"><input class="btn" type="submit"
					value="제품수정">&nbsp;&nbsp;&nbsp; <input class="btn" type="reset"
					value="다시쓰기"></td>
			</tr>
		</table>
			<input type=hidden name="no" value="<%=product.getNo()%>">
		</form>
		</td>
	</tr>
</table>
</div>
<%@ include file="../bottom.jsp"%>
</body>
</html>