<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="bacon.frito.modelo.UsuarioBacon" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Busqueda</title>
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

<center>
<div id="contenido">
<%! UsuarioBacon usuarioBusqueda; %>
<% usuarioBusqueda = (UsuarioBacon) session.getAttribute("usuarioBusqueda");%>
<center>
<table>
<tr><td rowspan="2"><img src=" <%= usuarioBusqueda.getFoto() %> " style="width:100px; height:100px;"></td>
<td><h3><%= usuarioBusqueda.getNick() %></h3></td>
<td>Sexo: <%=usuarioBusqueda.getSexo() %></td>
</tr>
<tr>
<td><%=usuarioBusqueda.getNombre() %>, <%=usuarioBusqueda.getApellidos() %></td>
<td>Teléfono: <%=usuarioBusqueda.getTelefono() %></td>
</tr>
</table>
</center>
</div>
</center>
<center>
		<% 
		boolean amigo;
		amigo = (Boolean) session.getAttribute("amigo"); 
		if (amigo == true) { %>
			<td> <form action="DejarSeguirAmigo" method="POST">
			<input type="hidden" name="id" value="<%=usuarioBusqueda.getNick() %>">
			<input type="submit" value="Dejar de seguir">
			</form> </td>
			 </tr>				
			 <% 
		 }else{  %>
			 <td> <form action="SeguirAmigo" method="POST">
			<input type="hidden" name="id" value="<%=usuarioBusqueda.getNick() %>">
			<input type="submit" value="Seguir">
			</form> </td>
			 </tr>
	
 <%		}  %>
</center>

</body>
</html>