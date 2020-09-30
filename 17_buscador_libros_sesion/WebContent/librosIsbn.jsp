<%@page import="service.LibrosFactory"%>
<%@page import="service.LibrosService"%>
<%@page import="model.Libro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
	<%String usuario = (String) session.getAttribute("usuario");%>

	<h4>Hola, <%=usuario %></h4>

	<%LibrosService service = LibrosFactory.getLibrosService(); %>
	
	<%Libro libro = service.buscarLibro(Integer.parseInt(request.getParameter("valor"))); %>
	
	<center>

	<table class="table table-striped table-bordered">
				<thead><tr><th>Titulo</th><th>ISBN</th><th>Temática</th></tr></thead>
				
					<tbody>
						<tr>
							<td><%=libro.getTitulo() %></td>
							<td><%=libro.getIsbn() %></td>
							<td><%=libro.getTematica() %></td>
						</tr>
					</tbody>
			
			</table>
	
	</br>
	
	<a href='eleccion.jsp'>Volver</a>
	</center>
</body>
</html>