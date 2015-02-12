<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="bacon.frito.modelo.UsuarioBacon" %>
    
    <%/*
    * Esta es la pagina que mostrara el perfil del usuario 
    * Recibe en la request un usuario del que cogeremos sus datos para mostrarlos
    */%>
    
    <% UsuarioBacon usuario = (UsuarioBacon)request.getAttribute("usuario");%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usuario</title>
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
<li><a href="PaginaConsultaMensajes.jsp">Mensajes</a>
<ul>
    <li><a href="PaginaMensajes.jsp">Enviar mensaje</a></li>
    <li><a href="PaginaConsultaMensajes.jsp">Consultar mensajes</a></li>
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
<input type="text" name="busqueda" placeholder="Buscar gente" style="width:250px">
<input type="submit" value="Buscar">
</form>
</td>
</tr>
</table>
</div>
</div>

<center>
<div id="contenidoUsuario">
<table>
<tr><td rowspan="2"><img src=" <%= usuario.getFoto() %> " style="width:100px; height:100px;"></td>
<td><h3><%= usuario.getNick() %></h3></td>
<td>Sexo: <%=usuario.getSexo() %></td>
</tr>
<tr>
<td><%=usuario.getNombre() %>, <%=usuario.getApellidos() %></td>
<td>Telefono: <%=usuario.getTelefono() %></td>
</tr>
</table>
</div>
</center>

<center>
<div id="contenido">
<center>
<table>
<%for(int i=0; i<15; i++){
	%>
	<tr><th><img alt=" imagen del usuario" src="http://images1.wikia.nocookie.net/__cb20130128232836/horadeaventura/es/images/2/2e/Jake_asombrado.png" style="width:20px; height:20px;"></th>
	<th>Jake 85</th></tr>
	<tr><td colspan="2">Este es el hueco para las actualizaciones que haya hecho este usuario.<br>
	Así parece que hay más cosas escritas y no queda tan mal.</td></tr>
<% 	
}%>
</table>
</center>
</div>
</center>

</body>
</html>