<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,novNara.*"%>
<jsp:useBean id="orderMgr" class="novNara.OrderMgr" />
<jsp:useBean id="pMgr" class="novNara.ProductMgr" />
<%
		request.setCharacterEncoding("UTF-8");
		int no = Integer.parseInt(request.getParameter("no"));
		OrderBean order = orderMgr.getOrderDetail(no);
		ProductBean product = pMgr.getProduct(order.getProductNo());
%>
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
</head>
<body>
<%@ include file="top.jsp"%>
<form method="post" name="order" action="orderProc.jsp">
<div class="h1_title table_title">주문상세내역</div>
<div class="table_div"> 
<table width="75%" align="center" >
	<tr>
		<td align="center">
		<table width="30%" align="center">
			
			<tr align="center">
				<td>고객아이디</td>
				<td><%=order.getId()%></td>
			</tr>
			<tr align="center">
				<td>주문번호</td>
				<td><%=order.getNo()%></td>
			</tr>
			<tr align="center">
				<td>제품번호</td>
				<td><%=product.getNo()%></td>
			</tr>
			<tr align="center">
				<td>제품이름</td>
				<td><%=product.getName()%></td>
			</tr>
			<tr align="center">
				<td>제품가격</td>
				<td><%=UtilMgr.intFormat(product.getPrice())%>원</td>
			</tr>
			<tr align="center">
				<td>주문수량</td>
				<td><%=order.getQuantity() + ""%>개</td>
			</tr>
			<tr align="center">
				<td>재고수량</td>
				<td><%=product.getStock()%>개</td>
			</tr>
			<tr align="center">
				<td>주문날짜</td>
				<td><%=order.getDate()%></td>
			</tr>
			<tr align="center">
				<td>금액</td>
				<td><%=UtilMgr.intFormat(order.getQuantity() * product.getPrice())%>원</td>
			</tr>
			<tr align="center">
				<td>주문상태</td>
				<td>
					<select name="state">
						<option value="1">접수중</option>
						<option value="2">접수</option>
						<option value="3">입금확인</option>
						<option value="4">배송준비</option>
						<option value="5">배송중</option>
						<option value="6">완료</option>
					</select> 
				<script>document.order.state.value=<%=order.getState()%></script>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input class="btn" type="button" value="수정"
					size="3" onclick="javascript:orderUpdate(this.form)">  
					<input class="btn" type="button" value="삭제" size="3"
					onclick="javascript:orderDelete(this.form)">
				</td>
			</tr>
		</table>
		<input type="hidden" name="no" value="<%=order.getNo()%>"> 
		<input type="hidden" name="flag">
		</td>
	</tr>
</table>
</div>
</form>
<%@ include file="../bottom.jsp"%>
</body>
</html>