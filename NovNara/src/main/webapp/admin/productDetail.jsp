<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,novNara.*"%>
<jsp:useBean id="pMgr" class="novNara.ProductMgr" />
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script  src="script.js"></script>

</head>
<body >
<%@ include file="top.jsp"%>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	ProductBean product = pMgr.getProduct(no);
%>
<div class="super_div">
	<div>
		<h1 class="h1_title pd_title"><%=product.getName()%></h1>
		<img src="../img/<%=product.getImage()%>" height="380px" width="430px" class="pd_img">
		<div class="table_td pd_margin">
		상품이름 : <%=product.getName()%>
		</div>
		<div class="table_td pd_margin">
		가 격 : <%=UtilMgr.intFormat(product.getPrice())%>
		</div>
		<div class="table_td pd_margin">
		입고날짜 : <%=product.getDate()%>
		</div>
		<div class="table_td pd_margin">
		재 고 : <%=UtilMgr.intFormat(product.getStock())%>
		</div>
		<div class="table_td detail_margin">					
		
		<pre><%=product.getDetail()%></pre>
		</div>
		<div class="table_td">		
		<a href="javascript:productUpdate('<%=product.getNo()%>')" class="btn" >수정하기</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="javascript:productDelete('<%=product.getNo()%>')" class="btn" >삭제하기</a>
		</div>				
		<%@ include file="../bottom.jsp"%>
	</div>
</div>
<form name="update" method="post" action="productUpdate.jsp"><input
	type=hidden name=no></form>
<form name="del" method="post" action="productProc.jsp?flag=delete">
<input type=hidden name=no></form>
</body>
</html>


