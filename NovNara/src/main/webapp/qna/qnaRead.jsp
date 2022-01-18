<!-- read.jsp -->
<%@page import="java.util.Vector"%>
<%@page import="novNara.QnaCommentBean"%>
<%@page import="novNara.QnaBean"%>
<%@page import="novNara.QnaUtilMgr"%>
<%@page contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="mgr" class="novNara.QnaMgr"/>
<jsp:useBean id="cmgr" class="novNara.QnaCommentMgr"/>
<%
		request.setCharacterEncoding("UTF-8");
		String keyField = request.getParameter("keyField");
		String keyWord = request.getParameter("keyWord");
		//nowPage 정수이지만 여기서는 계산이 되는 값이 아니고 
		//그대로 list.jsp로 넘기는 값이기 때문에 정수로 변환 안해된다.
		String nowPage = request.getParameter("nowPage");
		String numPerPage = request.getParameter("numPerPage");
		int num = QnaUtilMgr.parseInt(request, "num");
		
		String flag = request.getParameter("flag");
		if(flag!=null){
			if(flag.equals("insert")){
				//댓글 입력 요청
				QnaCommentBean cbean = new QnaCommentBean();
				cbean.setNum(num);
				cbean.setName(request.getParameter("cName"));
				cbean.setComment(request.getParameter("comment"));
				cmgr.insertQnaComment(cbean);
			}else if(flag.equals("delete")){
				//댓글 삭제 요청
				cmgr.deleteQnaComment(QnaUtilMgr.parseInt(request, "cnum"));
			}
		}else {
			//조회수증가
			mgr.upCount(num);
		}
		QnaBean bean = mgr.getQna(num);
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
		document.listFrm.action = "../qna/qnaList.jsp";
		document.listFrm.submit();
	}
	function cInsert() {
		if(document.cFrm.comment.value==""){
			alert("댓글을 입력하세요.");
			document.cFrm.comment.focus();
			return;
		}
		document.cFrm.submit();
	}
	function cDel(cnum) {
		document.cFrm.cnum.value=cnum;
		document.cFrm.flag.value="delete";
		document.cFrm.submit();
	}
</script>
</head>
<body bgcolor="#FFFFCC">
	<%@ include file="../top.jsp" %>
<br/><br/>
<table align="center" width="600" cellspacing="3">
 <tr>
  <td  class="table_td" bgcolor="#9CA2EE" height="25" align="center">글읽기</td>
 </tr>
 <tr>
  <td  class="table_td" colspan="2">
   <table cellpadding="3" cellspacing="0" width="100%"> 
    <tr> 
  <td  class="table_td" align="center" bgcolor="#DDDDDD" width="10%"> 이 름 </td>
  <td  class="table_td" bgcolor="#FFFFE8"><%=name%></td>
  <td  class="table_td" align="center" bgcolor="#DDDDDD" width="10%"> 등록날짜 </td>
  <td  class="table_td" bgcolor="#FFFFE8"><%=regdate%></td>
 </tr>
 <tr> 
    <td  class="table_td" align="center" bgcolor="#DDDDDD"> 제 목</td>
    <td  class="table_td" bgcolor="#FFFFE8" colspan="3"><%=subject%></td>
   </tr>
   <tr> 
     <td  class="table_td" align="center" bgcolor="#DDDDDD">첨부파일</td>
     <td  class="table_td" bgcolor="#FFFFE8" colspan="3">
    	<%if(filename!=null&&!filename.equals("")){%>
    	 <a href="javascript:down('<%=filename%>')"><%=filename%></a>
    	 <font color="blue">(<%=QnaUtilMgr.intFormat(filesize)%>bytes)</font>
    	 <%}else{ %>
    	 	첨부된 파일이 없습니다.
    	 <%}%>
     </td>
   </tr>
   <tr> 
    <td  class="table_td" colspan="4"><br/><pre><%=content%></pre><br/></td>
   </tr>
   <tr>
    <td  class="table_td" colspan="4" align="right">
     <%=ip%>로 부터 글을 남기셨습니다./ 조회수 <%=count%>
    </td>
   </tr>
   </table>
  </td>
 </tr>
 <tr>
  <td class="table_td"  align="center" colspan="2">
  <!-- 댓글 입력폼 Start -->
  <form method="post" name="cFrm">
		<table>
			<tr  align="center">
				<td  class="table_td" width="50">이 름</td>
				<td  class="table_td" align="left">
					<input  class="table_td" name="cName" size="10" value="aaa">
				</td>
			</tr>
			<tr align="center">
				<td class="table_td" >내 용</td>
				<td class="table_td" >
				<input  class="table_td" name="comment" size="50"> 
				<input  class="table_td" type="button" value="등록" onclick="cInsert()"></td>
			</tr>
		</table>
	 <input type="hidden" name="flag" value="insert">	
	 <input type="hidden" name="num" value="<%=num%>">
	 <input type="hidden" name="cnum">
    <input type="hidden" name="nowPage" value="<%=nowPage%>">
    <input type="hidden" name="numPerPage" value="<%=numPerPage%>">
   <%if(!(keyWord==null||keyWord.equals(""))){ %>
    <input type="hidden" name="keyField" value="<%=keyField%>">
    <input type="hidden" name="keyWord" value="<%=keyWord%>">
	<%}%>
	</form>
  <!-- 댓글 입력폼 End -->
 <hr/>
 <!-- 댓글 List Start -->
  <%
  			Vector<QnaCommentBean> cvlist = cmgr.getQnaComment(num);
  			if(!cvlist.isEmpty()){
  %>
  <table>
  	<%
  			for(int i=0;i<cvlist.size();i++){
  				QnaCommentBean cbean = cvlist.get(i);
  				int cnum = cbean.getCnum();
  				String cname = cbean.getName();
  				String comment = cbean.getComment();
  				String cregdate = cbean.getRegdate();
  	%>
  		<tr>
			<td  class="table_td" colspan="3" width="600"><b><%=cname%></b></td>
		</tr>
		<tr>
			<td class="table_td" >댓글:<%=comment%></td>
			<td  class="table_td" align="right"><%=cregdate%></td>
			<td  class="table_td" align="center" valign="middle">
			<input  class="table_td" type="button" value="삭제" onclick="cDel('<%=cnum%>')">
			</td>
		</tr>
		<tr>
			<td  class="table_td" colspan="3"><br/></td>
		</tr>
 	<%}//--for%>
  </table>
  <%}//--if%>
 <!-- 댓글 List End -->
 [ <a href="javascript:list()"  class="table_td" >리스트</a> | 
 <a href="qnaUpdate.jsp?nowPage=<%=nowPage%>&num=<%=num%>&numPerPage=<%=numPerPage%>"  class="table_td" >수 정</a> |
 <a href="qnaReply.jsp?nowPage=<%=nowPage%>&numPerPage=<%=numPerPage%>" class="table_td"  >답 변</a> |
 <a href="qnaDelete.jsp?nowPage=<%=nowPage%>&num=<%=num%>" class="table_td" >삭 제</a> ]<br/>
  </td>
 </tr>
</table>
<form method="post" name="downFrm" action="../qna/qnaDownload.jsp">
	<input  class="table_td" type="hidden" name="filename">
</form>

<form name="listFrm">
	<input type="hidden" name="nowPage" value="<%=nowPage%>">
	<input type="hidden" name="numPerPage" value="<%=numPerPage%>">
	<%if(!(keyWord==null||keyWord.equals(""))){%>
	<input type="hidden" name="keyField" value="<%=keyField%>">
	<input type="hidden" name="keyWord" value="<%=keyWord%>">
	<%}%>
</form>
	<%@ include file="../bottom.jsp" %>
</body>
</html>