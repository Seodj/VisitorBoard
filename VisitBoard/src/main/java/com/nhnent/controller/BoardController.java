package com.nhnent.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nhnent.board.Board;
import com.nhnent.board.BoardDao;

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
			read(request,response);
		}else if(cmd.equals("modify")){
			
		}
	}
	
	public void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 전송된 데이터 얻어오기
		int index = 0;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		Date time = null;
		
		Board board = new Board(index, email,password,content);
		
		// 데이터를 db에 저장하기
		BoardDao boardDao = new BoardDao();
		boolean isInsert = boardDao.write(board);
		
		// 뷰페이지로 이동
		if(isInsert){
			response.sendRedirect("/visitorboard");
		} else{
			request.getRequestDispatcher("/error").forward(request, response);
		}
	}
	
	public void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 리스트 얻어오기
		BoardDao boardDao = new BoardDao();
		List<Board> boardList = boardDao.getList();
		
		if(boardList != null){
			request.setAttribute("boardList", boardList);
			request.getRequestDispatcher("/readBoard").forward(request, response);
		} else{
			request.getRequestDispatcher("/error").forward(request, response);
		}
	}

}