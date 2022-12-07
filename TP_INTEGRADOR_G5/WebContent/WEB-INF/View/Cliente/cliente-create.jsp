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
<title>Crear Cliente</title>
</head>
<style>
    i {
        margin-right: 10px;
    }
</style>
<body style="background-color: #f5f5f5;">
   <jsp:include page="../nav-bar.jsp" />  
    <form id="goBack" action="lista_clientes.html" method="get">
    </form>
    
    <form action="create_cliente.html" method="post" id="createCliente" modelAttribute="request">
    <div id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Agregar cliente</h5>
            </div>
            <div class="modal-body">
                <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">DNI</span>
                    <input required type="number" min="8" max="11" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="dni">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Nombre</span>
                    <input required type="text" minlength="4" maxlength="254" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="nombre">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Apellido</span>
                    <input required type="text" minlength="4" maxlength="254" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="apellido">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Fecha de nacimiento</span>
                    <input required type="date" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="fechaNacimiento">
                  </div>
                  <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Nacionalidad</label>
                    <select class="form-select" id="inputGroupSelect01" name="nacionalidadId">
                    <c:forEach var="nacionalidad" items="${nacionalidadList}">
                    <option value="${nacionalidad.getId()}"> ${nacionalidad.getDescripcion()}</option>
                    </c:forEach>
                    </select>
                  </div>
                  <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Localidad</label>
                    <select class="form-select" id="inputGroupSelect01" name="localidadId">
                    <c:forEach var="localidad" items="${localidadList}">
                    <option value="${localidad.getId()}"> ${localidad.getDescripcion()}</option>
                    </c:forEach>  
                    </select>
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Correo electrónico</span>
                    <input required type="email" minlength="4" maxlength="254" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="email">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Telefono</span>
                    <input required type="number" min="10" max="16" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="telefono">
                  </div>
                  <select class="form-select" id="inputGroupSelect01" name="sexo">
                  <option value="Masculino">Masculino</option>
                  <option value="Femenino">Femenino</option>
                  </select>
            </div>
            <div class="modal-footer">
              <button type="submit" class="btn btn-secondary" form="goBack">Cancelar</button>
              <button type="submit" class="btn btn-primary" form="createCliente">Guardar</button>
            </div>
          </div>
        </div>
      </div>
      </form>

</body>
</html>