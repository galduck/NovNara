<!-- cartProc.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="cMgr" class="novNara.CartMgr" scope="session"/>
<jsp:useBean id="order" class="novNara.OrderBean" />
<jsp:setProperty property="*" name="order"/>
<% 
		request.setCharacterEncoding("EUC-KR");
		String id = (String)session.getAttribute("idKey");
		if(id==null){
			response.sendRedirect("login.jsp");
			return;//���Ŀ� �ڵ�� ����ȭ�� ���� ����
		}
		order.setId(id);//�ֹ��� id ����
		//��ٱ��� ���, ����, ���� ��� ó���ϴ� ������(insert, delete, update)
		String flag = request.getParameter("flag");
		String msg = "";
		if(flag.equals("insert")){
			msg = "��ٱ��Ͽ� �����Ͽ����ϴ�.";
			cMgr.addCart(order);
		}else if(flag.equals("delete")){
			msg = "��ٱ��ϸ� �����Ͽ����ϴ�.";
			cMgr.deleteCart(order);
		}else if(flag.equals("update")){
			msg = "��ٱ��ϸ� �����Ͽ����ϴ�.";
			cMgr.updateCart(order);
		}
%>
<script>
	alert("<%=msg%>");
	location.href = "cartList.jsp";
</script>









