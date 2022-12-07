package common;

public enum EstadoLibro {
	biblioteca("En biblioteca", 0),
	prestado("Prestado", 1);
	
	private String nombre;
	private int posicion;
	
	private EstadoLibro (String nombre, int posicion){
		this.nombre = nombre;
		this.posicion = posicion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getPosicion() {
		return posicion;
	}

}
