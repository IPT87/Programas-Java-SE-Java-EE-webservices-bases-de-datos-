<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, model.Candidato"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista candidatos</title>
</head>
<body style="font-family:verdana; background-color:powderblue;">
	<%List<Candidato> candidatos = (List<Candidato>)session.getAttribute("candidatos"); %>
	
	<%if(candidatos.size() == 0) { %>
		<center>
			<table border="5" bgcolor="lightblue" bordercolor="green">
			  <tr>
			    <th>Nombre</th>
			    <th>Edad</th>
			    <th>Puesto</th>
			    <th>Foto</th>
			  </tr>
			 </table>
		 </center>
	<%} else { %>
	<center>
		<table border="5" bgcolor="lightblue" bordercolor="green" cellpading="10" cellspacing="5">
		  <tr>
		    <th>Nombre</th>
		    <th>Edad</th>
		    <th>Puesto</th>
		    <th>Foto</th>
		  </tr>
		  <%for(int i = 0; i < candidatos.size(); i++) { %>
		  <tr>
		    <td><%=candidatos.get(i).getNombre() %></td>
		    <td><%=candidatos.get(i).getEdad() %></td>
		    <td><%=candidatos.get(i).getPuesto() %></td>
		    <td><img alt="" height="160px" width="270px" src="<%=candidatos.get(i).getFoto() %>"></td>
		    <td><a href="Eliminar?posicion=<%=i%>">Eliminar</a></td>
		  </tr>
		  <%} %>
		</table>
	</center>
	<%} %>
	<br/><br/>
	<a href="inicio.html">Volver</a>
</body>
</html>