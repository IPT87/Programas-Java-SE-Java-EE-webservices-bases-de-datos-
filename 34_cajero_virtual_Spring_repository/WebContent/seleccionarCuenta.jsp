<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, model.Cuenta"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FrontController?option=doAsignarCuenta" method="post" >	
		Seleccione cuenta<br/>
		<select name="cuenta">
			<%List<Cuenta> cuentas=(List<Cuenta>)request.getAttribute("cuentas");
			for(Cuenta cuenta : cuentas){%>
			<option value="<%=cuenta.getNumeroCuenta() %>"><%=cuenta.getNumeroCuenta() %></option>
			<%} %>
		</select>
		<br/><br/>
		<p align="center"><input type="submit" value="Asignar"></p>
	</form>
	<p align="right"><a href="FrontController?option=toInicio">Volver al menu</a></p>
</body>
</html>