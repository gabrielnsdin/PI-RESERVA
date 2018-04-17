<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Title</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<c:import url="Menu.jsp" />
	<div id="main" class="container">
		<div class="row">
			<div class="form-group col-md-9">
				<br>
				<h1>Lista de Sub Serviços</h1>
				<br> <br>
				<div class="table-responsive">
					<table class="table table-bordered table-inverse">
						<thead>
						<tr>
							<th>Nome</th>
							<th>Sigla</th>
							<th>Ordem</th>
							<th>Servico - Sigla</th>
						</tr>
					</thead>
					<c:forEach var="subServico" items="${subServicos}">
						<tbody>
							<tr>
								<td>${subServico.nome}</td>
								<td>${subServico.sigla}</td>
								<td>${subServico.ordem}</td>
								<td>${subServico.servico.nome} - ${subServico.servico.sigla}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>