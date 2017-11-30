<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form action="/login" method="POST">
			<p style="color: red">${ errorMessage }</p>
			<div>Your name is: <input type="text" name="name"/></div>
			<div>Your password is: <input type="password" name="password"/></div>
			<div><button type="submit" value="Enviar">Enviar</button></div>
		</form>
	</body>
</html>