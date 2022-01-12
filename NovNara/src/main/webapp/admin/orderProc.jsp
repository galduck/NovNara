<!-- orderProc.jsp -->
<%@page import="novNara.UtilMgr"%>
<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="orderMgr" class="novNara.OrderMgr"/>
<% 
		request.setCharacterEncoding("UTF-8");
		String flag = request.getParameter("flag");
		int no = UtilMgr.parseInt(request, "no");
		boolean result = false;
		String msg = "오류가 발생하였습니다.";
		if(flag.equals("update")){
			String state = request.getParameter("state");
			if(orderMgr.updateOrder(no, state))
				msg = "수정 하였습니다.";
		}else if(flag.equals("delete")){
			if(orderMgr.deleteOrder(no))
				msg = "삭제 하였습니다.";
		}
%>
<script>
	alert("<%=msg%>");
	location.href = "orderMgr.jsp";
</script>





