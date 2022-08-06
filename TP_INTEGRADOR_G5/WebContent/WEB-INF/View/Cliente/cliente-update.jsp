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
<title>Clientes</title>
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
    
    <form id="goBack" action="lista_clientes.html" method="get">
    </form>

    <!-- MODALS -->
    <!-- CREATE_CLIENTE -->
    <form action="update_cliente.html" modelAttribute="request" method="POST">
    	<input type="hidden" value="${cliente.getId()}" name="id">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Agregar cliente</h5>
            </div>
            <div class="modal-body">
                <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">DNI</span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="${cliente.getPersona().getDni()}" name="dni">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Nombre</span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="${cliente.getPersona().getNombre()}" name="nombre">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Apellido</span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="${cliente.getPersona().getApellido()}" name="apellido">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Fecha de nacimiento</span>
                    <input type="date" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="${cliente.getPersona().getRealFechaNacimiento()}"name="fechaNacimiento">
                  </div>
                  <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Nacionalidad</label>
                    <select class="form-select" id="inputGroupSelect01" name="nacionalidadId">
                    <c:forEach var="nacionalidad" items="${nacionalidadList}">
                    <c:if test="${nacionalidad.getId() == cliente.getPersona().getNacionalidad().getId()}">
                    	<option value="${nacionalidad.getId()}" selected> ${nacionalidad.getDescripcion()}</option>
                    </c:if>
                    <option value="${nacionalidad.getId()}"> ${nacionalidad.getDescripcion()}</option>
                    </c:forEach>
                    </select>
                  </div>
                  <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Localidad</label>
                    <select class="form-select" id="inputGroupSelect01" name="localidadId">
                    <c:forEach var="localidad" items="${localidadList}">
                    <c:if test="${localidad.getId() == cliente.getLocalidad().getId()}">
                    	<option value="${localidad.getId()}" selected> ${localidad.getDescripcion()}</option>
                    </c:if>
                    <option value="${localidad.getId()}"> ${localidad.getDescripcion()}</option>
                    </c:forEach>  
                    </select>
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Correo electr�nico</span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="${cliente.getPersona().getEmail()}" name="email">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Telefono</span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" value="${cliente.getPersona().getTelefono()}" name="telefono">
                  </div>
                  <select class="form-select" id="inputGroupSelect01" name="sexo">
                  <c:if test="${cliente.getPersona().getSexo().equals('Masculino')}">
                  <option value="Masculino" selected>Masculino</option>
                  <option value="Femenino">Femenino</option>
                  </c:if>
                  <c:if test="${cliente.getPersona().getSexo().equals('Femenino')}">
                  <option value="Masculino">Masculino</option>
                  <option value="Femenino" selected>Femenino</option>
                  </c:if>
                  <c:if test="${cliente.getPersona().getSexo().isEmpty()}">
                  <option value="Masculino">Masculino</option>
                  <option value="Femenino">Femenino</option>
                  </c:if>
                  <option value="Masculino">Masculino</option>
                  <option value="Femenino">Femenino</option>
                  </select>
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