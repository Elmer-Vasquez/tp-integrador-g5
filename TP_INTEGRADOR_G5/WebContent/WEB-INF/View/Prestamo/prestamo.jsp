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
    <jsp:include page="nav-bar.jsp" />  
    <div style="text-align: end; margin-right: 5%;">
    <form action="create_prestamo.html" method="get">
    <button type="submit" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" style="margin-top: 50px;">+ Agregar Prestamo</button>
    </form>
    </div>


<div class="col d-flex justify-content-center" style="margin-top: 20px;">
        <table class="table table-dark table-hover" style="text-align: center; width: 90%;">
            <thead>
                <tr class="table-dark">
                    <th scope="col">Nro de prestamo</th>
                    <th scope="col">Cantidad de dias </th>
                    <th scope="col">Fecha del prestamo</th>
                   <th scope="col">Libro</th>
                    <th scope="col">Cliente</th>
                    <th scope="col">Acción</th>
                </tr>
            </thead>
            <tbody>
					<c:forEach var="prestamo" items="${prestamoList}">
					<tr class="table-dark">
						<td class="table-dark">${prestamo.getId()}</td>
						<td class="table-dark">${prestamo.getCantidadDias()}</td>
						<td class="table-dark">${prestamo.getFechaPrestamo()}</td>
						<td class="table-dark">${prestamo.biblioteca.libro.getTitulo()}</td>
						<td class="table-dark">${prestamo.cliente.persona.getNombre()}</td>
						<td class="table-dark">
						<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" style="margin-top: 50px;">Devolución</button>

						</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>
    </div>
    


</body>
</html>