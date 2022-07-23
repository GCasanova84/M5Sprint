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
	<h1 class="px-5 pt-3 text-center">Listado de Usuarios</h1>
	<div class="container-fluid px-5 py-3">
		<div class="row">
			<div class="col col-lg-8 mx-auto">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Nombre</th>
							<th scope="col">Fecha de nacimiento</th>
							<th scope="col">Run</th>
							<th scope="col">Detalles</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${usuarios}">
							<tr>
								<td scope="row"><c:out value="${user.getNombre()}"></c:out></td>
								<td><c:out value="${user.getFechaNacimiento()}"></c:out></td>
								<td><c:out value="${user.getRun()}"></c:out></td>
								<td><a href="UsuarioDetalle?usuarioId=<c:out value="${user.getId()}"></c:out>">Ver detalles...</a></td>
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