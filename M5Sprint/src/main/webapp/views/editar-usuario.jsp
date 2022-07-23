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
	<h1 class="px-5 pt-3 text-center">
		Editar
		<c:out value="${usuario.getClass().getSimpleName()}"></c:out>
	</h1>
	<div class="container-fluid px-5 py-3">
		<div class="row">
			<div class="col col-md-8 col-lg-6 mx-auto">
				<form action="EditarUsuario" method="post">
					<div class="form-group d-none">
						<input type="text" class="form-control" id="usuarioId"
							name="usuarioId" value="${usuario.getId()}">
					</div>
					<div class="form-group">
						<label for="nombre">Nombre</label> <input type="text"
							class="form-control" id="nombre" name="nombre"
							value="${usuario.getNombre()}">
					</div>
					<div class="form-group">
						<label for="fechaNacimiento">Fecha de nacimiento</label> <input
							type="date" class="form-control" id="fechaNacimiento"
							name="fechaNacimiento" value="${usuario.getFechaNacimiento()}">
					</div>
					<div class="form-group">
						<label for="run">Run</label> <input type="text"
							class="form-control" id="run" name="run"
							value="${usuario.getRun()}">
					</div>
					<div class="form-group d-none">
						<input type="text" class="form-control" id="tipoUsuario"
							name="tipoUsuario" value="${usuario.getClass().getSimpleName()}">
					</div>

					<c:choose>

						<c:when
							test="${usuario.getClass().getSimpleName().equals('Cliente')}">
							<!-- cliente -->
							<div class="form-group">
								<label for="rut">Rut</label> <input type="text"
									class="form-control" id="rut" name="rut"
									value="${usuario.getRut()}">
							</div>
							<div class="form-group">
								<label for="nombres">Nombres</label> <input type="text"
									class="form-control" id="nombres" name="nombres"
									value="${usuario.getNombres()}">
							</div>
							<div class="form-group">
								<label for="apellidos">Apellidos</label> <input type="text"
									class="form-control" id="apellidos" name="apellidos"
									value="${usuario.getApellidos()}">
							</div>
							<div class="form-group">
								<label for="telefono">Teléfono</label> <input type="text"
									class="form-control" id="telefono" name="telefono"
									value="${usuario.getTelefono()}">
							</div>
							<div class="form-group" style="display: block;">
								<label for="afp">AFP</label> <input type="text"
									class="form-control" id="afp" name="afp"
									value="${usuario.getAfp()}">
							</div>
							<div class="form-group">
								<label for="sistemaSalud">Sistema de salud</label> <input
									type="number" class="form-control" id="sistemaSalud"
									name="sistemaSalud" value="${usuario.getSistemaSalud()}">
							</div>
							<div class="form-group">
								<label for="direccion">Dirección</label> <input type="text"
									class="form-control" id="direccion" name="direccion"
									value="${usuario.getDireccion()}">
							</div>
							<div class="form-group">
								<label for="comuna">Comuna</label> <input type="text"
									class="form-control" id="comuna" name="comuna"
									value="${usuario.getComuna()}">
							</div>
							<div class="form-group">
								<label for="edad">Edad</label> <input type="number"
									class="form-control" id="edad" name="edad"
									value="${usuario.getEdad()}">
							</div>

						</c:when>

						<c:when
							test="${usuario.getClass().getSimpleName().equals('Administrativo')}">
							<!-- Administrativo -->
							<div class="form-group">
								<label for="area">Área</label> <input type="text"
									class="form-control" id="area" name="area"
									value="${usuario.getArea()}">
							</div>
							<div class="form-group">
								<label for="experienciaPrevia">Experiencia previa</label> <input
									type="text" class="form-control" id="experienciaPrevia"
									name="experienciaPrevia"
									value="${usuario.getExperienciaPrevia()}">
							</div>

						</c:when>

						<c:when
							test="${usuario.getClass().getSimpleName().equals('Profesional')}">
							<!-- Profesional -->
							<div class="form-group">
								<label for="titulo">Título</label> <input type="text"
									class="form-control" id="titulo" name="titulo"
									value="${usuario.getTitulo()}">
							</div>
							<div class="form-group">
								<label for="fechaIngreso">Fecha de ingreso</label> <input
									type="date" class="form-control" id="fechaIngreso"
									name="fechaIngreso" value="${usuario.getFechaIngreso()}">
							</div>

						</c:when>

					</c:choose>

					<button class="btn btn-primary" type="submit">
						Guardar
						<c:out value="${usuario.getClass().getSimpleName().toLowerCase()}"></c:out>
					</button>
				</form>
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