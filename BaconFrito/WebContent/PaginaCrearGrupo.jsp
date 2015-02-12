<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear pagina</title>
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
<div id="contenido">
<center>
<h1>Crea tu grupo</h1> 

<form action="RegistroGrupo" method="POST">
<table style="text-align: center">
<tr><th>Nombre:<th></tr>
<tr><td><input type="text" name="nombre" <%if(request.getParameter("nombre")!=null){%> value="<%=request.getAttribute("nombre")%>" <%}%>><td></tr>
<tr><th>Descripcion:<th></tr>
<tr><td><textarea name="descripcion" rows="10" cols="40" <%if(request.getParameter("descripcion")!=null){%> value="<%=request.getAttribute("descripcion")%>" <%}%>></textarea><td></tr>
<tr><th>Imagen:<th></tr>
<tr><td><input type="text" name="imagen" <%if(request.getParameter("imagen")!=null){%> value="<%=request.getAttribute("imagen")%>" <%}%>><td></tr>
<tr><th>Maximo integrantes:<th></tr>
<tr><td><input type="text" name="maximos integrantes" <%if(request.getParameter("maximos integrantes")!=null){%> value="<%=request.getAttribute("maximos integrantes")%>" <%}%>><td></tr>

<tr><td><input type="submit" value="Crear grupo"></td></tr>
</table>
</form>
</center>
</div>
</center>
</body>
</html>