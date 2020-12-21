<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Candidato,service.CandidatosServiceImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<style>
	table,tr,th,td {
		border:1px solid pink;
	}
</style>
</head>
<body>
<div ng-init="buscarCandidatos();" ng-app="candidatosApp" ng-controller="candidatosController">
	<table ng-show="candidatos">
	<tr>
		<th>Nombre</th>
		<th>Edad</th>
		<th>Puesto</th>
		<th>Foto</th>
		<th>Email</th>
		<th></th>
	</tr>
		
					<tr ng-repeat="can in candidatos">
						<td>{{can.nombre}}</td>
						<td>{{can.edad}}</td>	
						<td>{{can.puesto}}</td>
						<td><img alt="" height="70px" width="90px" src="{{can.foto}}"></td>
						<td>{{can.email}}</td>
						<td><input type="button" value="Eliminar" ng-click="eliminar(can.idCandidato);"></td>
					</tr>
	
	</table>
	<a href="FrontController?option=toMenu">Volver al menu</a>
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
			
			$scope.eliminar=function(idCandidato){
				$http.get(url,{params:{option:"doEliminarCandidato", idCandidato : idCandidato}})
				.then(function(res){
					$scope.buscarCandidatos();
				});
			};
			
		});

	</script>
</body>
</html>
