package bacon.frito.modelo;

public class UsuarioPremium extends UsuarioBacon{

	public UsuarioPremium(int id, String user, String pass, String nombre,
			String apellidos, String telefono, String sexo, String bday, String foto, String activo) {
		super(id, user, pass, nombre, apellidos, telefono, sexo, bday, foto, activo);
	}
	
	public boolean sendGroupMessage(String destiny, String subject, String text){
		//TODO: implementar mensaje a grupo
		return false;
	}

}
