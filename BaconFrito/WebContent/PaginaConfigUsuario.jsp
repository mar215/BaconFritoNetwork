<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="bacon.frito.modelo.UsuarioBacon" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Configuración del perfil</title>
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
    <% if(session.getAttribute("tipoUsuario")=="premium"){ %>
    <li><a href="PaginaMensajesGrupo.jsp">Enviar mensaje a Grupo</a></li>
    <%}%>
    <li><a href="ServletPaginaConsultaMensajes">Consultar mensajes</a></li>
</ul>
</li>
<li><a href="">Configuración</a></li>
<ul>
    <li><a href="ServletConfigPerfil">Configuración Perfil</a></li>
</ul>
<li><a href="VistaGrupos">Grupos</a></li>
</ul>
</td>
<td>
<% //El buscador es un input de tipo text donde introducimos el nombre de la persona 
   //que queremos buscar en la red social. Manda el parametro:
   // busqueda-----GET%>
<form action="ServletBuscador" method="GET">
<input type="text" name="busqueda" placeholder="Buscar gente" style="width:250px">
<input type="submit" value="Buscar">
</form>
</td>
</tr>
</table>
</div>
</div>

<center>
<div id="contenido">
<% UsuarioBacon usuario = (UsuarioBacon) session.getAttribute("usuarioCambioConfig"); %>
<center>
<h2>¿Quieres tener la ventajas que todo aventurer@ necesita?</h2>
<h2>Solo tienes que hacerte premium pinchando en el siguiente enlace:</h2>
<a href="pago_premium.jsp">Hazte Premium</a>
<form action="ServletConfigPerfil" method="POST">
<table>
	<tr><th>Nick:</th><td><input type="text" name="nick" value="<%= usuario.getNick()%>">  </td></tr>
	<tr><th>Contraseña:</th><td><input type="password" name="pass">  </td></tr>
	<tr><th>Repita la contraseña:</th><td><input type="password" name="pass1">  </td></tr>
	<tr><th>Nombre:</th><td><input type="text" name="nombre" value="<%= usuario.getNombre()%>">  </td></tr>
	<tr><th>Apellidos:</th><td><input type="text" name="apellidos" value="<%= usuario.getApellidos()%>">  </td></tr>
	<tr><th>Teléfono:</th><td><input type="text" name="" value="<%= usuario.getTelefono()%>">  </td></tr>
	<tr><th>Fecha de nacimiento:<th><td><input type="date" name="bday" min="1910-01-01" value="<%= usuario.getBday()%>"><td></tr>
	<%if(usuario.getSexo()=="hombre"){ %>
	<tr><th>Sexo:<th><td><input type="radio" name="sexo" value="hombre" checked>Hombre<td></tr>
	<tr><td><input type="radio" name="sexo" value="mujer">Mujer<td></tr>
	<%}else{ %>
	<tr><th>Sexo:<th><td><input type="radio" name="sexo" value="hombre">Hombre<td></tr>
	<tr><td><input type="radio" name="sexo" value="mujer" checked>Mujer<td></tr>
	<% 
	}%>
	<tr><td colspan="2"><input type="submit" value="Guardar cambios"></td></tr>
</table>
</form>
</center>
</div>
</center>

</body>
</html>