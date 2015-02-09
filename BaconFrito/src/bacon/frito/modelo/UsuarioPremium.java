package bacon.frito.modelo;

public class UsuarioPremium extends UsuarioBacon{

	public UsuarioPremium(int id, String user, String pass, String nombre,
			String apellidos, String telefono, String sexo, String bday, String foto) {
		super(id, user, pass, nombre, apellidos, telefono, sexo, bday, foto);
	}
	
	public boolean sendGroupMessage(String destiny, String subject, String text){
		//TODO: implementar mensaje a grupo
		return false;
	}

}
