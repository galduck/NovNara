<%@ page contentType="text/html;charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="mMgr" class="novNara.MemberMgr" />
<jsp:useBean id="mBean" class="novNara.MemberBean" />
<jsp:setProperty name="mBean" property="*" />
<%boolean flag = mMgr.updateMember(mBean);
if(flag){%>
	<script>
		alert("성공적으로 수정하였습니다");
		location.href="index.jsp";
	</script>
<%}else{%>
	<script>
		alert("수정 도중 에러가 발생하였습니다.");
		history.back();
	</script>
<%}%>


