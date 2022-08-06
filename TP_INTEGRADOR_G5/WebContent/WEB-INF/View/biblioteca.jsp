<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bibilioteca</title>
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
	    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="principal.html">Elmer Vasquez</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="principal.html">Inicio</a></li>
				<li class="nav-item"><a class="nav-link"
					href="lista_clientes.html">Clientes</a></li>
				<li class="nav-item"><a class="nav-link"
					href="lista_biblioteca.html">Biblioteca</a></li>
				<li class="nav-item"><a class="nav-link">Pr�stamos</a></li>
			</ul>
		</div>
	</div>
    </nav>
	
	<div style="text-align: end; margin-right: 18%;">
		<a type="button" class="btn btn-primary" style="margin-top: 50px;" href="crear_Libro.html">+
			Agregar libro</a>
	</div>
	
	<div style="text-align: end; margin-right: 5%;">
        <a type="button" class="btn btn-primary" style="margin-top: 50px;" href="crearLibro.html">+
			Agregar libro</a>
    </div>

	<form action="search_biblioteca.html" method="get">
    <div class="d-flex justify-content-end" style="margin-top: 10px;margin-right: 5%;">
      <div style="max-width: 18%;margin-right: 12px;">
          <input class="form-control" value ="${inputValue != null ? inputValue : ''} " name="inputText">
      </div>
      <div style="max-width: 13%;">
          <select class="form-select" name="propertySelect">
          <option value="default"></option>
          <option value="libro.isbn">ISBN</option>
          <option value="libro.titulo">Libro</option>
          <option value="libro.idioma">Idioma</option>
          <option value="libro.cantidadPaginas">Cantidad de Paginas</option>
          <option value="libro.autor.persona.nombre">Autor</option>
          <option value="libro.fechaLanzamiento">Fecha de alta</option>
          <option value="libro.estadoLibro">Estado</option>
          </select>
      </div>
		<div style="margin-left: 12px;">
				<button type="submit" class="btn btn-primary">Buscar</button>
		</div>
	</div>
	</form>
	
	<div class="col d-flex justify-content-center"
		style="margin-top: 20px;">
		<table class="table table-dark table-hover"
			style="text-align: center; width: 65%;">
			<thead>
				<tr class="table-dark">
					<th scope="col">ISBN</th>
					<th scope="col">Libro</th>
					<th scope="col">Idioma</th>
					<th scope="col">Cantidad de Paginas</th>
					<th scope="col">Autor</th>
					<th scope="col">Fecha de alta</th>
					<th scope="col">Estado</th>
					<th scope="col">Accion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="biblioteca" items="${bibliotecaList}">
					<c:if test="${biblioteca.libro.getEstado() == true}">
						<tr class="table-dark">
							<td class="table-dark">${biblioteca.libro.getIsbn()}</td>
							<td class="table-dark">${biblioteca.libro.getTitulo()}</td>
							<td class="table-dark">${biblioteca.libro.getIdioma()}</td>
							<td class="table-dark">
								${biblioteca.libro.getCantidadPaginas()}</td>
							<td class="table-dark">
								${biblioteca.libro.autor.persona.toString()}</td>
							<td class="table-dark">${biblioteca.getFechaAlta()}</td>
							<td class="table-dark">
								${biblioteca.libro.getEstadoLibro().getNombre()}
							</td>
							<td class="table-dark">
								<button class="button" data-bs-toggle="modal" data-bs-target="#deleteModal" 
									onClick="eliminarLibro(${biblioteca.libro.getId()})"
								>
									<i class="fas fa-trash-alt"></i>
								</button>
								<form action="detalle_libro.html" action="get">
									<input type="text" class="d-none" name="id" value="${biblioteca.libro.getId()}">
									<button type="submit" class="button">
										<i class="fas fa-search"></i>
									</button>
								</form>
								<form action="editar_Libro.html" action="get">
									<input type="text" class="d-none" name="id" value="${biblioteca.libro.getId()}">
									<button type="submit" class="button">
										<i class="fas fa-pencil-alt"></i>
									</button>
								</form>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<!-- Modal Eliminar -->
	<div class="modal fade" id="deleteModal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Eliminar
						Libro</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">�Esta seguro que desea eliminar al
					libro?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cerrar</button>
					<form action="eliminar_libro.html" method="get">
						<input type="text" class="d-none" id="eliminar" name="id" value="">
						<input type="submit" class="btn btn-primary" value="Aceptar"/>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<script>
		function eliminarLibro(id){
			const ancla = document.getElementById("eliminar");
			ancla.setAttribute("value", id);
		}
	</script>
</body>

</html>