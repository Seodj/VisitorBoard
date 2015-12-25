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
<table>
<tr>
<th>이메일</th>
<th>내용</th>
</tr>
<c:forEach var="list" items="${boardList}">
<tr>
<td>${list.email}</td>
<td>${list.content}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
