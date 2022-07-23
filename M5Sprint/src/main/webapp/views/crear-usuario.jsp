<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1 class="px-5 pt-3 text-center">Crear Usuario</h1>
	<div class="container-fluid px-5 py-3">
		<div class="row">
			<div class="col col-md-8 col-lg-6 mx-auto">
				<form action="CrearUsuario" method="post">
					<div class="form-group">
						<label for="nombre">Nombre</label> <input type="text"
							class="form-control" id="nombre" name="nombre">
					</div>
					<div class="form-group">
						<label for="fechaNacimiento">Fecha de nacimiento</label> <input
							type="date" class="form-control" id="fechaNacimiento"
							name="fechaNacimiento">
					</div>
					<div class="form-group">
						<label for="run">Run</label> <input type="text"
							class="form-control" id="run" name="run">
					</div>
					<div class="form-group">
						<label for="tipoUsuario">Tipo de usuario</label> <select
							class="form-control" id="tipoUsuario" name="tipoUsuario">
							<option selected>Cliente</option>
							<option>Administrativo</option>
							<option>Profesional</option>
						</select>
					</div>
					<!-- cliente -->
					<div class="form-group client" style="display: block;">
						<label for="rut">Rut</label> <input type="text"
							class="form-control" id="rut" name="rut">
					</div>
					<div class="form-group client" style="display: block;">
						<label for="nombres">Nombres</label> <input type="text"
							class="form-control" id="nombres" name="nombres">
					</div>
					<div class="form-group client" style="display: block;">
						<label for="apellidos">Apellidos</label> <input type="text"
							class="form-control" id="apellidos" name="apellidos">
					</div>
					<div class="form-group client" style="display: block;">
						<label for="telefono">Teléfono</label> <input type="text"
							class="form-control" id="telefono" name="telefono">
					</div>
					<div class="form-group client" style="display: block;">
						<label for="afp">AFP</label> <input type="text"
							class="form-control" id="afp" name="afp">
					</div>
					<div class="form-group client" style="display: block;">
						<label for="sistemaSalud">Sistema de salud</label> <input
							type="number" class="form-control" id="sistemaSalud"
							name="sistemaSalud">
					</div>
					<div class="form-group client" style="display: block;">
						<label for="direccion">Dirección</label> <input type="text"
							class="form-control" id="direccion" name="direccion">
					</div>
					<div class="form-group client" style="display: block;">
						<label for="comuna">Comuna</label> <input type="text"
							class="form-control" id="comuna" name="comuna">
					</div>
					<div class="form-group client" style="display: block;">
						<label for="edad">Edad</label> <input type="number"
							class="form-control" id="edad" name="edad">
					</div>
					<!-- Administrativo -->
					<div class="form-group admin" style="display: none;">
						<label for="area">Área</label> <input type="text"
							class="form-control" id="area" name="area">
					</div>
					<div class="form-group admin" style="display: none;">
						<label for="experienciaPrevia">Experiencia previa</label> <input
							type="text" class="form-control" id="experienciaPrevia"
							name="experienciaPrevia">
					</div>
					<!-- Profesional -->
					<div class="form-group pro" style="display: none;">
						<label for="titulo">Título</label> <input type="text"
							class="form-control" id="titulo" name="titulo">
					</div>
					<div class="form-group pro" style="display: none;">
						<label for="fechaIngreso">Fecha de ingreso</label> <input
							type="date" class="form-control" id="fechaIngreso"
							name="fechaIngreso">
					</div>

					<button class="btn btn-primary" type="submit">Crear</button>
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
	<script>
		var select = document.getElementById("tipoUsuario");		
		var client = document.getElementsByClassName("client");
		var admin = document.getElementsByClassName("admin");
		var pro = document.getElementsByClassName("pro");
		select.addEventListener("change", function() {
			var option = this.value;
			switch (option) {
			case "Cliente":
				Array.from(client).forEach((c) => c.style.display = "block");
				Array.from(admin).forEach((a) => a.style.display = "none");
				Array.from(pro).forEach((p) => p.style.display = "none");
				break;
			case "Administrativo":
				Array.from(client).forEach((c) => c.style.display = "none");
				Array.from(admin).forEach((a) => a.style.display = "block");
				Array.from(pro).forEach((p) => p.style.display = "none");
				break;
			case "Profesional":
				Array.from(client).forEach((c) => c.style.display = "none");
				Array.from(admin).forEach((a) => a.style.display = "none");
				Array.from(pro).forEach((p) => p.style.display = "block");
				break;
			}

		});
	</script>

</body>
</html>