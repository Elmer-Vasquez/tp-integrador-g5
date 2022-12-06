<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body style="background-color: #f5f5f5;">
	<c:set var="nombreUsuario" value="${usuario.persona.toString()}" scope="session" />
    <jsp:include page="nav-bar.jsp" />  
    <div class="col d-flex justify-content-center" style="margin-top: 50px;">
        <div class="card mb-4 text-center" style="width: 50%;">
            <img src="<c:url value="/img/Biblioteca-montserrat.jpg"></c:url>" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Bienvenido ${sessionScope.nombreUsuario}!</h5>
                <p class="card-text">En este sistema te encontrarás con diferentes opciones para poder gestionar los clientes, libros y prestámos generados.</p>
                <p class="card-text"><small class="text-muted">Ultimo ingreso: 26/06/2022</small></p>
            </div>
        </div>
    </div>
</body>
</html>