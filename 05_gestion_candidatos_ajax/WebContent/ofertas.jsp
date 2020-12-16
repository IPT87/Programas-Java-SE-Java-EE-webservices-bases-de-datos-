<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ofertas</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
</head>
<body>
<div ng-init="buscarCandidatos();" ng-app="candidatosApp" ng-controller="candidatosController">
	<form action="FrontController?option=doAltaInscripcion" method="post" >	
		Empresa: <input type="text" name="empresa" placeholder="Introduce tu nombre" required="required"></br></br>
		Posicion: <input type="text" name="posicion" placeholder="Introduce tu edad" required="required"></br></br>
		Salario: <input type="text" name="salario" placeholder="Introduce tu puesto" required="required"></br></br>
		Candidato:<select name="idCandidato">
			
			
			<option ng-repeat="c in candidatos" value="{{c.idCandidato}}" >{{c.nombre}}</option>
			
		</select>
		<input type="submit" value="Guardar">	
	</form>
</div>

	<script>
		var app=angular.module("candidatosApp",[]);
		app.controller("candidatosController",function($scope,$http){
			var url="FrontController";
			$scope.buscarCandidatos=function(){
				$http.get(url,{params:{option:"doBuscarCandidatos"}})
				.then(function(res){
					$scope.candidatos=res.data;
				});
			};
			
		});

	</script>
</body>
</html>