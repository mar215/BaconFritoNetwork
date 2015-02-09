<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%/*
    * Esta es la pagina que mostrara el perfil del usuario 
    */%>
    
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
    <li><a href="">Usuario</a></li>
    <li><a href="">Cerrar sesión</a></li>
</ul>
</li>
<li><a href="">Mensajes</a></li>
<li><a href="">Configuración</a></li>
<li><a>Contacto</a></li>
</ul>
</td>
<td>
<% //El buscador es un input de tipo text donde introducimos el nombre de la persona 
   //que queremos buscar en la red social. Manda el parametro:
   // busqueda-----GET%>
<form action="" method="GET">
<input type="text" name="busqueda">
</form>
</td>
</tr>
</table>
</div>
</div>

<center>
<div id="contenido">
<table>
<tr><td rowspan="2"><img alt=" imagen del usuario" src="http://images1.wikia.nocookie.net/__cb20130128232836/horadeaventura/es/images/2/2e/Jake_asombrado.png" style="width:100px; height:100px;"></td>
<td><h3>Jake 85</h3></td>
<td>Sexo: Todos los días</td>
</tr>
<tr>
<td>Jake el perro</td>
<td>Telefono: 698765432</td>
</tr>
</table>
</div>
</center>

<center>
<div id="contenido">
<table style="border:solid">
<%for(int i=0; i<15; i++){
	%>
	<tr><th>FotoUsuario</th><th>Jake 85</th></tr>
	<tr><td colspan="2">Este es el hueco para las actualizaciones que haya hecho este usuario</td></tr>
<% 	
}%>
</table>
</div>
</center>

</body>
</html>