package bacon.frito.modelo;

public class Grupo {
	private int id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private int maxintegrantes;
	private String activo;
	
	
	public Grupo(int id, String nombre, String descripcion, String imagen,
			int maxintegrantes, String activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.maxintegrantes = maxintegrantes;
		this.activo = activo;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public int getMaxintegrantes() {
		return maxintegrantes;
	}


	public void setMaxintegrantes(int maxintegrantes) {
		this.maxintegrantes = maxintegrantes;
	}


	public String getActivo() {
		return activo;
	}


	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	
	
}
