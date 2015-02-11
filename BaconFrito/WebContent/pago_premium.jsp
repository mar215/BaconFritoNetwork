<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pago Premium</title>
</head>
<body>
	<center>
		<div id="contenido">
			<center>
				<h1>Introduzca los datos de pago de FriedBaconBank</h1> 
				<form action="Pago" method="POST">
					<table style="text-align: center">
						<tr><th>Por favor rellene los datos de pago para convertirse en usuario premium:<th></tr>
						<tr><th>Usuario:<th></tr>
						<tr><td><input type="text" name="user" value="" ><td></tr>
						<tr><th>Contraseña:<th></tr>
						<tr><td><input type="password" name="pass"><td></tr>
						<tr><td></td></tr>						
						<tr><td><input type="submit" value="Registrarse"></td></tr>
					</table>
					<input type="hidden" name="amount" value="20" >
				</form>
			</center>
		</div>
	</center>
</body>
</html>