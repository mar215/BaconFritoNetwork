package bacon.frito.modelo;

public class GrupoUsuario {
	private String nickusuario;
	private int idgrupo;
	
	
	public GrupoUsuario(String nickusuario, int idgrupo) {
		super();
		this.nickusuario = nickusuario;
		this.idgrupo = idgrupo;
	}


	public String getNickusuario() {
		return nickusuario;
	}


	public void setNickusuario(String nickusuario) {
		this.nickusuario = nickusuario;
	}


	public int getIdgrupo() {
		return idgrupo;
	}


	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}
	
	
	
	
	
}
