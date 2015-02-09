<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EnviarMensaje</title>
<link rel="stylesheet" type="text/css" href="HojaEstilosProyecto.css" >
</head>
<body>

<div id="header">
<div id="imagenheader">
<img src="Imagenes\fondoheader.jpg" alt="fondo header">
</div></div>

<div id="menuNav">
<div id="tablaNav">
<table>
<tr>
<td>
<ul id="menu">
<li><a href="PaginaPrincipal.jsp">Inicio</a>
<ul>
    <li><a href="PaginaUsuario.jsp">Usuario</a></li>
    <li><a href="">Cerrar sesi�n</a></li>
</ul>
</li>
<li><a href="PaginaConsultarMensajes.jsp">Mensajes</a>
<ul>
    <li><a href="PaginaMensajes.jsp">Enviar mensaje</a></li>
    <li><a href="PaginaConsultarMensajes.jsp">Consultar mensajes</a></li>
</ul>
</li>
<li><a href="">Configuraci�n</a></li>
<li><a>Contacto</a></li>
</ul>
</td>
<td>
<% //El buscador es un input de tipo text donde introducimos el nombre de la persona 
   //que queremos buscar en la red social. Manda el parametro:
   // busqueda-----GET%>
<form action="" method="GET">
<input type="text" name="busqueda" placeholder="Buscar gente">
<input type="submit" value="Buscar">
</form>
</td>
</tr>
</table>
</div>
</div>

<center>
<div id="contenido">
<center>
<form action="" method="POST">
<table>
<tr><td><input type="hidden" name="origen" value="<%= session.getAttribute("user")%>"></td></tr>
<tr><td><input type="text" name="destino" placeholder="Destinatario" style="width: 400px"></td></tr>
<tr><td><textarea name ="mensaje" style="width:400px; height: 400px;"></textarea></td></tr>
<tr><td><input type="submit" value="enviar"></td></tr>
</table>
</form>
</center>
</div>
</center>

</body>
</html>