<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%/*
    *Esta p�gina contiene un formulario que envia la siguiente informacion para dar de alta 
    *un nuevo usuario.
    * Variable ----- nombre de la variable
    * Nombre ----- user
    * Apellidos ----- apellidos
    * Contrase�a ----- pass
    * Contrase�a repetida ----- pass1
    * Tipo de envio POST
    */
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro</title>
<link rel="stylesheet" type="text/css" href="HojaEstilosProyecto.css" >
</head>
<body>

<center>
<div id="contenido">
<center>
<h1>�Bienvenido!</h1> 
<h3>Esta es la p�gina de nuevos Usuarios de BaconFrito Network.<br>
    Gracias por confiar en nosotros.</h3>
<form action="" method="POST">
<table style="text-align: center">
<tr><th>Por favor rellene el siguiente formulario para realizar el registro:<th></tr>
<tr><th>Nombre:<th></tr>
<tr><td><input type="text" name="user"><td></tr>
<tr><th>Apellidos:<th></tr>
<tr><td><input type="text" name="apellidos"><td></tr>
<tr><th>Contrase�a:<th></tr>
<tr><td><input type="password" name="pass"><td></tr>
<tr><th>Repita la contrase�a:<th></tr>
<tr><td><input type="password" name="pass1"><td></tr>
<tr><td><input type="submit" value="Registrarse"></td></tr>
</table>
</form>
</center>
</div>
</center>

</body>
</html>