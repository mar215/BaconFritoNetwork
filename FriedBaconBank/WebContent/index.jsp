<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FriedBaconBank</title>
</head>
<%
	if(session.isNew() == true 
	|| session.getAttribute("valida") == null 
	|| ((Boolean) session.getAttribute("valida")) != true){
%>

<body>
	<h1 style="text-align:center;vertical-align:middle;">FriedBaconBank: tu bacon siempre a salvo</h1>
	<br>
	
	<div style="text-align:center;vertical-align:middle;">
		<form method="post" action="Login">
				<input type="text" name="user" id="user" value="" placeholder="User" />
				<br>
				<input type="password" name="pass" id="pass" value="" placeholder="Password" />
				<br>
				<input type="submit" value="Login" />
			</form>
		<br><br>
		<a href="Nuevo"><button>Nuevo Usuario</button></a>
		<br><br><br><br>
		<br><br><br><br>
	</div>
</body>
</html>

<%
	}else{
		response.sendRedirect("user.jsp");
	} 
%>