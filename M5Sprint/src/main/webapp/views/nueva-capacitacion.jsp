<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cl.M5ABPro1.model.events.Capacitacion" %> 
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
	<h1 class="px-5 pt-3 text-center">Nueva Capacitación</h1>
	<h4 class="my-4 text-center">La nueva capacitación se ha creado de manera exitosa</h4>
	<div class="container-fluid px-5 py-3">
		<div class="row">
			<div class="col col-lg-8 mx-auto">
				<table class="table">
					<%
					Capacitacion cap = (Capacitacion) request.getAttribute("capacitacion");
					%>
					<thead class="thead-dark">
						<tr>
							<th scope="col">Identificador</th>
							<th scope="col">Rut del cliente</th>
							<th scope="col">Día</th>
							<th scope="col">Hora</th>
							<th scope="col">Lugar</th>
							<th scope="col">Duración</th>
							<th scope="col">Número de asistentes</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td scope="row"><%=cap.getIdentificador()%></td>
							<td><%=cap.getRutCliente()%></td>
							<td><%=cap.getDia()%></td>
							<td><%=cap.getHora()%> hrs.</td>
							<td><%=cap.getLugar()%></td>
							<td><%=cap.getDuracion()%> min.</td>
							<td><%=cap.getCantidadAsistentes()%></td>
						</tr>
					</tbody>
				</table>
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