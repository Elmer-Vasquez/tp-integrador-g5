<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear libro</title>
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
</head>
<style>
i {
	margin-right: 10px;
}
</style>

<body style="background-color: #f5f5f5;">
	    <jsp:include page="../nav-bar.jsp" />  
	<div class="px-5 mx-5">
		<div class="modal-header">
			<h5 class="modal-title" id="exampleModalLabel">Agregar libro</h5>
		</div>
		<form action="agregar_libro.html" method="get">
			<div id="agregarGenero" class="modal-body">
				<div class="input-group input-group-sm mb-3">
					<span class="input-group-text" id="inputGroup-sizing-sm">ISBN</span>
					<input type="number" class="form-control"
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm"
						name="isbn" required>
				</div>
				<div class="input-group input-group-sm mb-3">
					<span class="input-group-text" id="inputGroup-sizing-sm">Titulo</span>
					<input type="text" class="form-control"
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm"
						name="titulo" required>
				</div>
				<div class="input-group input-group-sm mb-3">
					<span class="input-group-text" id="inputGroup-sizing-sm">Fecha
						de lanzamiento</span> <input type="date" class="form-control"
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm"
						name="fechaLanzamiento" required>
				</div>
				<div class="input-group input-group-sm mb-3">
					<span class="input-group-text" id="inputGroup-sizing-sm">Idioma</span>
					<input type="text" class="form-control"
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm"
						name="idioma" required>
				</div>
				<div class="input-group input-group-sm mb-3">
					<span class="input-group-text" id="inputGroup-sizing-sm">Cantidad
						de paginas</span> <input type="number" class="form-control"
						aria-label="Sizing example input"
						aria-describedby="inputGroup-sizing-sm"
						name="cantidadPaginas" required>
				</div>
				<div class="input-group mb-3">
					<label class="input-group-text" for="inputGroupSelect01">Autor</label>
					<select class="form-select" id="inputGroupSelect01" name="autor">
						<option selected>Elegir...</option>
						<c:forEach var="autor" items="${autor}">
							<option value="${ autor.getId() }">${ autor.persona.getNombre() }</option>
						</c:forEach>
					</select>
				</div>
				<div id="generos" class="input-group mb-3">
					<label class="input-group-text" for="inputGroupSelect01">Generos</label>
					<select class="form-select" id="inputGroupSelect01" name="genero">
						<option selected>Elegir...</option>
						<c:forEach var="genero" items="${genero}">
							<option value="${ genero.getId() }">${ genero.getDescripcion() }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary"
					onclick="agregarGenero()">Agregar genero</button>
				<input  type="submit" class="btn btn-success" value="Guardar" />
			</div>
		</form>
	</div>
	<script>
		function agregarGenero() {
			const generos = document.getElementById('generos').outerHTML;
			const form = document.getElementById('agregarGenero');
			form.insertAdjacentHTML("beforeend", generos);
		}
	</script>
</body>
</html>
