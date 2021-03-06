package gft.luzti.java.rest;

import gft.luzti.java.bd.DBHelper;
import gft.luzti.java.modelo.Cliente;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/servicio")
public class PayDay 
	{
	
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
			  return "Contraseņa incorrecta";
		  }else if(cliente.getCuenta().cobrar(Double.parseDouble(amount))){
			  return "Pago correcto";
		  }else {
			  return "No hay fondos";
		  }
	  }
	  
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
				  return "Contraseņa incorrecta";
			  }else {
				  cliente.getCuenta().ingresar(Double.parseDouble(amount));
			  	  return "Ingreso correcto";
			  }
		  }

	}
  
