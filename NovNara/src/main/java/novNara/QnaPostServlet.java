package novNara;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 : 화면에 보여지는 view(jsp)는 아니고 기능적인 코드가 처리되는 자바파일
//URL 호출 : http://localhost/myapp/Qna/QnaPost
@WebServlet("/qna/qnaPost")
public class QnaPostServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		QnaMgr mgr = new QnaMgr();
		mgr.insertQna(request);
		response.sendRedirect("../qna/qnaList.jsp");
	}
}








