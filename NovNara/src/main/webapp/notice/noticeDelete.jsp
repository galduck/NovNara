<%@page import="novNara.NoticeBean"%>
<%@page import="novNara.NoticeUtilMgr"%>
<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="mgr" class="novNara.NoticeMgr"/>
<!DOCTYPE html>
<html>
<head>
<% 
		request.setCharacterEncoding("UTF-8");
		String nowPage = request.getParameter("nowPage");
		int num = NoticeUtilMgr.parseInt(request, "num");
		//비번을 입력을 받아서 삭제를 처리하는 기능
		if(request.getParameter("pass")!=null){
			NoticeBean bean = (NoticeBean)session.getAttribute("bean");
			String inPass = request.getParameter("pass");//delete.jsp입력한 pass값
			String dbPass = bean.getPass();//테이블에 저장된 pass
			//inPass==dbPass : 클래스은 타입은 객체의 주소값을 비교
			//int a==int b : 자바기본형은 값을 비교 
			if(inPass.equals(dbPass)/*객체내용비교*/){
				mgr.deleteNotice(num);
				String url = "noticeList.jsp?nowPage"+nowPage;
				response.sendRedirect(url);
			}else{%>
				<script type="text/javascript">
					alert("입력하신 비밀번호가 아닙니다.");
					history.back();
				</script>
			<%}
		}else{//비번을 입력받기 위한 폼 출력
%>
<title>JSP Notice</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function check() {
		if (document.delFrm.pass.value == "") {
			alert("패스워드를 입력하세요.");
			document.delFrm.pass.focus();
			return;
		}
		document.delFrm.submit();
	}
</script>
</head>
<body >
	<%@ include file="../top.jsp" %>

<div align="center"><br/><br/>
	<h3>사용자의 비밀번호를 입력해주세요.</h3>
	<form name="delFrm" method="post">
		<table width="70%" cellspacing="0" cellpadding="2">
			<tr>
				<td  class="table_td" align="center">
					<table width=80%>
						<tr>
							<td  class="table_td" align="center">
								<input type="password" name="pass" size="17" maxlength="15">
							</td>
						</tr>
						<tr>
							<td class="table_td" ><hr size="1" color="#eeeeee"/></td>
						</tr>
						<tr>
							<td class="table_td"  align="center">
								<input class="btn" type="button" value="삭제완료" onClick="check()"> 
								<input class="btn" type="reset" value="다시쓰기">
								<input class="btn" type="button" value="뒤로" onClick="history.go(-1)">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<input type="hidden" name="nowPage" value="<%=nowPage%>"> 
		<input type="hidden" name="num" value="<%=num%>">
	</form>
</div>
<%}%>
</body>
</html>