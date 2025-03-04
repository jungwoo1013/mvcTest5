package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import vo.BoardVO;

@WebServlet({ "/boardInput", "/bI" })
public class BoardInputController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { 
	 * 	String viewPage = "/boardTest/boardInput.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
			}
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "/WEB-INF/boardTest/boardInput.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		String name = request.getParameter("name")==null ? "" : request.getParameter("name");
		String title = request.getParameter("title")==null ? "" : request.getParameter("title");
		String content = request.getParameter("content")==null ? "" : request.getParameter("content");
		/* String hostIp = request.getParameter("hostIp"); */
		String hostIp = request.getRemoteAddr();
		
		BoardVO vo = new BoardVO();
		//.vo.setName(request.getParameter("name")==null ? "" : request.getParameter("name"));
		vo.setName(name);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setHostIp(hostIp);
		
		BoardDao dao = new BoardDao();
		
		int res = dao.setBoardInput(vo);
		
		PrintWriter out = response.getWriter();
		if(res != 0) {
			out.println("<script>");
			out.println("alert('게시글이 등록되었습니다.')");
			out.println("location.href='boardList'");
			out.println("</script>");
		}
		else {
			out.println("<script>");
			out.println("alert('게시글이 등록 실패하였습니다..')");
			out.println("location.href='boardInput'");
			out.println("</script>");
		}
	}

}
