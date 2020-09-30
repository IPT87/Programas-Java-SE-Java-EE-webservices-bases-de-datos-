<%@page import="service.LibrosFactory"%>
<%@page import="service.LibrosService"%>
<%@page import="model.Libro"%>
<%@page import="java.util.List"%>
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
<div class="container">
	<%LibrosService service = LibrosFactory.getLibrosService(); %>
	
	<%String tema = request.getParameter("valor");%>
	
	<%int size =  service.buscarPorTematica(tema).size();%>
	
		<center>
			<h1>Lista de libros por tema <%=tema%>:</h1>
			</br>
			
			<%List<Libro> libros=(List<Libro>)request.getAttribute("libros"); %>
			
			<table class="table table-striped table-bordered">
				<thead><tr><th>Titulo</th><th>ISBN</th><th>Temática</th></tr></thead>
				
				<%for(Libro l : libros){%>
					<tbody>
						<tr>
							<td><%=l.getTitulo() %></td>
							<td><%=l.getIsbn() %></td>
							<td><%=l.getTematica() %></td>
						</tr>
					</tbody>
				<%}%>
				
			</table>
			
			<a href='inicio.html'>Volver</a>
		
		</center>
</div>
</body>
</html>