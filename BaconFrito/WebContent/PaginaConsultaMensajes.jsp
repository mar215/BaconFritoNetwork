<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="java.util.Iterator" %>
	<%@page import="bacon.frito.modelo.Mensaje" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entrada mensajes</title>
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
						<li><a href="ServletPaginaPrincipal">Inicio</a>
							<ul>
								<li><a href="ServletPaginaUsuario"><%= (String)session.getAttribute("user") %></a></li>
								<li><a href="nuevo_estado.jsp"> Compartir notificacion </a></li>
								<li><a href="Logout">Cerrar sesión</a></li>
							</ul>
						</li>
						<li><a href="ServletPaginaConsultaMensajes">Mensajes</a>
							<ul>
								<li><a href="PaginaMensajes.jsp">Enviar mensaje</a></li>
								<% if(((String)session.getAttribute("tipoUsuario")).toLowerCase().equals("usuariopremium")){ %>
									<li><a href="PaginaMensajesGrupo.jsp">Enviar mensaje a Grupo</a></li>
								<%}%>
								<li><a href="ServletPaginaConsultaMensajes">Consultar mensajes</a></li>
							</ul>
						</li>
						<li><a href="">Configuración</a>
							<ul>
								<li><a href="ServletConfigPerfil">Configuración Perfil</a></li>
							</ul>
						</li>
						<li><a href="VistaGrupos">Grupos</a></li>
					</ul>
				</td>
				<td>
					<% //El buscador es un input de tipo text donde introducimos el nombre de la persona 
						//que queremos buscar en la red social. Manda el parametro:
						//busqueda-----GET%>
					<form action="ServletBuscador" method="GET">
						<input type="text" name="busqueda" placeholder="Buscar gente" style="width:250px">
						<input type="submit" value="Buscar">
					</form>
				</td>
			</tr>
		</table>
	</div>
</div>

<% 	ArrayList<Mensaje> listaMensajes = (ArrayList<Mensaje>) request.getAttribute("listaMensajes"); %>
<% if(listaMensajes!=null){ %>
<center>
<div id="contenido">
<center>
<table>
<tr> <th>Leido</th> <th>Origen</th> <th></th> </tr>
<%	Iterator<Mensaje> it = listaMensajes.iterator();
	while(it.hasNext()){
		Mensaje mensajeAux = it.next();
	%>
		<tr> <td>Igual si</td> <td><%=mensajeAux.getOrigen() %></td> 
		<td> <form action="ServletVerMensaje" method="POST">
		<input type="hidden" name="id" value="<%=mensajeAux.getId() %>">
		<input type="hidden" name="destino" value="<%=mensajeAux.getDestino() %>">
		<input type="hidden" name="origen" value="<%=mensajeAux.getOrigen() %>">
		<input type="hidden" name="texto" value="<%=mensajeAux.getTexto() %>">
		<input type="submit" value="Ver">
		</form> </td>
		 </tr>
<%	
}%>
</table>
</center>
</div>
</center>

<%
}else{%>

<center>
<div id="contenido">
<center>
<table>
<tr> <th>Leido</th> <th>Origen</th> </tr>
<tr> <td colspan="2"> No se encontraron mensajes </td> </tr>
</table>
</center>
</div>
</center>

<%
}%>
</body>
</html>