<!-- productDetail.jsp -->
<%@page import="novNara.ProductBean"%>
<%@page import="novNara.UtilMgr"%>
<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="pMgr" class="novNara.ProductMgr"/>
<%
		request.setCharacterEncoding("UTF-8");
		int no = UtilMgr.parseInt(request, "no");
		ProductBean pbean = pMgr.getProduct(no);
%>
<html>
<head>
<title>NovNara</title>
<script src="script.js"></script>
<link rel="stylesheet" href="../css/style.css" />
</head>
<body  topmargin="100">
<%@ include file="../top.jsp" %>
<div class="product-detail-box">
<form class="product-detail-form" name="cart" action="../cart/cartProc.jsp">
<table class="product-detail-table">
        <tr class="product-detail-tr ">
            <td rowspan="4" class="product-detail-img">
            	<img src="../img/<%=pbean.getImage() %>" height="380" width="430">
           	</td>
            <td class="product-name_product-detail"><b><%=pbean.getName() %></b></td>
        </tr>
		<tr class="product-detail-tr">
			<td><b>가    격 : <%=UtilMgr.intFormat(pbean.getPrice())%></b>원</td>
			
		</tr>
		<tr class="product-detail-tr">
			<td><b>수    량 : </b><input name="quantity" size="5" value="1">개</td>
		
		</tr>
		<tr>
            <td rowspan="3" > <input class="put-in-the-cart btn" type="button" value="장바구니 담기"></td>
		</tr>
      	<tr>
			<td colspan="3" class="DetailDetail"><%=pbean.getDetail()%></td>
		
		</tr>
	</table>
		<input type="hidden" name="productNo" value="<%=pbean.getNo()%>">	
		<input type="hidden" name="flag" value="insert">			
</form>
</div>
<%@ include file="../bottom.jsp" %>
</body>
</html>










