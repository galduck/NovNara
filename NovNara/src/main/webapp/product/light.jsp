<!-- productList.jsp -->
<%@page import="novNara.UtilMgr"%>
<%@page import="novNara.ProductBean"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="pMgr" class="novNara.ProductMgr"/>
<%
		request.setCharacterEncoding("UTF-8");
		Vector<ProductBean> pvlist = pMgr.getProductList();
%>
<html>
<head>
<title>NovNara</title>
<script src="script.js"></script>
<link rel="stylesheet" href="../css/style.css" />
</head>
<body  topmargin="100">
	<%@ include file="../top.jsp" %>
	<div class="total_product_cover">
		<%
					for(int i=0;i<pvlist.size();i++){
						ProductBean pbean = pvlist.get(i);
		%>
		<div class="total_product">
			<a href="../product/productDetail.jsp?no=<%=pbean.getNo()%>">
			<div class="total_product_div total_product_img" >					
				<img src="../img/<%=pbean.getImage() %>" height="380px" width="430px" >
			</div>
			<div class="total_product_div"><%=pbean.getName() %></div>
			<div class="total_product_div"><%=UtilMgr.monFormat(pbean.getPrice())%></div>
			<form name="detail" method="post" action="../product/productDetail.jsp" >
				<input type="hidden" name="no">
			</form>
			</a>
		</div>
		
		<%}%>
	<%@ include file="../bottom.jsp" %>
	</div>

</body>
</html>




