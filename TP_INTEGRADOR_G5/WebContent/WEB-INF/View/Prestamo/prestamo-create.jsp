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
<title>Crear Prestamo</title>
</head>
<style>
    i {
        margin-right: 10px;
    }
</style>
<body style="background-color: #f5f5f5;">
    <jsp:include page="../nav-bar.jsp" />  
    
    <form id="goBack" action="lista_prestamo.html" method="get">
    </form>
    
    <form action="create_prestamo.html" method="post" id="createPrestamo" modelAttribute="request">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Agregar Prestamo</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="input-group input-group-sm mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Libros</label>
                    <select class="form-select" id="inputGroupSelect02" name="bibliotecaId">
                    <c:forEach var="biblioteca" items="${bibliotecaList}">
                    <option value="${biblioteca.getId()}"> ${biblioteca.getLibro().getTitulo()}</option>
                    </c:forEach>
                    </select>
                  </div>
                  <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect02">Clientes</label>
                    <select class="form-select" id="inputGroupSelect01" name="clienteId">
                    <c:forEach var="cliente" items="${clienteList}">
                    <option value="${cliente.getId()}"> ${cliente.getPersona().getNombre()}</option>
                    </c:forEach>
                    </select>
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Cantidad de dias</span>
                    <input type="number" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="cantDias" required>
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Fecha</span>
                    <input type="date" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" name="fecha" required>
                  </div>
           
            </div>
            <div class="modal-footer">
              <button type="submit" class="btn btn-secondary" form="goBack">Cancelar</button>
              <button type="submit" class="btn btn-primary" form="createPrestamo">Guardar</button>
            </div>
          </div>
        </div>
      </form>

</body>
</html>