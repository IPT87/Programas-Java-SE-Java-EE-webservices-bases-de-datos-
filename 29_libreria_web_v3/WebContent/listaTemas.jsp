<%@page import="service.TemaServiceFactory"%>
<%@page import="service.TemaService"%>
<%@page import="java.util.List"%>
<%@page import="model.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%TemaService temaService = TemaServiceFactory.getTemaService();
	List<Libro> listaLibros = temaService.getLibros(request.getParameter("temaElegido")); %>

	<h3 style="text-align:right"><%=session.getAttribute("nombreUsuario") %></h3>

	<center>
	<h3>Libros del tema: <%=request.getParameter("temaElegido") %></h3>
	<br>
	<table border='1'>
	<thead><tr><th>Titulo</th><th>Autor</th><th>ISBN</th></tr></thead>
				
				<%for(Libro l : listaLibros){%>
					<tbody>
						<tr>
							<td><%=l.getTitulo() %></td>
							<td><%=l.getAutor() %></td>
							<td><%=l.getIsbn() %></td>
						</tr>
					</tbody>
				<%}%>
		</table>
		<br>
		<a href="Controler?option=toTemas">Volver</a>
	</center>
</body>
</html>