<%@ page pageEncoding="UTF-8"%>
<%
    String admin_id = (String)session.getAttribute("adminKey");

	if(admin_id == null) {
		response.sendRedirect("adminLogin.jsp");
	}
%>
<form class="member-buttons" name="input" action="../admin/adminLogout.jsp" method="get">
	<input class="btn" type="submit" value="로그아웃" >
</form>
<nav class="giant-box">
    <div class="oatmeal-box">
        <div class="nav-icons">
       		<div>
       			<a href="../qna/qna.jsp">
       				<i class="fas fa-question-circle fa-lg"></i>
       			</a>
       		</div>
   		</div>  
        <div class="logo-box">
            <img src="../img/logo2.png" class="logo2" />
        </div>
        <div class="menu">
            <span class="home" ><a href="../index.jsp">홈</a></span>
            <span class="product"><a href="memberMgr.jsp" >회원관리</a></span>
            <span class="objet"><a href="productMgr.jsp" >상품관리</a></span>
            <span class="light"><a href="orderMgr.jsp">주문관리</a></span>
        </div>
        
    </div>
</nav>

 <script src="https://kit.fontawesome.com/6478f529f2.js"
crossorigin="anonymous"></script>