<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="listener.MegustaListener" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contador</title>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
</head>
<body>

	<%--recuperamos la cookie de fecha --%>
	<%String fecha = "(Sin fecha anterior)";
	Cookie[] cookies = request.getCookies();
	
	if (cookies != null) {
		for (Cookie ck : cookies) {
			if(ck.getName().equals("fecha")) {
				fecha = ck.getValue();
			}
		}
	}%>

	<a href="Desconectar">Desconectar</a>
	<%int contadorActivos = (Integer) application.getAttribute("contadorActivos");%>
	<h3>Usuarios activos: <%=contadorActivos %></h3>
	<%int contador = (Integer) session.getAttribute("contador");
	int megusta = (Integer) application.getAttribute("megusta");%>
	<h2>Total de visitas a mi pagina: <%=contador %></h2>
	<h2>Total megusta: <%=megusta %></h2>
	<h2>Fecha de la ultima visita: <%=fecha %></h2>
	<br/><br/>
	
	<a href="inicio.html" class="btn btn-primary" role="button">Volver</a>
	
	<%--regeneramos la cookie de fecha --%>
	<%LocalDateTime factual = LocalDateTime.now();
	  Cookie ckfecha = new Cookie("fecha", factual.toString());
	  ckfecha.setMaxAge(100000);
	  response.addCookie(ckfecha); %>
</body>
</html>