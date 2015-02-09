package gft.luzti.java.modelo;

import java.util.ArrayList;

public class ControladorClientesCuentas {
	
	private static ControladorClientesCuentas instancia;
	
	private ArrayList<Cliente>  clientes;
	private ArrayList<Cuenta> 	cuentas;
	private static int 			idsCuentas;
	
	
	static{
		instancia 	= new ControladorClientesCuentas();
		idsCuentas 	= 0;
	}
	
	public static synchronized ControladorClientesCuentas getInstance(){
		return instancia;
	}
	

	private ControladorClientesCuentas() {
		clientes = new ArrayList<Cliente>();
		cuentas  = new ArrayList<Cuenta>();
		//TODO: leer de BD los datos de clientes y cuentas
	}
	
		
	public boolean pagar(){
				
		
		return false;
	}
	
	
	public boolean addCliente(String user, String pass, String nombre, String apellido, String dni){
		Cliente c = new Cliente(user, pass, nombre, apellido, dni, new Cuenta(idsCuentas++, 0));
		if(!clientes.contains(c)){
			clientes.add(c);
			//TODO: update BD
			return true;
		}else {
			c = null;
			return false;
		}
	}
	
	public void deleteCliente(Cliente c){
		if(clientes.contains(c)){
			//TODO: delete cliente y cuenta
		}
	}
	
	public double addSaldo(int cliente, double saldo){
		//TODO: añadir saldo a la cuenta del cliente
		return 0;
	}

}
