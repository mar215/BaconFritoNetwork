<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Cliente</title>
<%
	if(session.isNew() == true 
	|| session.getAttribute("valida") == null 
	|| ((Boolean) session.getAttribute("valida")) != true){
%>
</head>
<body>
	<center>
		<div id="contenido">
			<center>
				<h1>Introduzca los datos de nuevo cliente</h1> 
				<form action="Nuevo" method="POST">
					<table style="text-align: center">
						<tr><th>Por favor rellene el siguiente formulario para realizar el registro:<th></tr>
						<tr><th>Usuario:<th></tr>
						<tr><td><input type="text" name="user" value="" ><td></tr>
						<tr><th>Contraseña:<th></tr>
						<tr><td><input type="password" name="pass"><td></tr>
						<tr><th>Nombre:<th></tr>
						<tr><td><input type="text" name="nombre" value="" ><td></tr>
						<tr><th>Apellidos:<th></tr>
						<tr><td><input type="text" name="apellidos" value="" ><td></tr>
						<tr><th>DNI:<th></tr>
						<tr><td><input type="text" name="dni" value="" ><td></tr>
						<tr><th>Saldo Inicial:<th></tr>
						<tr><td><input type="text" name="saldo"><td></tr>
						<tr><td><input type="submit" value="Registrarse"></td></tr>
					</table>
				</form>
			</center>
		</div>
	</center>
</body>
</html>
<%
	}else{
		response.sendRedirect("User");
	} 
%>