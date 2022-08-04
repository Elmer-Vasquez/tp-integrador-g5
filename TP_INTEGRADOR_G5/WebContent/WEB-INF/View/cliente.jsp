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
            <a class="navbar-brand" href="#">Elmer Vasquez</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">Biblioteca</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">Prestámos</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div style="text-align: end; margin-right: 5%;">
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" style="margin-top: 50px;">+ Agregar Cliente</button>
    </div>
    <form action="search_cliente.html" method="get">
    <div class="d-flex justify-content-end" style="margin-top: 10px;margin-right: 5%;">
      <div style="max-width: 18%;margin-right: 12px;">
          <input class="form-control" name="inputText">
      </div>
      <div style="max-width: 13%;">
          <select class="form-select" name="propertySelect">
          <option value="persona.dni">DNI</option>
          <option value="persona.nombre">Nombre</option>
          <option value="persona.apellido">Apellido</option>
          <option value="persona.nacionalidad">Nacionalidad</option>
          <option value="persona.sexo">Sexo</option>
          <option value="persona.fechaNac">Fecha nacimiento</option>
          <option value="localidad">Localidad</option>
          <option value="email">Correo electrónico</option>
          <option value="telefono">Telefóno</option>
          </select>
      </div>
		<div style="margin-left: 12px;">
				<button type="submit" class="btn btn-primary">Buscar</button>
		</div>
	</div>
	</form>
    <div class="col d-flex justify-content-center" style="margin-top: 20px;">
        <table class="table table-dark table-hover" style="text-align: center; width: 90%;">
            <thead>
                <tr class="table-dark">
                    <th scope="col">DNI</th>
                    <th scope="col">Nombre </th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Nacionalidad</th>
                    <th scope="col">Sexo</th>
                    <th scope="col">Fecha de nacimiento</th>
                    <th scope="col">Localidad</th>
                    <th scope="col">Correo electrónico</th>
                    <th scope="col">Telefóno</th>
                    <th scope="col">Acción</th>
                </tr>
            </thead>
            <tbody>
				<c:forEach var="cliente" items="${clientesList}">
					<tr class="table-dark">
						<td class="table-dark">${cliente.persona.getDni()}</td>
						<td class="table-dark">${cliente.persona.getNombre()}</td>
						<td class="table-dark">${cliente.persona.getApellido()}</td>
						<td class="table-dark">
							${cliente.persona.getNacionalidad().getDescripcion()}</td>
						<td class="table-dark">${cliente.persona.getSexo()}</td>
						<td class="table-dark">
							${cliente.persona.getFechaNacimiento()}</td>
						<td class="table-dark">
							${cliente.getLocalidad().getDescripcion()}</td>
						<td class="table-dark">${cliente.persona.getEmail()}</td>
						<td class="table-dark">${cliente.persona.getTelefono()}</td>
						<td class="table-dark"><i class="fas fa-trash-alt"></i> <i
							class="fas fa-search"></i> <i class="fas fa-pencil-alt"></i></td>
					</tr>
				</c:forEach>
			</tbody>
    </div>
    </div>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">Agregar cliente</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">DNI</span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Nombre</span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Apellido</span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Fecha de nacimiento</span>
                    <input type="date" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                  </div>
                  <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Nacionalidad</label>
                    <select class="form-select" id="inputGroupSelect01">
                      <option selected>Elegir...</option>
                      <option value="1">Argentina</option>
                      <option value="2">Brasil</option>
                      <option value="4">Uruguay</option>
                      <option value="5">Paraguay</option>
                      <option value="6">Chile</option>
                      <option value="7">Bolivia</option>
                      <option value="8">Peru</option>
                      <option value="9">Ecuador</option>
                    </select>
                  </div>
                  <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Localidad</label>
                    <select class="form-select" id="inputGroupSelect01">
                      <option selected>Elegir...</option>
                      <option value="1">Saavedra</option>
                      <option value="2">Olivos</option>
                      <option value="4">Munro</option>
                      <option value="5">Nuñez</option>
                      <option value="6">Pilar</option>
                      <option value="7">Juan B Justo</option>
                      <option value="8">Zarate</option>
                      <option value="9">Tortuguitasr</option>
                    </select>
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Correo electrónico</span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                  </div>
                  <div class="input-group input-group-sm mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-sm">Telefono</span>
                    <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm">
                  </div>
                  <div class="form-check mb-3">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
                    <label class="form-check-label" for="flexRadioDefault1">
                      Masculino
                    </label>
                  </div>
                  <div class="form-check mb-3">
                    <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" checked>
                    <label class="form-check-label" for="flexRadioDefault2">
                      Femenino
                    </label>
                  </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
              <button type="button" class="btn btn-primary">Guardar</button>
            </div>
          </div>
        </div>
      </div>
</body>
</html>