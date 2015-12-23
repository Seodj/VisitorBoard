package com.nhnent.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhnent.board.Board;
import com.nhnent.board.BoardDao;
import com.nhnent.board.User;

@SuppressWarnings("serial")
@WebServlet("/BoardController")
public class BoardController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("write")){
			write(request,response);
		}else if(cmd.equals("read")){
			
		}else if(cmd.equals("modify")){
			
		}
	}
	
	public void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 전송된 데이터 얻어오기
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		Board board = new Board(email,password,content);
		
		// 데이터를 db에 저장하기
		BoardDao boardDao = new BoardDao();
		boolean isInsert = boardDao.write(board);
		
		// 뷰페이지로 이동
		if(isInsert){
			response.sendRedirect("/visitorboard");
		} else{
			response.sendRedirect("error.jsp");
		}
	}

}