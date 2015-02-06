package bacon.frito.controlador;

public class ControladorUsuarios {
	
	private static ControladorUsuarios instancia;
	
	static{
		instancia = new ControladorUsuarios();
	}

	private ControladorUsuarios(){
		
	}
	
	public ControladorUsuarios getInstance(){
		return instancia;
	}
	
}
