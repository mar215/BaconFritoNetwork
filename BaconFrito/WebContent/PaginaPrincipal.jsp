<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
<%@ page import="bacon.frito.modelo.Notificacion" %>
<%@ page import="java.util.ArrayList;" %>
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
    <li><a href="ServletPaginaUsuario"><%= session.getAttribute("user") %></a></li>
    <li><a href="Logout">Cerrar sesión</a></li>
</ul>
</li>
<li><a href="ServletPaginaConsultaMensajes">Mensajes</a>
<ul>
    <li><a href="PaginaMensajes.jsp">Enviar mensaje</a></li>
    <li><a href="ServletPaginaConsultaMensajes">Consultar mensajes</a></li>
</ul>
</li>
<li><a href="">Configuración</a></li>
<li><a href="PaginaGrupos.jsp">Grupos</a></li>
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
<table>
<%for(Notificacion n : (ArrayList<Notificacion>) session.getAttribute("notifications")){
	%>
	<tr><th><%= n.getUsuario()  %></th><th><%= n.getFecha().toString() %></th></tr>
	<tr><td colspan="2"><%= n.getTexto() %></td></tr>
<% 	
}%>
</table>
</center>
</div>
</center>

</body>
</html>