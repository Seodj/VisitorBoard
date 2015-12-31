package com.nhnent.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	BoardDao boardDao = new BoardDao();
	
	protected void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		
		if(cmd.equals("write")){
			write(request,response);
		}else if(cmd.equals("read")){
			read(request,response);
		}else if(cmd.equals("getOne")){
			getOne(request,response);
		}else if(cmd.equals("edit")){
			edit(request,response);
		}
	}
	
	public void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 전송된 데이터 얻어오기
		int index = 0;
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		Date time = null;
		
		String regex_email = "^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{2,5}$";
		Pattern pattern = Pattern.compile(regex_email);
		Matcher match = pattern.matcher(email);
		
		if(!(match.find())){
			PrintWriter out = response.getWriter();
			out.println("<script>alert('not valid email');history.back();</script>");
			return ;
		}
		
		Board board = new Board(index, email,password,content);
		
		// 데이터를 db에 저장하기
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
		List<Board> boardList = boardDao.getList();
		
		if(boardList != null){
			request.setAttribute("boardList", boardList);
			request.getRequestDispatcher("/readBoard").forward(request, response);
		} else{
			request.getRequestDispatcher("/error").forward(request, response);
		}
	}
	
	public void getOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 리스트 얻어오기
		String boardindex = request.getParameter("boardindex");
		Board board = boardDao.getOne(boardindex);
		
		if(board != null){
			request.setAttribute("board", board);
			request.getRequestDispatcher("/editBoard").forward(request, response);
		} else{
			request.getRequestDispatcher("/error").forward(request, response);
		}
	}
	
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 리스트 얻어오기
		PrintWriter out = response.getWriter();
		
		int boardindex = Integer.parseInt(request.getParameter("boardindex"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		Board editBoard = new Board(boardindex, email, password, content);
		int checkEdit = boardDao.edit(editBoard);
		
		if(checkEdit > 0){
			System.out.println("success edit board");
			out.println("<script>alert('Success Edit');window.opener.location.reload();window.close();</script>");
		} else{
			request.getRequestDispatcher("/error").forward(request, response);
		}
	}

}