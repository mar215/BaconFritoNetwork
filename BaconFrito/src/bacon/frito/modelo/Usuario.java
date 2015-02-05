package bacon.frito.modelo;



/**
 * Clase abstracta que generaliza las propiedades de los usuarios del servicio
 * 
 * @author	Mario S�nchez Hern�ndez
 * 
 * @param	id 		identificador �nico de usuario
 * @param	nick	alias �nico del usuario
 * @param	pass	contrase�a de usuario
 *	
 */
public abstract class Usuario {
	
	private int 	id;
	private String 	nick;
	private String	pass;
	
	public Usuario(int id, String nick, String pass){
		this.id 	= id;
		this.nick	= nick;
		this.pass	= pass;
	}
	
	
	/**
	 * @param pass password to check
	 * @return true or false depending if the pass was correct or not
	 */
	public boolean login(String pass){
		if(this.pass.equals(pass)){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
