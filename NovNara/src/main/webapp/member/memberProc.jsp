<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="mMgr" class="novNara.MemberMgr" />
<jsp:useBean id="mBean" class="novNara.MemberBean" />
<jsp:setProperty name="mBean" property="*" />
<%boolean flag = mMgr.insertMember(mBean);%>
<html>
<head>
<title>회원가입 확인</title>
<link rel="stylesheet" href="../css/style.css" />
</head>
<body >
	<%@ include file="../top.jsp"%>
<br/><br/>
<div align="center">
<%
if(flag){
	  out.println("<b>회원가입이 완료되었습니다.</b><p>");
	  out.println("<a href=../login/login.jsp>로그인</a>");
	}else{
	  out.println("<b>다시 입력하여 주십시오.</b><p>");
	  out.println("<a href=../member/member.jsp>다시 가입</a>");
	}
%>
	<%@ include file="../bottom.jsp"%>
</div>
</body>
</html>

