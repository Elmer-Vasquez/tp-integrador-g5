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
<title>Prestamos</title>
</head>
<style>
    i {
        margin-right: 10px;
    }
</style>
<body style="background-color: #f5f5f5;">
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Elmer Vasquez</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="">Inicio</a></li>
				<li class="nav-item"><a class="nav-link"
					href="lista_clientes.html">Clientes</a></li>
				<li class="nav-item"><a class="nav-link"
					href="lista_biblioteca.html">Biblioteca</a></li>
				<li class="nav-item" ><a class="nav-link">Pr�stamos</a></li>
			</ul>
		</div>
	</div>
    </nav>
    <div style="text-align: end; margin-right: 5%;">
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" style="margin-top: 50px;">+ Agregar Prestamo</button>
    </div>


	<div class="col d-flex justify-content-center" style="margin-top: 20px;">
        <table class="table table-dark table-hover" style="text-align: center; width: 90%;">
            <thead>
                <tr class="table-dark">
                    <th scope="col">ID</th>
                    <th scope="col">Cantidad de dias </th>
                    <th scope="col">fecha del prestamo</th>
                   <th scope="col">id biblioteca</th>
                    <th scope="col">id cliente</th>
                    <th scope="col">Acci�n</th>
                </tr>
            </thead>
            <tbody>
					<c:forEach var="prestamo" items="${prestamoList}">
					<tr class="table-dark">
						<td class="table-dark">${prestamo.getid()}</td>
						<td class="table-dark">${prestamo.getCantidadDias()}</td>
						<td class="table-dark">${prestamo.getFechaPrestamo()}</td>
						<td class="table-dark">
							${prestamo.biblioteca.getid()}</td>
						<td class="table-dark">${prestamo.cliente.getid()}</td>
						<td class="table-dark">
						<button class="btn" style="color: currentColor;" data-bs-toggle="modal" data-bs-target="#deleteModal"><i class="fas fa-trash-alt"></i></button>
						<i class="fas fa-search"></i>
						<i class="fas fa-pencil-alt"></i>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
    </div>
    


</body>
</html>