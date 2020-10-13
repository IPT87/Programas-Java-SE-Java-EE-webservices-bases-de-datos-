<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>

	<fmt:setBundle basename="resources.descripciones"/>
	<div class="container">
	
	<h2><a href="Controller?option=doIdioma&idioma=en">Ingles</a></h2>
	<h2><a href="Controller?option=doIdioma&idioma=es">Español</a></h2>
	
	<h1><fmt:message key="login.principal"/></h1>
		<form action="Controller?option=doLogin" method="post">		
			
			<div class="form-group">
				<label><fmt:message key="login.usuario"/></label><input type="text" name="user" class="form-control" style="width:30%" placeholder="<fmt:message key='login.usuario'/>"/>
			</div>
			<div class="form-group">
				<label><fmt:message key="login.pwd"/></label><input type="password" name="pwd" class="form-control" style="width:30%" placeholder="<fmt:message key='login.pwd'/>"/>
			</div>
			<button type="submit" class="btn btn-default"><fmt:message key="login.entrar"/></button>
		</form>
		<br/>
		<a href="Controller?option=toRegistro"><fmt:message key="login.registro"/></a>
	</div>
</body>
</html>