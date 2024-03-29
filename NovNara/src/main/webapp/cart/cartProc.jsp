<!-- cartProc.jsp -->
<%@page contentType="text/html; charset=EUC-KR"%>
<jsp:useBean id="cMgr" class="novNara.CartMgr" scope="session"/>
<jsp:useBean id="order" class="novNara.OrderBean" />
<jsp:setProperty property="*" name="order"/>
<% 
		request.setCharacterEncoding("EUC-KR");
		String id = (String)session.getAttribute("idKey");
		if(id==null){
			response.sendRedirect("../login/login.jsp");
			return;//이후에 코드는 무력화를 위한 목적
		}
		order.setId(id);//주문자 id 저장
		//장바구니 담기, 삭제, 수정 모두 처리하는 페이지(insert, delete, update)
		String flag = request.getParameter("flag");
		String msg = "";
		if(flag.equals("insert")){
			msg = "장바구니에 저장하였습니다.";
			cMgr.addCart(order);
		}else if(flag.equals("delete")){
			msg = "장바구니를 삭제하였습니다.";
			cMgr.deleteCart(order);
		}else if(flag.equals("update")){
			msg = "장바구니를 수정하였습니다.";
			cMgr.updateCart(order);
		}
%>
<script>
	alert("<%=msg%>");
	location.href = "../cart/cartList.jsp";
</script>









