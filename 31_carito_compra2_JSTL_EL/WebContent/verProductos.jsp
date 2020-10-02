<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<c:set var="productos" value="${sessionScope.producto}"/>
	
	<c:choose>
		<c:when test="${empty productos}">
			<jsp:forward page="sincarrito.jsp"/>
		</c:when>
		<c:otherwise>
				<table class="table table-striped table-bordered">
					<thead><tr><th></th><th>Producto</th><th>Precio</th><th>Categoria</th></tr></thead>
						<tbody>
						<c:forEach var="producto" items="${productos}" varStatus="status">
							<tr>
								<td><a href="Eliminar?posicion=${status.index}">Eliminar</a></td>
								<td>${producto.nombre}</td>
								<td>${producto.precio}</td>
								<td>${producto.categoria}</td>
							</tr>
							</c:forEach>
						</tbody>	
				</table>
		</c:otherwise>
	</c:choose>
			<a href="inicio.html">Volver</a>
	
</body>
</html>