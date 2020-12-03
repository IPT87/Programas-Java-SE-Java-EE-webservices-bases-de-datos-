<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<h1>Página de autenticación</h1>
		<form action="security_check" method="post">
			Usuario:<input type="text" name="j_username"/><br/><br/>
			Contraseña:<input type="password" name="j_password"/><br/><br/>
			<input type="submit" value="Entrar"/>
		</form>
	
	</center>
</body>
</html>