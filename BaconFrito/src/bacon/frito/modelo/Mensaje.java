package bacon.frito.modelo;

public class Mensaje {
	private int id;
	private String texto;
	private String destino;
	private String origen;
	
	
	public Mensaje(int id, String texto, String destino, String origen) {
		super();
		this.id = id;
		this.texto = texto;
		this.destino = destino;
		this.origen = origen;
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


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	
	
	
	
	
}
