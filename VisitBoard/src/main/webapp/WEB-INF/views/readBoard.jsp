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
<table class="table table-striped">
	<tr>
		<th>내용</th>
		<th>수정</th>
		</tr>
	<c:forEach var="list" items="${boardList}">
	<tr>
		<td>${list.email}<br>${list.content}</td>
		<td><input type="button" class="btn btn-default btn-sm" value="edit" onclick="modify('${list.boardindex}')"/></td>
	</tr>
	</c:forEach>
</table>
</body>
<script>
	function modify(boardindex){
		window.open("BoardController?cmd=getOne&boardindex=" + boardindex, "","", "height=500");
	}
</script>
</html>
