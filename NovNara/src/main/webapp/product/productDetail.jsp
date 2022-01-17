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
<link rel="stylesheet" href="../css/style.css" />
</head>
<body  topmargin="100">
<%@ include file="../top.jsp" %>
<div >
<form class="product-detail-form" name="cart" action="../cart/cartProc.jsp">
<div class="super_pd_div">
<div class="big_pd_div">
    <div class="img_pd_div">
		<img src="../img/<%=pbean.getImage() %>" height="380" width="430" class="pd_img_src">
	</div>
    <div class="pd_info">
      <div class="pd_name h1_title"> <%=pbean.getName() %></div>
      <div class="pd_name">가    격 : <%=UtilMgr.intFormat(pbean.getPrice())%>원</div>
      <div class="pd_name">수    량 : <input name="quantity" size="5" value="1">개</div>
      <div class="pd_name"><input type="submit" value="장바구니 담기" class="btn"></div>
    </div>
</div>
</div>





		<input type="hidden" name="productNo" value="<%=pbean.getNo()%>">	
		<input type="hidden" name="flag" value="insert">			
</form>
</div>
<%@ include file="../bottom.jsp" %>
</body>
</html>










