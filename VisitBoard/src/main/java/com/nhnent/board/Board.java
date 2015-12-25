package com.nhnent.board;

import java.util.Date;

public class Board {
	Integer index;
	String email;
	String password;
	String content;
	Date time;
	
	private Board(){}
	
	public Board(Integer index, String email, String password, String content){
		this.index = index;
		this.email = email;
		this.password = password;
		this.content = content;
	}
	
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
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
