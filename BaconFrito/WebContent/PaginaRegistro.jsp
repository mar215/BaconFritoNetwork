<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%/*
    *Esta página contiene un formulario que envia la siguiente informacion para dar de alta 
    *un nuevo usuario.
    * Variable ----- nombre de la variable
    * Nombre ----- nombre
    * Apellidos ----- apellidos
    * Contraseña ----- pass
    * Contraseña repetida ----- pass1
    * Nick Usuario ----- nick
    * Telefono ----- telefono
    * Sexo ----- sexo (los posibles valores son hombre,mujer)
    * La imagen de usuario que sea por defecto.
    * El ID del usuario que sea por defecto.
    * El tipo de cuenta que sea normal por defecto.
    * Tipo de envio POST
    */
    
    /*
    * El formulario rellena directamente los campos de nombre, apellidos y nick en caso de llegar
    * estos en la request (Puede pasar por un fallo al crear el usuario)
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
<h1>¡Bienvenido!</h1> 
<h3>Esta es la página de nuevos Usuarios de BaconFrito Network.<br>
    Gracias por confiar en nosotros.</h3>
<form action="" method="POST">
<table style="text-align: center">
<tr><th>Por favor rellene el siguiente formulario para realizar el registro:<th></tr>
<tr><th>Usuario:<th></tr>
<tr><td><input type="text" name="nick" <%if(request.getAttribute("nick")!=null){%> value="<%=request.getAttribute("nick")%>" <%}%>><td></tr>
<tr><th>Contraseña:<th></tr>
<tr><td><input type="password" name="pass"><td></tr>
<tr><th>Repita la contraseña:<th></tr>
<tr><td><input type="password" name="pass1"><td></tr>
<tr><th>Nombre:<th></tr>
<tr><td><input type="text" name="nombre" <%if(request.getAttribute("nombre")!=null){%> value="<%=request.getAttribute("nombre")%>" <%}%>><td></tr>
<tr><th>Apellidos:<th></tr>
<tr><td><input type="text" name="apellidos" <%if(request.getAttribute("apellidos")!=null){%> value="<%=request.getAttribute("apellidos")%>" <%}%>><td></tr>
<tr><th>Teléfono:<th></tr>
<tr><td><input type="text" name="telefono"><td></tr>
<tr><th>Sexo:<th></tr>
<tr><td><input type="radio" name="sexo" value="hombre">Hombre<td></tr>
<tr><td><input type="radio" name="sexo" value="mujer">Mujer<td></tr>
<tr><td><input type="submit" value="Registrarse"></td></tr>
</table>
</form>
</center>
</div>
</center>

</body>
</html>