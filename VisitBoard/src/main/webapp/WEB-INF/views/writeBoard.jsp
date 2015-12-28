<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Write Board</title>
</head>
<body>
<h1>
	Hello!  
</h1>

<form action="BoardController?cmd=write" method="post">
<table class="table">
	<tr>
		<td>Email <input type="text" name="email"/></td>
		<td>Password <input type="password" name="password"/></td>
		<td><input type="submit" value="완료"/></td>
	</tr>
	<tr><td>Content<br><textarea rows="15" cols="40" name="content"></textarea></td></tr>
</table>
</form>
</body>
</html>
