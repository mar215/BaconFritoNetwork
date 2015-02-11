package gft.luzti.java.rest;

import gft.luzti.java.bd.DBHelper;
import gft.luzti.java.modelo.Cliente;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/servicio")
public class PayDay 
	{
	
	  // Cobro de dinero
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	  @Path("/payday")
	  public String payday(@DefaultValue("0") @QueryParam("user")   String user,
			  			   @DefaultValue("0") @QueryParam("pass")   String pass, 
			  			   @DefaultValue("0") @QueryParam("amount") String amount) {
		  if(user.equals("0") || pass.equals("0") || amount.equals("0")){
			  return "Datos incorrectos";
		  }
		  Cliente cliente = DBHelper.getInstance().getCliente(user);
		  if(cliente == null){
			  return "No existe el cliente solicitado";
		  }else if(!cliente.verify(pass)){
			  return "Contraseña incorrecta";
		  }else if(cliente.getCuenta().cobrar(Double.parseDouble(amount))){
			  return "Pago correcto";
		  }else {
			  return "No hay fondos";
		  }
	  }
	  
	// Ingreso de dinero
		  @GET
		  @Produces(MediaType.TEXT_PLAIN)
		  @Path("/ingreso")
		  public String ingreso(@DefaultValue("0") @QueryParam("user")   String user,
				  			    @DefaultValue("0") @QueryParam("pass")   String pass, 
				  			    @DefaultValue("0") @QueryParam("amount") String amount) {
			  if(user.equals("0") || pass.equals("0") || amount.equals("0")){
				  return "Datos incorrectos";
			  }
			  Cliente cliente = DBHelper.getInstance().getCliente(user);
			  if(cliente == null){
				  return "No existe el cliente solicitado";
			  }else if(!cliente.verify(pass)){
				  return "Contraseña incorrecta";
			  }else {
				  cliente.getCuenta().ingresar(Double.parseDouble(amount));
			  	  return "Ingreso correcto";
			  }
		  }

	}
  
