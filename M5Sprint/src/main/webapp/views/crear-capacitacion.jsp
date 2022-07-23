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
	<%@ include file="navbar.jsp" %>
	<h1 class="px-5 pt-3 text-center">Crear Capacitación</h1>
	<div class="container-fluid px-5 py-3">
		<div class="row">
			<div class="col col-md-8 col-lg-6 mx-auto">
				<form action="NuevaCapacitacion" method="post">
					<div class="form-group">
						<label for="rut">Rut del cliente</label> <input type="text"
							class="form-control" id="rut" name="rut">
					</div>
					<div class="form-group">
						<label for="dia">Día</label> <input type="text"
							class="form-control" id="dia" name="dia">
					</div>
					<div class="form-group">
						<label for="hora">Hora</label> <input type="text"
							class="form-control" id="hora" name="hora">
					</div>
					<div class="form-group">
						<label for="lugar">Lugar</label> <input type="text"
							class="form-control" id="lugar" name="lugar">
					</div>
					<div class="form-group">
						<label for="duracion">Duración</label> <input type="text"
							class="form-control" id="duracion" name="duracion">
					</div>
					<div class="form-group">
						<label for="asistentes">Cantidad de asistentes</label> <input type="number"
							class="form-control" id="asistentes" name="asistentes">
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

</body>
</html>