<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form action="BoardController?cmd=write" method="post">
Email <input type="text" name="email"/>
Password <input type="password" name="password"/>
Content <input type="textarea" name="content"/>
<input type="submit"/>
</form>
</body>
</html>
