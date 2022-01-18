package novNara;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/notice/noticeUpdate")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//���信 ���� ���ڵ�(��� Ʋ���� �ѱ۷� �ڹٽ�ũ��Ʈ �ڵ� ����)
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		NoticeBean bean = (NoticeBean)session.getAttribute("bean");
		String dbPass = bean.getPass();
		MultipartRequest multi = 
				new MultipartRequest(request, NoticeMgr.SAVEDIRECTORY,
						NoticeMgr.MAXPOSTSIZE,NoticeMgr.ENCODING,
						new DefaultFileRenamePolicy());
		String inPass = multi.getParameter("pass");
		if(dbPass.equals(inPass)) {//����� ��ġ
			NoticeMgr mgr = new NoticeMgr();
			mgr.updateNotice2(multi);
			String nowPage = multi.getParameter("nowPage");
			String numPerPage = multi.getParameter("numPerPage");
			response.sendRedirect("noticeRead.jsp?nowPage="+nowPage
					+"&numPerPage="+numPerPage+"&num="+bean.getNum());
		}else{//��� Ʋ�ȴٰ� ���â
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�Է��Ͻ� ��й�ȣ�� �ƴմϴ�.');");
			out.println("history.back();");
			out.println("</script>");
		}
	}
}

