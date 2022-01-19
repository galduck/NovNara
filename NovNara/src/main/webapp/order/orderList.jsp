<%@page import="novNara.ProductBean"%>
<%@page import="novNara.OrderBean"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="orderMgr" class="novNara.OrderMgr"/>
<jsp:useBean id="pMgr" class="novNara.ProductMgr"/>
<%
		if(session.getAttribute("idKey")==null){
			response.sendRedirect("../login/login.jsp");
			return;
		}
%>
<html>
<head>
<title>NovNara</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="../member/script.js"></script>
</head>
<body topmargin="100">
<%@ include file="../top.jsp" %>
<div align="center"><br>
<h2 class="h1_title">주문내역</h2><br>
<div class="table_div">
	<table width="75%" align="center" >
	<tr> 
	<td align="center" >
		<table width="95%"   border="1">
		<tr  align="center"> 
			<td class="table_td"><font >주문번호</font></td>
			<td class="table_td"><font >제품</font></td>
			<td class="table_td"><font >주문수량</font></td>
			<td class="table_td"><font >주문날짜</font></td>
			<td class="table_td"><font >주문상태</font></td>
		</tr>
		<%
				Vector<OrderBean> vlist = orderMgr.getOrderList(id);
				if(vlist.isEmpty()){
		%>
		<tr>
			<td colspan="5" align="center">
			주문하신 물품이 없습니다.
			</td>
		</tr>
		<%			
				}else{	
					for(int i=0;i<vlist.size();i++){
						OrderBean order = vlist.get(i);
						int productNo = order.getProductNo();
						ProductBean pbean = pMgr.getProduct(productNo);
		%>
		<tr align="center">
			<td class="table_td"><%=order.getNo()%></td>
			<td class="table_td">
			<a href="javascript:productDetail('<%=productNo%>')">
				<%=pbean.getName()%></a>
			</td>
			<td class="table_td"><%=order.getQuantity() %></td>
			<td class="table_td"><%=order.getDate()%></td>
			<td class="table_td">
			<%
				switch(order.getState()){
					case "1": out.print("접수중"); break;
					case "2": out.print("접수"); break;
					case "3": out.print("입금확인"); break;
					case "4": out.print("배송준비"); break;
					case "5": out.print("배송중"); break;
					case "6": out.print("완료"); break;
				}//---switch
			%>
			</td>
		</tr>	
		<%		
					}//--for
				}//--if-else 
		%>
		</table> 
	</td>
	</tr>
	</table>
	<form name="detail" method="post" action="../product/productDetail.jsp" >
		<input type="hidden" name="no">
	</form>
</div>
</div>
	<%@ include file="../bottom.jsp" %>
</body>
</html>