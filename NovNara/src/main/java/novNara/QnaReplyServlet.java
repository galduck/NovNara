package novNara;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/qna/QnaReply")
public class QnaReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		QnaMgr mgr = new QnaMgr();
		QnaBean reBean = new QnaBean();
		reBean.setName(request.getParameter("name"));
		reBean.setSubject(request.getParameter("subject"));
		reBean.setContent(request.getParameter("content"));
		reBean.setRef(Integer.parseInt(request.getParameter("ref")));
		reBean.setPos(Integer.parseInt(request.getParameter("pos")));
		reBean.setDepth(Integer.parseInt(request.getParameter("depth")));
		reBean.setPass(request.getParameter("pass"));
		reBean.setIp(request.getParameter("ip"));
		
		mgr.replyQna(reBean);
		mgr.replyUpQna(reBean.getRef(), reBean.getPos());
		
		String nowPage = request.getParameter("nowPage");
		String numPerPage = request.getParameter("numPerPage");
		response.sendRedirect("qnaList.jsp?nowPage="+nowPage
				+"&numPerPage="+numPerPage);
	}
}








