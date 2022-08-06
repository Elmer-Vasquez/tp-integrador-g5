<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalle libro</title>
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
				<li class="nav-item"><a class="nav-link">Préstamos</a></li>
			</ul>
		</div>
	</div>
    </nav>
    
     <div class="col d-flex justify-content-center" style="margin-top: 20px;">
        <table class="table table-dark table-hover" style="text-align: center; width: 65%;">
            <thead>
                <tr class="table-dark">
                    <th scope="col">ISBN</th>
                    <th scope="col">Titulo</th>
                    <th scope="col">Fecha lanzamiento</th>
                    <th scope="col">Idioma</th>
                    <th scope="col">Cantidad de paginas</th>
                    <th scope="col">Autor</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Estado libro</th>
                </tr>
            </thead>
            <tbody>
                <tr class="table-dark">
                    <td class="table-dark">${biblioteca.libro.getIsbn()}</td>
                    <td class="table-dark">${biblioteca.libro.getTitulo()}</td>
                    <td class="table-dark">${biblioteca.libro.getFechaLanzamiento()}</td>
                    <td class="table-dark">${biblioteca.libro.getIdioma()}</td>
                    <td class="table-dark">${biblioteca.libro.getCantidadPaginas()}</td>
                    <td class="table-dark">${biblioteca.libro.autor.persona.toString()}</td>
                    <td class="table-dark">${biblioteca.libro.getDescripcion()}</td>
                    <td class="table-dark">${biblioteca.libro.getEstadoLibro()}</td>
                </tr>
            </tbody>
        </table>
    </div>

</body>
</html>
