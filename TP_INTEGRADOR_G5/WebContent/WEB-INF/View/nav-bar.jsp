<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="principal.html">${sessionScope.nombreUsuario}</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="principal.html">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lista_clientes.html">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lista_biblioteca.html">Biblioteca</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lista_prestamo.html">Préstamos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="index.html">Cerrar sesión</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</body>
</html>