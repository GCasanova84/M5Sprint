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
	<h1 class="px-5 pt-3 text-center">Listar Capacitaciones</h1>
	<div class="container-fluid px-5 py-3">
		<div class="row">
			<div class="col col-lg-8 mx-auto">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Rut del cliente</th>
							<th scope="col">Día</th>
							<th scope="col">Hora</th>
							<th scope="col">Lugar</th>
							<th scope="col">Duración</th>
							<th scope="col">N° de asistentes</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="cap" items="${capacitaciones}">
							<tr>
								<td scope="row"><c:out value="${cap.getIdentificador()}"></c:out></td>
								<td><c:out value="${cap.getRutCliente()}"></c:out></td>
								<td><c:out value="${cap.getDia()}"></c:out></td>
								<td><c:out value="${cap.getHora()}"></c:out> hrs.</td>
								<td><c:out value="${cap.getLugar()}"></c:out></td>
								<td><c:out value="${cap.getDuracion()}"></c:out> min.</td>
								<td><c:out value="${cap.getCantidadAsistentes()}"></c:out></td>
							</tr>
						</c:forEach>
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