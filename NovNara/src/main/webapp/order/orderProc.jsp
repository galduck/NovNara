<!-- orderProc.jsp -->
<%@page import="java.util.Enumeration"%>
<%@page import="novNara.OrderBean"%>
<%@page import="java.util.Hashtable"%>
<%@page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="cMgr" class="novNara.CartMgr" scope="session" />
<jsp:useBean id="pMgr" class="novNara.ProductMgr"/>
<jsp:useBean id="orderMgr" class="novNara.OrderMgr"/>
<% 
		request.setCharacterEncoding("EUC-KR");
		//���ǿ� ����� ��ٱ��� ��ü�� ����
		Hashtable<Integer, OrderBean> hCart = cMgr.getCartList();
		Enumeration<Integer> hCartKey = hCart.keys();
		String msg = "";
		if(!hCart.isEmpty()){
			while(hCartKey.hasMoreElements()){
				OrderBean order = hCart.get(hCartKey.nextElement());
				//�ֹ�ó��
				orderMgr.insertOrder(order);
				//�������
				pMgr.reduceProduct(order);
				//��ٱ��Ͽ� �ֹ��� ��ǰ����
				cMgr.deleteCart(order);
			}
			msg ="�ֹ�ó�� �Ͽ����ϴ�.";
		}else{
			msg = "��ٱ��ϰ� ������ϴ�.";
		}
%>
<script>
	alert("<%=msg%>");
	location.href = "orderList.jsp";
</script>








