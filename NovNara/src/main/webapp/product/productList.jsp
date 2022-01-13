<!-- productList.jsp -->
<%@page import="novNara.UtilMgr"%>
<%@page import="novNara.ProductBean"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="pMgr" class="novNara.ProductMgr"/>
<%
	int sort = 0;
	if(request.getParameter("sort")!=null){
		sort = UtilMgr.parseInt(request, "sort");
	}
	request.setCharacterEncoding("UTF-8");
	Vector<ProductBean> pvlist = pMgr.getProductList(sort);
%>
<html>
<head>
<title>NovNara</title>
<script src="script.js"></script>
<link rel="stylesheet" href="../css/style.css" />
</head>
<body  topmargin="100">
	<%@ include file="../top.jsp" %>
	<table width="75%" align="center" >
	<tr> 
	<td align="center" >
		<table width="95%" >
			<tr align="center" > 
				<td><font >이름</font></td>
				<td><font >가격</font></td>
				<td><font >날짜</font></td>
				<td><font >재고</font></td>
				<td><font >상세보기</font></td>
			</tr>
			<%
					for(int i=0;i<pvlist.size();i++){
						ProductBean pbean = pvlist.get(i);
			%>
			<tr align="center">
				<td><%=pbean.getName() %></td>
				<td><%=UtilMgr.monFormat(pbean.getPrice())%></td>
				<td><%=pbean.getDate()%></td>
				<td><%=UtilMgr.monFormat(pbean.getStock())%></td>
				<td><input type="button" value="상세보기" 
				onclick="productDetail('<%=pbean.getNo()%>')"></td>
			</tr>	
			<%}%>
		</table>
	</td>
	</tr>
	</table>
	<form name="detail" method="post" action="productDetail.jsp" >
		<input type="hidden" name="no">
	</form>
</body>
</html>




