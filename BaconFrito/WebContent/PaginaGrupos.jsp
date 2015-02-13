<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="bacon.frito.modelo.Grupo" %>
    <%@page import="java.util.ArrayList" %>
    
       
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grupos</title>
<link rel="stylesheet" type="text/css" href="HojaEstilosProyecto.css" >
</head>
<body>

<% ArrayList<Grupo> listaGrupo;%>
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
    <li><a href="ServletPaginaUsuario">Usuario</a></li>
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
<input type="text" name="busqueda" placeholder="Buscar gente">
<input type="submit" value="Buscar">
</form>
</td>
</tr>
</table>
</div>
</div>

<center>
<div align="center">
<tr><td colspan="2">¿Quieres crear tu propio grupo? </td></tr>
  <form name="form1" action="PaginaCrearGrupo.jsp" target="_blank">
    <input type="submit" value="Crea tu grupo">  
  </form>
<% listaGrupo = (ArrayList<Grupo>) session.getAttribute("grupos"); 
	if (listaGrupo == null){	%>
	<tr><td>lista nula</td></tr>
 <%}else{ for(Grupo g : listaGrupo) { %>
	<tr><td><%= g.getNombre() %></td></tr>

	<% }} %> 

</div>
</body>
</html>