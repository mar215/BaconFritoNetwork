package bacon.frito.modelo;

public class GrupoUsuario {
	private int idusuario;
	private int idgrupo;
	
	
	public GrupoUsuario(int idusuario, int idgrupo) {
		super();
		this.idusuario = idusuario;
		this.idgrupo = idgrupo;
	}


	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public int getIdgrupo() {
		return idgrupo;
	}


	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}
	
	
	
}
