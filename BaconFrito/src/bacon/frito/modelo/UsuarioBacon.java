package bacon.frito.modelo;

import java.util.ArrayList;

public class UsuarioBacon extends Usuario{
	//TODO: cumpleaños y sexo
	private String	nombre;
	private String	apellidos;
	private String	telefono;
	private String	foto;
	
	
	/**
	 * @param nombre nombre de usuario
	 * @param apellidos apellidos del usuario
	 * @param telefono telefono del usuario
	 * @param foto url que contiene la foto del usuario
	 */
	public UsuarioBacon(int id, String user, String pass, 
						String nombre, String apellidos, 
						String telefono, String foto) {
		super(id, user, pass);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.foto = foto;
	}

	public boolean sendMessage(String destiny, String subject, String text){
		//TODO: implementar enviar mensaje
		return false;
	}
	
	public ArrayList<Object> readMessages(){
		//TODO: implementar leer mensajes
		return null;
	}
	
	public boolean joinGroup(Object group){
		//TODO: implementar ingresar en grupo
		return false;
	}
	
	public boolean exitGroup(Object group){
		//TODO: implementar dimitir de grupo
		return false;
	}

	public boolean upgrade(){
		//TODO: implementar premium;
		return false;
	}
	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}


	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	

}
