<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<link rel="stylesheet" href="css/style.css" />
<meta charset="UTF-8">
<title>NovNara</title>
</head>
<body bottommargin="100">
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
<nav class="giant-box" >
  <div class="oatmeal-box">
	<div class="nav-icons">
  		<div>
   			<a href="../cart/cartList.jsp">
   				<i class="fas fa-shopping-basket fa-lg"></i>
   			</a>
		</div>
       	<div>
	       	<a href="../order/orderList.jsp">
	        	<i class="fas fa-bars fa-lg" ></i>
	       	</a>
       	</div>
	</div>  
             
         <div class="logo-box">
             <img src="./img/logo2.png" class="logo2" />
         </div>
         <div class="menu">
             <span class="home" ><a href="./index.jsp">홈</a></span>
             <span class="best"><a href="./product/best.jsp" >베스트</a></span>
             <span class="product"><a href="./product/product.jsp?sort=0" >전체상품</a></span>
             <span class="objet"><a href="./product/product.jsp?sort=1" >소품</a></span>
             <span class="light"><a href="./product/product.jsp?sort=2" >조명</a></span>
         </div>
         <div class="search-box">
             <div class="search">
                 <i class="fas fa-search fa-2x"></i>
        	 </div>
         </div>
     </div>
 </nav>
   
<footer class="footer">
  <hr>
  <p class="copyright">
  	<span class="span_admin">
  		<button class="btn_admin"><a href="./admin/index.jsp">&copy; 2022. Miae Je</a></button>
  	</span>
  </p>
</footer>
   <script
   src="https://kit.fontawesome.com/6478f529f2.js"
   crossorigin="anonymous"></script>
</body>
</html>