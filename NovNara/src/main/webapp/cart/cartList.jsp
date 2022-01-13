<!-- cartList.jsp -->
<%@page import="novNara.UtilMgr"%>
<%@page import="novNara.ProductBean"%>
<%@page import="java.util.Enumeration"%>
<%@page import="novNara.OrderBean"%>
<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="cMgr" class="novNara.CartMgr" scope="session" />
<jsp:useBean id="pMgr" class="novNara.ProductMgr"/>
<%
		request.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		if(session.getAttribute("idKey")==null){
			response.sendRedirect(path+"../login/login.jsp");
			return;
		}
		Hashtable<Integer, OrderBean> hCart = cMgr.getCartList();
		int totalPrice = 0;
%>
<html>
<head>
<title>NovNara</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="script.js"></script>
</head>
<body  topmargin="100">
	<%@ include file="../top.jsp" %>
	<table width="75%" align="center" >
	<tr>
	<td align="center" >
		<table width="95%" align="center"  border="1">
			<tr align="center" >
				<td>제품</font></td>
				<td>수량</font></td>
				<td>가격</font></td>
				<td>수정/삭제</font></td>
				<td>조회</font></td>
			</tr>
			<%if(hCart.isEmpty()){ %>
			<tr>
				<td colspan="5" align="center">장바구니는 비어 있습니다.</td>
			</tr>	
			<%}else{
					//해쉬테이블에서 저장된 객체의 키값을 가져옴.
					//Enumeration  : 줄줄이 사탕 객체
					Enumeration<Integer> hCartKey = hCart.keys();
					while(hCartKey.hasMoreElements()){
						//키값으로 주문객체를 리턴
						OrderBean order = hCart.get(hCartKey.nextElement());
						int productNo = order.getProductNo();
						//상품번호로 상품정보 리턴
						ProductBean pbean = pMgr.getProduct(productNo);
						String pName = pbean.getName();//상품이름
						int price = pbean.getPrice();//상품가격
						int quantity = order.getQuantity();//주문수량
						int subTotal = price * quantity;//주문가격
						//전체주문가격
						totalPrice+=subTotal;
			%>
			<tr align="center">
			<form method="post" action="cartProc.jsp">
				<input type="hidden" name="productNo" 
				value="<%=productNo%>">
				<td><%=pName%></td>
				<td><input name="quantity" style = "text-align:right;" 
					value="<%=quantity%>" size="3">개</td>
				<td><%=UtilMgr.monFormat(subTotal)%></td>
				<td>
					<input type="button" value="수정" size="3" onclick="javascript:cartUpdate(this.form)"> /
					<input type="button" value="삭제" size="3" onclick="javascript:cartDelete(this.form)">
				</td>
				<td>
					<a href="javascript:productDetail('<%=productNo%>')">상세보기</a>
				</td>
				<input type="hidden" name="flag">
				</form>
			</tr>
			<%}//--while%>
			<tr>
				<td colspan="4" align="right">
					총 주문금액 : <%=UtilMgr.monFormat(totalPrice)%>원	
				</td>
				<td align="center">
					<a href="../order/orderProc.jsp">주문하기</a>
				</td>
			</tr>
			<%}//--fi-else %>
		</table>
	</td>
	</tr>
	</table>
	<%@ include file="../bottom.jsp" %>
	<form name="detail" method="post" action="productDetail.jsp" >
		<input type="hidden" name="no">
	</form>	
</body>
</html>













