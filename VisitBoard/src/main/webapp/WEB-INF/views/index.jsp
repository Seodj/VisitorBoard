<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Index</title>
</head>
<body>
<h1>
	
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href = "writeBoard">방명록 쓰기</a>
<a href="BoardController?cmd=read">방명록 읽기</a>
</body>
</html>
