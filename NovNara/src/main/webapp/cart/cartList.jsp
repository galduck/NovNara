<!-- cartList.jsp -->
<%@page import="novNara.UtilMgr"%>
<%@page import="novNara.ProductBean"%>
<%@page import="java.util.Enumeration"%>
<%@page import="novNara.OrderBean"%>
<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="cMgr" class="novNara.CartMgr" scope="session" />
<jsp:useBean id="pMgr" class="novNara.ProductMgr"/>
<%
		request.setCharacterEncoding("EUC-KR");
		String path = request.getContextPath();
		if(session.getAttribute("idKey")==null){
			response.sendRedirect(path+"/login/login.jsp");
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
				<td>��ǰ</font></td>
				<td>����</font></td>
				<td>����</font></td>
				<td>����/����</font></td>
				<td>��ȸ</font></td>
			</tr>
			<%if(hCart.isEmpty()){ %>
			<tr>
				<td colspan="5" align="center">��ٱ��ϴ� ��� �ֽ��ϴ�.</td>
			</tr>	
			<%}else{
					//�ؽ����̺��� ����� ��ü�� Ű���� ������.
					//Enumeration  : ������ ���� ��ü
					Enumeration<Integer> hCartKey = hCart.keys();
					while(hCartKey.hasMoreElements()){
						//Ű������ �ֹ���ü�� ����
						OrderBean order = hCart.get(hCartKey.nextElement());
						int productNo = order.getProductNo();
						//��ǰ��ȣ�� ��ǰ���� ����
						ProductBean pbean = pMgr.getProduct(productNo);
						String pName = pbean.getName();//��ǰ�̸�
						int price = pbean.getPrice();//��ǰ����
						int quantity = order.getQuantity();//�ֹ�����
						int subTotal = price * quantity;//�ֹ�����
						//��ü�ֹ�����
						totalPrice+=subTotal;
			%>
			<tr align="center">
			<form method="post" action="cartProc.jsp">
				<input type="hidden" name="productNo" 
				value="<%=productNo%>">
				<td><%=pName%></td>
				<td><input name="quantity" style = "text-align:right;" 
					value="<%=quantity%>" size="3">��</td>
				<td><%=UtilMgr.monFormat(subTotal)%></td>
				<td>
					<input type="button" value="����" size="3" onclick="javascript:cartUpdate(this.form)"> /
					<input type="button" value="����" size="3" onclick="javascript:cartDelete(this.form)">
				</td>
				<td>
					<a href="javascript:productDetail('<%=productNo%>')">�󼼺���</a>
				</td>
				<input type="hidden" name="flag">
				</form>
			</tr>
			<%}//--while%>
			<tr>
				<td colspan="4" align="right">
					�� �ֹ��ݾ� : <%=UtilMgr.monFormat(totalPrice)%>��	
				</td>
				<td align="center">
					<a href="orderProc.jsp">�ֹ��ϱ�</a>
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













