package com.nhnent.board;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Board {
	Date formattedDate = new Date();
	Locale locale = new Locale("ko");
	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

	int index;
	String email;
	String password;
	String content;
	String date = dateFormat.format(formattedDate);
	
	public Board(String email,String password, String content){
		this.email = email;
		this.password = password;
		this.content = content;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
}
