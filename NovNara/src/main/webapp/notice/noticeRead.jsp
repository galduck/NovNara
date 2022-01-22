<!-- read.jsp -->
<%@page import="java.util.Vector"%>
<%@page import="novNara.NoticeBean"%>
<%@page import="novNara.NoticeUtilMgr"%>
<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="mgr" class="novNara.NoticeMgr"/>
<%
		request.setCharacterEncoding("UTF-8");
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		//nowPage 정수이지만 여기서는 계산이 되는 값이 아니고 
		//그대로 list.jsp로 넘기는 값이기 때문에 정수로 변환 안해된다.
		String nowPage = request.getParameter("nowPage");
		String numPerPage = request.getParameter("numPerPage");
		int num = NoticeUtilMgr.parseInt(request, "num");
		//조회수증가
		mgr.upCount(num);
		
		NoticeBean bean = mgr.getNotice(num);
		String name = bean.getName();
		String subject = bean.getSubject();
		String regdate = bean.getRegdate();
		String content = bean.getContent();
		String filename = bean.getFilename();
		int filesize = bean.getFilesize();
		String ip = bean.getIp();
		int count = bean.getCount();
		
		//읽어온 게시물을 답변과 수정, 삭제를 위해서 session 저장
		session.setAttribute("bean", bean);
%>
<!DOCTYPE html>
<html>
<head>
<title>NovNara</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function down(filename) {
		document.downFrm.filename.value=filename;
		document.downFrm.submit();
	}
	function list() {
		document.listFrm.action = "noticeList.jsp";
		document.listFrm.submit();
	}
	
	
</script>
</head>
<body>
	<%@ include file="../top.jsp" %>
<div align="center">
<h3 class="h1_title">공지사항</h3>
<table align="center" width="600" cellspacing="3">
 <tr>
  <td class="table_td"  colspan="2">
   <table cellpadding="3" cellspacing="0" width="100%"> 
    <tr> 
  <td class="table_td"  align="center" bgcolor="#EAE1D8" width="15%">작성자</td>
  <td class="table_td"  >관리자</td>
  <td class="table_td"  align="center" bgcolor="#EAE1D8" width="15%"> 등록날짜 </td>
  <td class="table_td" ><%=regdate%></td>
 </tr>
 <tr> 
    <td class="table_td"  align="center" bgcolor="#EAE1D8"> 제 목</td>
    <td class="table_td"  colspan="3"><%=subject%></td>
   </tr>
   <tr> 
     <td class="table_td"  align="center" bgcolor="#EAE1D8">첨부파일</td>
     <td class="table_td"  colspan="3">
    	<%if(filename!=null&&!filename.equals("")){%>
    	 <a href="javascript:down('<%=filename%>')"><%=filename%></a>
    	 <font color="blue">(<%=NoticeUtilMgr.intFormat(filesize)%>bytes)</font>
    	 <%}else{ %>
    	 	첨부된 파일이 없습니다.
    	 <%}%>
     </td>
   </tr>
   <tr> 
    <td class="table_td"  colspan="4"><br/><pre><%=content%></pre><br/></td>
   </tr>
   <tr>
    <td class="table_td"  colspan="4" align="right">
     <%=ip%>로 부터 글을 남기셨습니다./ 조회수 <%=count%>
    </td>
   </tr>
   </table>
  </td>
 </tr>
 <tr>
  <td class="table_td table_padding"  align="center" colspan="2">

 [ <a href="javascript:list()" >리스트</a> | 
 <a href="noticeUpdate.jsp?nowPage=<%=nowPage%>&num=<%=num%>&numPerPage=<%=numPerPage%>" >수 정</a> |
 <a href="noticeReply.jsp?nowPage=<%=nowPage%>&numPerPage=<%=numPerPage%>" >답 변</a> |
 <a href="noticeDelete.jsp?nowPage=<%=nowPage%>&num=<%=num%>">삭 제</a> ]<br/>
  </td>
 </tr>
</table>
</div>
<form method="post" name="downFrm" action="download.jsp">
	<input type="hidden" name="filename">
</form>

<form name="listFrm">
	<input type="hidden" name="nowPage" value="<%=nowPage%>">
	<input type="hidden" name="numPerPage" value="<%=numPerPage%>">
	<%if(!(keyWord==null||keyWord.equals(""))){%>
	<input type="hidden" name="keyField" value="<%=keyField%>">
	<input type="hidden" name="keyWord" value="<%=keyWord%>">
	<%}%>
</form>
</body>
</html>