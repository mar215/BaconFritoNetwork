<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
//Check para comprobar si el usuario ya tenía una sesión.

if(session.getAttribute("user")!=null){
	if (session.getAttribute("activo")!=null){
		if((Boolean)session.getAttribute("activo")!=false){
			response.sendRedirect("Principal");
		}
	}
}else{%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bacon Frito Network</title>
<link rel="stylesheet" type="text/css" href="HojaEstilosProyecto.css" >
</head>
<body style="background-color:#4DACFF">

<h1 align="center">Bienvenido a Bacon Frito Network</h1>

<form action="Login" method="POST">
<table align="center">

<tr><td><p>Usuario</p></td>
<td><input type="text" name="user"></td></tr>
<tr><td><p>Password</p></td>
<td><input type="password" name="pass"></td></tr>

<tr><td colspan="2" style="text-align: center"><input type="submit" value="Login"> <a href="PaginaRegistro.jsp">Registrarse</a></td></tr>
</table>
</form>

</body>
</html>
<%
}%>
