<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, novNara.*"%>
<jsp:useBean id="orderMgr" class="novNara.OrderMgr" />
<jsp:useBean id="pMgr" class="novNara.ProductMgr" />
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script src="script.js"></script>
</head>
<body topmargin="100">
<%@ include file="top.jsp" %>
<div class="h1_title table_title">주문 관리</div>
<div class="talbe_div">
<table width="75%" align="center">
<tr> 
<td align="center">

	<table width="95%" align="center">
	<tr  align="center"> 
		<td>주문번호</td>
		<td>주문자<td>
		<td>제품명</td>
		<td>주문수량</td>
		<td>주문날짜</td>
		<td>주문상태</td>
		<td>상세보기</td>
	</tr>
	<%
			Vector<OrderBean> vlist = orderMgr.getOrderList();
			if(vlist.isEmpty()){
	%>
	<tr>
		<td align="center" colspan="7">주문내역이 없습니다.</td>
	</tr>
	<%}else{
			for(int i=0;i<vlist.size();i++){
				OrderBean order/*주문 정보*/ = vlist.get(i);
				ProductBean product/*제품정보*/ = pMgr.getProduct(order.getProductNo());
	%>
	<tr align="center">
		<td><%=order.getNo()%></td>
		<td><%=order.getId()%></td>
		<td><%=product.getName()%></td>
		<td><%=order.getQuantity()%></td>
		<td><%=order.getDate()%></td>
		<td>
		<%
			switch(order.getState()){
				case "1" : out.println("접수중");break;
				case "2" : out.println("접수");break;
				case "3" : out.println("입금확인");break;
				case "4" : out.println("배송준비");break;
				case "5" : out.println("배송중");break;
				default : out.println("완료");
			}
		%>
		</td>
		<td><a href="javascript:orderDetail('<%=order.getNo()%>')">상세보기</a></td>
	</tr>			
	<%	
				}//---for
			}//---if
	%>
	</table>
</td>
</tr>
</table>
</div>
<%@ include file="../bottom.jsp" %>
<form name="detail" method="post" action="orderDetail.jsp" >
	<input type="hidden" name="no">
</form>
</body>
</html>
