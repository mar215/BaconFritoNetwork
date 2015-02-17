<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
//Check para comprobar si el usuario ya tenía una sesión.

if(session.getAttribute("user")!=null){
	if (session.getAttribute("activo")!=null){
		if((Boolean)session.getAttribute("activo")!=false){
			response.sendRedirect("PaginaPrincipal.jsp");
		}
	}
}else{%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bacon Frito Network</title>
<link rel="stylesheet" type="text/css" href="HojaEstilosProyecto.css" >
</head><br>
<center>
<img align="center" width="700" height="200"  src="http://3.bp.blogspot.com/-IwJpf-uFsIs/U2Ut_cMTnWI/AAAAAAAAa2c/1WucDM7oviY/s1600/10.gif">
</center>


<br><br><br>
<br><br><br>
<br>

<form action="Login" method="POST">
<table align="center" width="200" cellspacing="1" cellpadding="3" border="0" bgcolor="#FFFF00">

<tr><td><p>Usuario</p></td>
<td><input type="text" name="user"></td></tr>
<tr><td><p>Password</p></td>
<td><input type="password" name="pass"></td></tr>

<tr><td colspan="2" style="text-align: center"><input type="submit" value="Login"> <a href="PaginaRegistro.jsp">Registrarse</a></td></tr>
</table>
</form>
<center>
<br><br><br>
<br><br><br>
<br><br><br>
<br><br><br>
<h5>Página creada por:<br><br>-Julián Martínez<br>-Mario Sánchez<br>-Francisco Quero </h5>

<h5>Nos guardamos los derechos reservados©  de la página...<br> </h5>
<h5>excepto si nos denuncian. </h5>
</iframe>
</center>
</body>
</html>
<%
}%>
