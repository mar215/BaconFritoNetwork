package bacon.frito.controlador;


//Esto es provisional, mejor tener un sequence en sql
public class ControladorIds {
	
	private int idUsuario;
	private int idMensaje;
	
	private static ControladorIds instancia;
	
	static{
		instancia = new ControladorIds();
	}
	
	private ControladorIds(){
		//aquí habría que conectar a la base de datos y pedir los últimos ids
		this.idUsuario = 0;
		this.idMensaje = 0;
		
	}
	
	public static ControladorIds getInstance(){
		return instancia;
	}

}
