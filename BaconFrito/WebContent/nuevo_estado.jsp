<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="HojaEstilosProyecto.css" >
		<%
			//Check para comprobar si el usuario ya ten�a una sesi�n.

			if(session.getAttribute("user") == null){
				if (session.getAttribute("activo") ==  null){
					if((Boolean) session.getAttribute("activo") == false){
						response.sendRedirect("Bienvenida.jsp");
					}
				}
			}else{
		%>
		<title>Nuevo Estado</title>
	</head>
	<body>
		<div id="header">
			<div id="imagenheader">
				<img src="Imagenes\fondoheader.jpg" alt="fondo header">
			</div>
		</div>

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
								<li><a href="Logout">Cerrar sesi�n</a></li>
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
						<li><a href="">Configuraci�n</a>
							<ul>
								<li><a href="ServletConfigPerfil">Configuraci�n Perfil</a></li>
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
				<center>
					<form action="NuevoEstado" method="POST">
						<table>
							<tr><td><input type="hidden" name="usuario" value="<%= session.getAttribute("user") %>"></td></tr>
							<tr><td><textarea name ="texto" style="width:400px; height: 400px;"></textarea></td></tr>
							<tr><td><input type="submit" value="publicar"></td></tr>
						</table>
					</form>
				</center>
			</div>
		</center>

	</body>
</html>
<% } %>