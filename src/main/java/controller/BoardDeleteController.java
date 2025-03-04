package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
@SuppressWarnings("serial")
@WebServlet("/boardDelete")

public class BoardDeleteController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null ? 0 : Integer.parseInt(request.getParameter("idx"));
		
		BoardDao dao = new BoardDao();
		
		int res = dao.setBoardDelete(idx);
		
		PrintWriter out = response.getWriter();
		if(res != 0) {
			out.println("<script>");
			out.println("alert('게시글이 삭제되었습니다.')");
			out.println("location.href='boardList'");
			out.println("</script>");
		}
		else {
			out.println("<script>");
			out.println("alert('게시글이 삭제 실패하였습니다..')");
			out.println("location.href='boardList'");
			out.println("</script>");
		}
	}
}
