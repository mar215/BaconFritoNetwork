package bacon.frito.modelo;

public class Mensaje {
	private int id;
	private String texto;
	private String destino;
	
	
	public Mensaje(int id, String texto, String destino) {
		super();
		this.id = id;
		this.texto = texto;
		this.destino = destino;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	
	
}
