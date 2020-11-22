<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, model.Cliente"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FrontController?option=doVerCuentas" method="post" >	
		Seleccione cliente<br/>
		<select name="cliente">
			<%List<Cliente> clientes=(List<Cliente>)request.getAttribute("clientes");
			for(Cliente cliente : clientes){%>
			<option value="<%=cliente.getDni() %>"><%=cliente.getNombre() %></option>
			<%} %>
		</select>
		<br/><br/>
		<p align="center"><input type="submit" value="Siguente"></p>
	</form>
	<p align="right"><a href="FrontController?option=toInicio">Volver al menu</a></p>
</body>
</html>