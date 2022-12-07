<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<title>Biblioteca</title>
</head>
<style>
i {
	margin-right: 10px;
}
</style>
<body style="background-color: #f5f5f5;">
	<jsp:include page="../nav-bar.jsp" />

	<form id="goBack" action="lista_biblioteca.html" method="get"></form>

	<!-- MODALS -->
	<!-- CREATE_CLIENTE -->
	<form action="update_cliente.html" modelAttribute="request"
		method="POST">
		<input type="hidden" value="${biblioteca.getId()}" name="id">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Editar libro</h5>
				</div>
				<div class="modal-body">
					<div class="input-group input-group-sm mb-3">
						<span class="input-group-text" id="inputGroup-sizing-sm">ISBN</span>
						<input value="${biblioteca.getLibro().getIsbn()}" type="text" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-sm" name="isbn">
					</div>
					<div class="input-group input-group-sm mb-3">
						<span class="input-group-text" id="inputGroup-sizing-sm">Titulo</span>
						<input value="${biblioteca.getLibro().getTitulo()}" type="text" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-sm" name="titulo">
					</div>
					<div class="input-group input-group-sm mb-3">
						<span class="input-group-text" id="inputGroup-sizing-sm">Fecha
							de lanzamiento</span>
							<input value="${biblioteca.getLibro().getFechaLanzamiento()}" type="date" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-sm" name="fechaLanzamiento">
					</div>
					<div class="input-group input-group-sm mb-3">
						<span class="input-group-text" id="inputGroup-sizing-sm">Idioma</span>
						<input value="${biblioteca.getLibro().getIdioma()}" type="text" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-sm" name="idioma">
					</div>
					<div class="input-group input-group-sm mb-3">
						<span class="input-group-text" id="inputGroup-sizing-sm">Cantidad
							de paginas</span>
							<input value="${biblioteca.getLibro().getCantidadPaginas()}" type="text" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-sm" name="cantidadPaginas">
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text" for="inputGroupSelect01">Autor</label>
						<select class="form-select" id="inputGroupSelect01" name="autor">
							<option selected="true" disabled="disabled"
								value="${biblioteca.getLibro().getAutor().getPersona().getId()}">
								${biblioteca.getLibro().getAutor().getPersona().toString()}
							</option>
							<c:forEach var="autor" items="${autorList}">
								<option value="${autor.getId()}">
									${autor.getPersona().toString()}</option>
							</c:forEach>
						</select>
					</div>
					<div class="input-group input-group-sm mb-3">
						<span class="input-group-text" id="inputGroup-sizing-sm">Descripcion</span>
						<input
							value="${biblioteca.getLibro().getDescripcion()}"
							type="text" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-sm" name="descripcion">
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text" for="inputGroupSelect01">Generos</label>
						<select class="form-select" id="inputGroupSelect01" name="generos">
							<option selected="true" disabled="disabled"
								value="${biblioteca.getLibro().getGeneros()}">
								${biblioteca.getLibro().getGeneros()}
							</option>
							<c:forEach var="genero" items="${generoList}">
								<option value="${genero.getId()}">
									${genero.getDescripcion()}</option>
							</c:forEach>
						</select>
					</div>
					<div class="input-group mb-3">
						<label class="input-group-text" for="inputGroupSelect01">Estado</label>
						<select class="form-select" id="inputGroupSelect01" name="generos">
							<option selected="true" value="0">En biblioteca</option>
							<option value="1">Prestado</option>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-secondary" form="goBack">Cancelar</button>
					<button type="submit" class="btn btn-primary">Guardar</button>
				</div>
			</div>
		</div>
	</form>

</body>
</html>