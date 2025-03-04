package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.BoardDao;
import vo.BoardVO;

@SuppressWarnings("serial")
@WebServlet("/boardList")
public class BoardListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		
		
		List<BoardVO> vos = dao.getBoardList();
		
		request.setAttribute("vos", vos);
		
		String viewPage = "/WEB-INF/boardTest/boardList.jsp";
		RequestDispatcher dispatcher	= request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
}
