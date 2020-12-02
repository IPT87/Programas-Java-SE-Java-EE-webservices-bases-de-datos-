<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List,model.Inscripcion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<body style="font-family:verdana; background-color:powderblue;">
	<%List<Inscripcion> inscripcion = (List<Inscripcion>)request.getAttribute("candidatosInscritos"); %>
	
	<%if(inscripcion.size() == 0) { %>
		<center>
			<table border="5" bgcolor="lightblue" bordercolor="green">
			  <tr>
			    <th>Nombre</th>
			    <th>Posicion</th>
			  </tr>
			 </table>
		 </center>
	<%} else { %>
	<center>
		<table border="5" bgcolor="lightblue" bordercolor="green" cellpading="10" cellspacing="5">
		  <tr>
		    <th>Nombre</th>
		    <th>Posicion</th>
		  </tr>
		  <%for(int i = 0; i < inscripcion.size(); i++) { %>
		  <tr>
		    <td><%=inscripcion.get(i).getCandidato().getNombre() %></td>
		    <td><%=inscripcion.get(i).getPosicion() %></td>
		  </tr>
		  <%} %>
		</table>
	</center>
	<%} %>
	<br/><br/>
	<a href="menu.html">Volver</a>
</body>
</body>
</html>