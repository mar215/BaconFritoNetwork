package bacon.frito.modelo;

import java.sql.Date;

public class Mensaje {
	private int id;
	private String texto;
	private String destino;
	private String origen;
	private Date fecha;



	public Mensaje(int id, String texto, String destino, String origen, Date fecha) {
		super();
		this.id = id;
		this.texto = texto;
		this.destino = destino;
		this.origen = origen;
		this.fecha = fecha;
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
	
	
	
	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
