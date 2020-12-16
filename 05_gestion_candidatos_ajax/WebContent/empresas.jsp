<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
</head>
<body>
<div ng-app="inscripcionesApp" ng-controller="inscripcionesController">
		
			
			Elige Empresa:<select name="empresa" ng-model="empresa" ng-change="buscarInscripciones();">
				<%List<String> empresas=(List<String>)request.getAttribute("empresas");
				for(String empresa:empresas){%>
				<option value="<%=empresa%>"><%=empresa%></option>
				<%} %>
			</select>
			
			<br/><br/>
			<table ng-show="inscripciones">
				<tr>
					<th>Empresa</th>
					<th>Posicion</th>
					<th>Salario</th>
					<th>Empleado</th>
		
				</tr>
				<tr ng-repeat="ins in inscripciones">
					<td>{{ins.empresa}}</td>
					<td>{{ins.posicion}}</td>
					<td>{{ins.salario}}</td>
					<td>{{ins.empleado}}</td>
				</tr>
			
			</table>	
		
		<br/><br/>
		<a href="FrontController?option=toMenu">Volver al menu</a>
		
</div>
<script>
		var app=angular.module("inscripcionesApp",[]);
		app.controller("inscripcionesController",function($scope,$http){
			var url="FrontController";
			$scope.buscarInscripciones=function(){
				//$http.post(url,{fecha1:$scope.fecha1,fecha2:$scope.fecha2})
				$http.get(url,{params:{option:"doInscripcionesEmpresa",empresa:$scope.empresa}})
				.then(function(res){
					$scope.inscripciones=res.data;
				});
			};
			
		});

	</script>
</body>
</html>