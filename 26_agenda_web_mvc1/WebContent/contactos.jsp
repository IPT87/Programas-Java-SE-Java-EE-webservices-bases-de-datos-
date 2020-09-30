<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, model.Contacto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contactos</title>
</head>
<body>
<%List<Contacto> contactos = (List<Contacto>) request.getAttribute("contactos"); %>
	<h1>Listado de contactos</h1>
	<table border="1">
		<tr><th>Nombre</th><th>Email</th><th>Edad</th></tr>
		<%for(Contacto contacto : contactos) { %>
			<tr>
				<td><%=contacto.getNombre() %>
				<td><%=contacto.getEmail() %>
				<td><%=contacto.getEdad() %>
			</tr>
		<%}%>
	</table>
	</br>
	<a href="Controler?option=toSalir">Volver</a>
</body>
</html>