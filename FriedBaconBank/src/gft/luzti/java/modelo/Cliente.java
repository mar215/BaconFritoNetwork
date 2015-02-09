package gft.luzti.java.modelo;


public class Cliente {

	private String user;
	private String pass;
	private String nombre;
	private String apellidos;
	private String dni;
	private Cuenta cuenta;
	
	public Cliente(String user, String pass, String nombre, String apellidos, String dni, Cuenta cuenta) {
		super();
		this.user		= user;
		this.pass		= pass;
		this.nombre 	= nombre;
		this.apellidos 	= apellidos;
		this.dni 		= dni;
		this.cuenta 	= cuenta;
	}

	@Override
	public String toString(){
		return getUser() + " " + getNombre() + " " 
			   + getApellidos() + " " + getDni() + " " 
			   + cuenta.toString();
	}
	
	public boolean verify(String pass){
		if(this.pass.equals(pass)){
			return true;
		}else{
			return false;
		}
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
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the cuenta
	 */
	public Cuenta getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	
	
}
