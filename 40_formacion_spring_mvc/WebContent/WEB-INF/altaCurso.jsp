<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
	border: 1px solid GRAY;
	border-collapse: collapse;
}
a{
	color:LIGHTSLATEGRAY;
}
h1{
	color:DARKSALMON;
}
legend{
	color:INDIANRED;
}
</style>
<meta charset="ISO-8859-1">
<title>Registro de Cursos</title>
</head>
<body>
	<fieldset>
	<legend>Datos Curso</legend>
		<form action="doAltaCurso" method="post">
			<label for="fnombre">Nombre</label><br>
			<input type="text" name="nombre" required="required"><br>
			<label for="fduracion">Duracion</label><br>
			<input type="text" name="duracion" required="required"><br>
			<label for="ffecha">Fecha</label><br>
			<input type="date" name="fechaInicio" required="required"><br><br>
			<input type="submit" value="Guardar">
			<input type="reset">
		</form>
	</fieldset>
	<p align="right"><a href="menu">Volver</a></p>
</body>
</html>