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
    <nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">${usuario.persona.toString()}</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lista_clientes.html">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lista_biblioteca.html">Biblioteca</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link">Prestámos</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="col d-flex justify-content-center" style="margin-top: 50px;">
        <div class="card mb-4 text-center" style="width: 50%;">
            <img src="<c:url value="/img/Biblioteca-montserrat.jpg"></c:url>" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Bienvenido!</h5>
                <p class="card-text">En este sistema te encontrarás con diferentes opciones para poder gestionar los clientes, libros y prestámos generados.</p>
                <p class="card-text"><small class="text-muted">Ultimo ingreso: 26/06/2022</small></p>
            </div>
        </div>
    </div>
</body>
</html>