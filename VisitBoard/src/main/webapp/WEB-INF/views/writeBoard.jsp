<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<script type="text/javascript" src='<c:url value="/resources/js/core.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/resources/js/sha256.js"/>'></script>
	<title>Write Board</title>
</head>
<body>
<h1>
	Hello!  
</h1>

<form name="writeform" action="BoardController?cmd=write" method="post">
<table class="table">
	<tr>
		<td>Email <input type="text" id="email" name="email"/></td>
		<td>Password <input type="password" id="password" name="password"/></td>
		<td><input type="button" value="완료" onclick="isValid()"/></td>
	</tr>
	<tr><td>Content<br><textarea rows="15" cols="40" id="content" size="100" name="content"></textarea></td></tr>
</table>
</form>
</body>
<script>
	function isValid(){
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		var content = document.getElementById("content").value;
		var reg_email=/^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{2,5}$/;
		
	    var sha256 = CryptoJS.SHA256(password).toString();

	    if(email=="" || password=="" || content==""){
			alert("empty contents")
		} else if(reg_email.test(email) == false){
			alert("client not valid email");
		} else{
			document.getElementById("password").value = sha256;
			document.writeform.submit();
		}
	}
</script>
</html>
