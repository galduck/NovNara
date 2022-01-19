<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,novNara.*"%>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="mMgr" class="novNara.MemberMgr" />
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
<script src="script.js"></script>
</head>
<body>
	<br>
	<%@ include file="../top.jsp"%>
	<%
		MemberBean mBean = mMgr.getMember(id);
	%>
	<div class="huge-sign-up-box">
	
	<form name="regForm" method="post" action="memberUpdateProc.jsp">
	<h1 class="h1_title" align="center"><%=mBean.getId()%>
										회원님의 정보를 수정합니다.</h1>
	<div class="big-sign-up-box">
		<div class="sign-up-box">
		    <h3 class="sign-up">아이디</h3>
		    <h3 class="sign-up" padding="0px 10px"><%=mBean.getId()%></h3>
		</div>
		
		<div class="sign-up-box">
		    <h3 class="sign-up">비밀 번호</h3>
		    <input class="sign-up input" name="pwd"  size="15" value="<%=mBean.getPwd()%>">
		</div>
	
		<div class="sign-up-box">
	    <h3 class="sign-up">이메일</h3>
	    <input class="sign-up input" name="email" class="input" size="15"
								value="<%=mBean.getEmail()%>">
		</div>
	
	</div>
	<div class="sign-up-box button-box">
		<button class="btn sign-up-btn" >수정완료</button>
		<button class="btn sign-up-btn" type="reset">다시 쓰기</button>
	</div>
		<input type="hidden" name="id" value="<%=id%>">
	</form>
	</div>
	<%@ include file="../bottom.jsp"%>
	
</body>
</html>
