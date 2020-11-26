<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buscador</title>
</head>
<body>
	<b>${sessionScope.usuario}</b>
	<center>
		<h1>Buscador</h1>
		<form action="doBuscar" method="post">
			Introduce tema de busqueda <input type="text" name="tema"/>
			<br/><br/>
			<input type="submit" value="Buscar"/>
		</form>
	</center>
</body>
</html>