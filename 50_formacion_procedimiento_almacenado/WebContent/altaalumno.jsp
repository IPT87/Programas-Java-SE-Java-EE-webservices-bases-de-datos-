<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
<title>Registro de Alumnos</title>
</head>
<body>
	<fieldset>
	<legend>Datos personales</legend>
	
		<form action="doAltaAlumno" method="post">
			<label for="fusuario">Usuario</label><br>
			<input type="text" name="usuario" required="required"><br>
			<label for="fpassword">Contraseña</label><br>
			<input type="password" name="password" required="required"><br>
			<label for="fnombre">Nombre</label><br>
			<input type="text" name="nombre" required="required"><br>
			<label for="femail">Email</label><br>
			<input type="text" name="email" required="required"><br>
			<label for="fedad">Edad</label><br>
			<input type="number" name="edad" required="required"><br><br>
			<input type="submit" value="Guardar">
			<input type="reset">
		</form>
	</fieldset>
	<p align="right"><a href="toMenu">Volver</a></p>
</body>
</html>