package com.nhnent.board;

import java.util.Date;

public class Board {
	Integer boardindex;
	String email;
	String password;
	String content;
	Date time;
	
	private Board(){}
	
	public Board(Integer boardindex, String email, String password, String content){
		this.boardindex = boardindex;
		this.email = email;
		this.password = password;
		this.content = content;
	}

	public Integer getBoardindex() {
		return boardindex;
	}

	public void setBoardindex(Integer boardindex) {
		this.boardindex = boardindex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
}
