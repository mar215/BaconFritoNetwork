<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Cliente</title>
</head>
<%@ page import="gft.luzti.java.modelo.*" %>
<%! Cliente cliente; %>
<%
	if(session.isNew() == true 
	|| session.getAttribute("valida") == null 
	|| ((Boolean) session.getAttribute("valida")) != true){
		response.sendRedirect("index.jsp");
	}else{
		cliente = (Cliente) session.getAttribute("cliente");
		if(cliente == null){
			response.sendRedirect("LogOut");
			return;
		}
%>
<body>
	
	<h1 style="text-align:center;vertical-align:middle;">Datos cliente</h1>
	<br>
	
	<div style="text-align:center;vertical-align:middle;">
		<table>
			<tr>
				<th>Usuario</th>
				<td> <%=cliente.getUser()%> </td>
			</tr>
			<tr>
				<th>Nombre</th>
				<td> <%=cliente.getNombre()%> </td>
			</tr>
			<tr>
				<th>Apellidos</th>
				<td> <%=cliente.getApellidos()%> </td>
			</tr>
			<tr>
				<th>DNI</th>
				<td> <%=cliente.getDni()%> </td>
			</tr>
			<tr>
				<th>Nº cuenta</th>
				<td> <%=cliente.getCuenta().getNumeroCuenta()%> </td>
			</tr>
			<tr>
				<th>Saldo</th>
				<td> <%=cliente.getCuenta().getSaldo()%> </td>
			</tr>
		</table>
		<br><br>
		<h2>Ingresar saldo (puede ser positivo o negativo)</h2>
		<form method="post" action="AddSaldo">
			<input type="text" name="saldo" id="saldo" value="" placeholder="saldo" />
			<input type="submit" value="AddSaldo" />
		</form>
		<br><br><br><br>
		<br><br><br><br>
		<a href="LogOut"><button>LogOut</button></a>
	</div>
	
	
	
</body>
</html>
<% } %>