package bacon.frito.modelo;

public class Amistad {
	String nickOrigen;
	String nickDestino;
	
	
	public Amistad(String nickOrigen, String nickDestino) {
		super();
		this.nickOrigen = nickOrigen;
		this.nickDestino = nickDestino;
	}


	public String getNickOrigen() {
		return nickOrigen;
	}


	public void setNickOrigen(String nickOrigen) {
		this.nickOrigen = nickOrigen;
	}


	public String getNickDestino() {
		return nickDestino;
	}


	public void setNickDestino(String nickDestino) {
		this.nickDestino = nickDestino;
	}
	
	
	
	
	
}
