<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<title>Read Board</title>
</head>
<body>
<h1>
	Hello!
</h1>
<form name="editform" action="BoardController?cmd=edit" method="post">
	<input type="hidden" name="boardindex" value="${board.boardindex}"/>
	<input type="hidden" name="email" value="${board.email}"/>
	<textarea rows="15" cols="150" id="content" name="content">${board.content}</textarea><br>
	Password : <input type="password" id="password" name="password"/><br>
	<input type="button" class="btn btn-default btn-sm" value="edit" onclick="modify('${board.password}')"/>
</form>
</body>
<script>
	function modify(password){
		var userPassword = document.getElementById("password").value;
		var content = document.getElementById("content").value;
		if(userPassword=="" || content==""){
			alert("empty contents");
		} else if(userPassword != password){
			alert("패스워드가 일치하지 않습니다.");
		} else{
			document.editform.submit();
		}
	}
</script>
</html>
