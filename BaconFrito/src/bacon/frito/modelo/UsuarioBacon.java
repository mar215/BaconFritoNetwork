package bacon.frito.modelo;

import java.util.ArrayList;

public class UsuarioBacon extends Usuario{
	//TODO: cumpleaños y sexo
	private String	nombre;
	private String	apellidos;
	private String	telefono;
	private String sexo;
	private String bday;
	private String	foto;
	private String activo;
	
	
	/**
	 * @param nombre nombre de usuario
	 * @param apellidos apellidos del usuario
	 * @param telefono telefono del usuario
	 * @param foto url que contiene la foto del usuario
	 */
	

	public boolean sendMessage(String destiny, String subject, String text){
		//TODO: implementar enviar mensaje
		return false;
	}
	
	public UsuarioBacon(int id, String nick, String pass, String nombre,
			String apellidos, String telefono, String sexo, String bday,
			String foto) {
		super(id, nick, pass);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.sexo = sexo;
		this.bday = bday;
		this.foto = foto;
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
	
	
	//GET and SET

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getBday() {
		return bday;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	

	
	

}
