<%@page import="model.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<title>Insert title here</title>
</head>
<body>
	<%List<Producto> productos = (List<Producto>) session.getAttribute("producto"); %>
	
	<table class="table table-striped table-bordered">
				<thead><tr><th></th><th>Producto</th><th>Precio</th><th>Categoria</th></tr></thead>
				
				<%for(int i = 0; i < productos.size(); i++){%>
					<tbody>
						<tr>
							<td><a href="Eliminar?posicion=<%=i%>">Eliminar</a></td>
							<td><%=productos.get(i).getNombre() %></td>
							<td><%=productos.get(i).getPrecio() %></td>
							<td><%=productos.get(i).getCategoria() %></td>
						</tr>
					</tbody>
				<%} %>
				
			</table>
			
			<a href="inicio.html">Volver</a>
	
</body>
</html>