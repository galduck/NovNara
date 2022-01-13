<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>NovNara</title>
<link rel="stylesheet" href="../css/style.css" />
<script src="script.js"></script>
</head>

<body  topmargin="100" bottommargin="100">

<%
    String admin_id = (String)session.getAttribute("adminKey");

	if(admin_id == null) {
		response.sendRedirect("adminLogin.jsp");
	}
%>

	<div class="member-buttons">
		<input class="btn" value="로그아웃" >
    </div>
    <nav class="giant-box">
        <div class="oatmeal-box">
            <div class="nav-icons">
                <i class="fas fa-shopping-basket fa-lg"><a href="../cart/cartList.jsp"></a></i>
	            <i class="fas fa-bars fa-lg" ><a href="../order/orderList.jsp"></a></i>
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
            <div class="search-box">
                <div class="search">
                    <i class="fas fa-search fa-2x"></i>
                </div>
            </div>
        </div>
    </nav>

		<div height="190" align="center">관리자 화면입니다.</div>
		
	<%@ include file="../bottom.jsp"%>
    <script src="https://kit.fontawesome.com/6478f529f2.js"
    crossorigin="anonymous"></script>
</body>
</html>

