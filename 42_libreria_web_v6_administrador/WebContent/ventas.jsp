
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	
	%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>ventas</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<center>
		
		<br/><br/>
		
		 <h1>Lista de ventas</h1>   
		 
				<table border="1">
				    <tr><th>Usuario</th><th>Título libro</th><th>Fecha</th></tr>		    	
				    	<c:forEach var="venta" items="${requestScope.ventas}">
				    		<tr>
				    			<td>${venta.cliente.usuario}</td>
								<td>${venta.libro.titulo}</td>
								<td>
								<fmt:parseDate var="fecha" value="${venta.fecha}" pattern="yyyy-MM-dd'T'H:m"/>
								
								<fmt:formatDate dateStyle="long" timeStyle="short" type="both" value="${fecha}"/> 
								</td>					
							</tr>		    	
				    	</c:forEach>
				    	
				</table>
				
				
				<br/><br/>
				
				<c:forEach var="n" begin="1" end="${requestScope.totalPaginas}">
					<a href="Controller?option=doConsultarVentas&pagina=${n}">${n}</a>
					&nbsp;&nbsp;
				</c:forEach>
				
			
		<br/><br/>
	</center>
<a href="Controller?option=toAdmin">Volver</a>
</body>
</html>