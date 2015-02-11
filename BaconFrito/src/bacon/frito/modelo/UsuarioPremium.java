package bacon.frito.modelo;

public class UsuarioPremium extends UsuarioBacon{

	public UsuarioPremium( String user, String pass, String nombre,
			String apellidos, String telefono, String sexo, String bday, String foto, String tipo, String activo) {
		super( user, pass, nombre, apellidos, telefono, sexo, bday, foto, tipo, activo);
	}
	
	public boolean sendGroupMessage(String destiny, String subject, String text){
		//TODO: implementar mensaje a grupo
		return false;
	}

}
