<!-- productList.jsp -->
<%@page import="novNara.UtilMgr"%>
<%@page import="novNara.ProductBean"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="pMgr" class="novNara.ProductMgr"/>
<%
	int sort = 0;
	//검색에 필요한 변수
	String keyField = "", keyWord = "";
	//검색일때
	if(request.getParameter("keyWord")!=null){
		keyField = request.getParameter("keyField");
		keyWord = request.getParameter("keyWord");
	}
	
	//검색 후에 다시 처음화면 요청
	if(request.getParameter("reload")!=null&&
	request.getParameter("reload").equals("true")){
		keyField = ""; keyWord = "";
	}
	
	if(request.getParameter("sort")!=null){
		sort = UtilMgr.parseInt(request, "sort");
	}
	request.setCharacterEncoding("UTF-8");
	Vector<ProductBean> pvlist = pMgr.getProductList(sort);
%>
<html>
<head>
<title>NovNara</title>
<script src="script.js"></script>
<link rel="stylesheet" href="../css/style.css" />
<script>
function check() {
	if(document.searchFrm.keyWord.value==""){
		alert("검색어를 입력하세요.");
		document.searchFrm.keyWord.focus();
		return;
	}
	document.searchFrm.submit();
}

function list() {//검색을 통해서 url에 남은 get방식 조건값 초기화
	document.listFrm.action="../product/product.jsp";
	document.listFrm.submit();
}

</script>
</head>
<body>
	<%@ include file="../top.jsp" %>

<%
	Vector<ProductBean> vlist = pMgr.getSearchList(keyWord);
	int listSize = vlist.size();//브라우저 화면에 표시될 번호
	if(vlist.isEmpty()){
		out.println("등록된 게시물이 없습니다.");
	}else{
%>
<div class="one_more_product_cover">
<div class="total_product_cover">
		
		<%
					for(int i=0;i<pvlist.size();i++){
						ProductBean pbean = pvlist.get(i);
		%>
		
		<div class="total_product">
			<a href="../product/productDetail.jsp?no=<%=pbean.getNo() %>">
			<div class="total_product_div total_product_img" >					
				<img src="../img/<%=pbean.getImage() %>" height="380px" width="430px" >
			</div>
			<div class="total_product_div"><%=pbean.getName() %></div>
			<div class="total_product_div"><%=UtilMgr.monFormat(pbean.getPrice())%></div>
			<form name="detail" method="post" action="../product/productDetail.jsp" >
				<input type="hidden" name="no">
			</form>
		</div>
		
		<%}%>
	</div>
</div>

<%}//--if-else%>
	<form name="listFrm" method="post">
		<input type="hidden" name="reload" value="true">
	</form>
	<%@ include file="../bottom.jsp" %>
</body>
</html>




