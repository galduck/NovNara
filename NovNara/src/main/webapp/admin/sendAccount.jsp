<!-- sendAccount.jsp -->
<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="mMgr" class="novNara.MemberMgr"/>
<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		mMgr.sendAccount(id);
%>
<script>
	alert("메일을 발송 하였습니다.");
	location.href = "memberMgr.jsp";
</script>