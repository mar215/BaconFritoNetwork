<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="bacon.frito.modelo.Grupo" %>
    <%@page import="bacon.frito.modelo.GrupoUsuario" %>
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
<% ArrayList<Grupo> listaEntra;%>
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
<center>

<div align="center">
 	<h2>¿Quieres crear tu propio grupo?</h2> 
  <form name="form1" action="PaginaCrearGrupo.jsp">
    <input type="submit" value="Crea tu grupo">  
  </form>


  <table>
<% listaGrupo = (ArrayList<Grupo>) session.getAttribute("grupos"); 
	if (listaGrupo == null){	%>
	<tr><td>lista nula</td></tr>
 <%}else{ 
	 for(Grupo g : listaGrupo) { %>
	 	<tr><th><%= g.getId()  %></th><th><%= g.getNombre() %></th><td><th><img src ="<%= g.getImagen() %>" style="width:50px; height:50px;"> </th></td></tr>
		<tr><td colspan="2"><%= g.getDescripcion() %></td></tr>
	<%  listaEntra = (ArrayList<Grupo>) session.getAttribute("estado"); 
		boolean encontrado = false;
		for (Grupo gr:listaEntra) {
			if (g.getId() == gr.getId()) {
				encontrado=true;
			}
		}
		if (encontrado) { %>
			<td> <form action="salirGrupo" method="POST">
			<input type="hidden" name="id" value="<%=g.getId() %>">
			<input type="submit" value="salir">
			</form> </td>
			 </tr>				
			 <% 
		 }else{  %>
			 <td> <form action="entrarGrupo" method="POST">
			<input type="hidden" name="id" value="<%=g.getId() %>">
			<input type="submit" value="entrar">
			</form> </td>
			 </tr>
	
 <%		}
	}
  } %>
 
</table>
</center>
</div>
</center>
<center>





</body>
</html>