<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,novNara.*"%>
<jsp:useBean id="pMgr" class="novNara.ProductMgr" />
<html>
<head>
<title>NovNara</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="script.js"></script>
</head>
<body topmargin="100">
<%@ include file="top.jsp"%>
<div class="h1_title table_title">상품 관리</div>
<div class="table_div">
<table width="75%" align="center" >
	<tr>
		<td align="center">
		<table width="95%" align="center">
			<tr  align="center">
				<td>구분</td>
				<td>이름</td>
				<td>가격</td>
				<td>날짜</td>
				<td>재고</td>
				<td>&nbsp;</td>
			</tr>
			<%
				int sort = 0; 
				if(request.getParameter("sort")!=null){
					sort = UtilMgr.parseInt(request, "sort");
				}

				Vector<ProductBean> vResult = pMgr.getProductList(sort);
				if (vResult.size() == 0) {
			%>
		
			<tr>
				<td align="center" colspan="5">등록된 상품이 없습니다.</td>
			</tr>
			<%
				} else {
					for (int i = 0; i < vResult.size(); i++) {
						ProductBean product = vResult.get(i);
			%>
			<tr  align="center">
				<td><%=UtilMgr.intFormat(product.getSort())%></td>
				<td><%=product.getName()%></td>
				<td><%=UtilMgr.intFormat(product.getPrice())%></td>
				<td><%=product.getDate()%></td>
				<td><%=UtilMgr.intFormat(product.getStock())%></td>
				<td>
				<a href="javascript:productDetail('<%=product.getNo()%>')">상세보기</a></td>
			</tr>
			<%
					}//for
				}//if
			%>
		</table>
		</td>
	</tr>
</table>
</div>
<form class="productMgr-buttons" name="input" action="../admin/productInsert.jsp" method="get">
	<input class="productMgr_btn" type="submit" value="상품등록" >
</form>

<%@ include file="../bottom.jsp"%>
<form name="detail" method="post" action="productDetail.jsp">
	<input type="hidden" name="no">
</form>
</body>
</html>