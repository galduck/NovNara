<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<link rel="stylesheet" href="css/style.css" />
<meta charset="UTF-8">
<title>NovNara</title>
</head>
<body>
<%
	String id = (String)session.getAttribute("idKey");
	
	String log="";
	if(id == null) log ="<a href=./login/login.jsp>로그인</a>";
	else log = "<a href=./login/logout.jsp>로그아웃</a>";

	String reg="";
	if(id == null) reg ="<a href=./member/member.jsp>회원가입</a>";
	else reg = "<a href=./member/memberUpdate.jsp>마이페이지</a>";
%>

	<div class="member-buttons">
        <button class="btn" ><%=log %></button>
        <button class="btn" ><%=reg%></button>
    </div>
    <nav class="giant-box">
        <div class="oatmeal-box">
            <div class="nav-icons">
                <i class="fas fa-search fa-lg"></i>
                <i class="fas fa-shopping-basket fa-lg"><a href="cart/cartList.jsp"></a></i>

				<!-- 토글버튼 만들기 -->
                <label class="toggle_button" for="toggle_button"> <i class="fas fa-bars fa-lg" ></i></label>
	                <input id="toggle_button" type="checkbox">
	                <nav id="main_nav">
	                	<ul id="toggle_contents">
	                		<li><a href="./product/product.jsp">전체상품</a></li>
    						<li><a href="./cart/cartList.jsp">장바구니</a></li>
    						<li><a href="./order/orderList.jsp">구매목록</a></li>
	                	</ul>
	                </nav>
                
            </div>  
            <div class="logo-box">
                <img src="./img/logo2.png" class="logo2" />
            </div>
            <div class="menu">
                <span class="home" ><a href="./index.jsp">홈</a></span>
                <span class="best"><a href="./product/best.jsp" >베스트</a></span>
                <span class="product"><a href="./product/product.jsp" >전체상품</a></span>
                <span class="objet"><a href="./product/objet.jsp" >소품</a></span>
                <span class="light"><a href="./product/light.jsp" >조명</a></span>
            </div>
            <div class="search-box">
                <div class="search">
                    <i class="fas fa-search fa-2x"></i>
                </div>
            </div>
        </div>
    </nav>
    
	<footer>
	  <hr>
	  <p class="copyright">
	  	&copy; 2022. Miae Je
	  	<span class="span_admin">
	  		<button class="btn_admin"><a href="./admin/index.jsp">관리자</a></button>
	  	</span>
	  </p>
	</footer>
    <script
    src="https://kit.fontawesome.com/6478f529f2.js"
    crossorigin="anonymous"></script>
</body>
</html>