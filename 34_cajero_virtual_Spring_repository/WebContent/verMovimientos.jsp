<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, model.Movimiento"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ver movimientos</title>
</head>
<body>
	<%List<Movimiento> movimientos = (List<Movimiento>)request.getAttribute("movimientos"); %>
	
	<table border="5" bgcolor="lightblue" bordercolor="green" cellpading="5" cellspacing="5">
		<thead>
			<tr>
				<td>Cantidad</td>
				<td>Fecha</td>
				<td>Operacion</td>
			</tr>
		</thead>
		<%for (Movimiento movimiento : movimientos) { %>
			<tr>
				<td><%=movimiento.getCantidad() %></td>
				<td><%=movimiento.getFecha() %></td>
				<td><%=movimiento.getOperacion() %>
			</tr>
		<%} %>
	</table>
	<h3 align="right">Saldo: <%=request.getAttribute("saldo") %></h3>
</body>
</html>