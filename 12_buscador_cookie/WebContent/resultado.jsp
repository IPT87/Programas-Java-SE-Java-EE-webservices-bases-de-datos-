<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List, model.Item, java.util.Arrays" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultados</title>
</head>
<body>
<%@include file="comun.jsp" %>
	<%List<Item> items = (List<Item>)request.getAttribute("lista");
	String tema = request.getParameter("tema"); 
	for(Item item : items) {
		for(String datos : item.getSeo()) {
			if(datos.equals(tema)) {%>
				<h2><a href="<%=item.getUrl()%>"><%=item.getTitulo() %></a><br/></h2>
			<%}
		}
	}%>
	<br/><br/>
	<a href="buscador.jsp">Volver</a>
</body>
</html>