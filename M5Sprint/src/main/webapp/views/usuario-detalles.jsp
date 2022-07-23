<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/assets/css/style.css"
	type="text/css">
<title>RiskPrev</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<h1 class="px-5 pt-3 text-center">Detalle de Usuario</h1>
	<a href="javascript:history.back()" style="position: absolute; right: 24px; top: 60px;">Volver</a>
	<div class="container-fluid px-5 py-3">
		<div class="row">
			<div class="col col-lg-10 mx-auto">
				<c:choose>

					<c:when test="${usuario.getClass().getSimpleName().equals('Administrativo')}">
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Nombre</th>
									<th scope="col">Fecha de nacimiento</th>
									<th scope="col">Run</th>
									<th scope="col">Área</th>
									<th scope="col">Experiencia previa</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td scope="row"><c:out value="${usuario.getNombre()}"></c:out></td>
									<td><c:out value="${usuario.getFechaNacimiento()}"></c:out></td>
									<td><c:out value="${usuario.getRun()}"></c:out></td>
									<td><c:out value="${usuario.getArea()}"></c:out></td>
									<td><c:out value="${usuario.getExperienciaPrevia()}"></c:out></td>
								</tr>
							</tbody>
						</table>
					</c:when>

					<c:when test="${usuario.getClass().getSimpleName().equals('Cliente')}">
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Nombre</th>
									<th scope="col">Fecha de nacimiento</th>
									<th scope="col">Run</th>
									<th scope="col">Rut</th>
									<th scope="col">Nombres</th>
									<th scope="col">Apellidos</th>
									<th scope="col">Teléfono</th>
									<th scope="col">AFP</th>
									<th scope="col">Sistema de salud</th>
									<th scope="col">Dirección</th>
									<th scope="col">Comuna</th>
									<th scope="col">Edad</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td scope="row"><c:out value="${usuario.getNombre()}"></c:out></td>
									<td><c:out value="${usuario.getFechaNacimiento()}"></c:out></td>
									<td><c:out value="${usuario.getRun()}"></c:out></td>
									<td><c:out value="${usuario.getRut()}"></c:out></td>
									<td><c:out value="${usuario.getNombres()}"></c:out></td>
									<td><c:out value="${usuario.getApellidos()}"></c:out></td>
									<td><c:out value="${usuario.getTelefono()}"></c:out></td>
									<td><c:out value="${usuario.getAfp()}"></c:out></td>
									<td><c:out value="${usuario.obtenerSistemaSalud()}"></c:out></td>
									<td><c:out value="${usuario.getDireccion()}"></c:out></td>
									<td><c:out value="${usuario.getComuna()}"></c:out></td>
									<td><c:out value="${usuario.getEdad()}"></c:out></td>
								</tr>
							</tbody>
						</table>
					</c:when>

					<c:otherwise>
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Nombre</th>
									<th scope="col">Fecha de nacimiento</th>
									<th scope="col">Run</th>
									<th scope="col">Título</th>
									<th scope="col">Fecha de ingreso</th>									
								</tr>
							</thead>
							<tbody>
								<tr>
									<td scope="row"><c:out value="${usuario.getNombre()}"></c:out></td>
									<td><c:out value="${usuario.getFechaNacimiento()}"></c:out></td>
									<td><c:out value="${usuario.getRun()}"></c:out></td>
									<td><c:out value="${usuario.getTitulo()}"></c:out></td>
									<td><c:out value="${usuario.getFechaIngreso()}"></c:out></td>
								</tr>
							</tbody>
						</table>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
		<div class="row">
			<div class="col col-lg-10 mx-auto">
				<a href="EditarUsuario?usuarioId=<c:out value="${usuario.getId()}"></c:out>" class="btn btn-primary d-block w-25 mx-auto mt-4">Editar <c:out value="${usuario.getClass().getSimpleName().toLowerCase()}"></c:out></a>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
		crossorigin="anonymous"></script>

</body>
</html>