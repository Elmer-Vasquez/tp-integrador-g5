package tp.Request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import common.EstadoLibro;

public class UpdateLibroRequest {
private int id;
	
	private int isbn;
	
	private String titulo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaLanzamiento;
	
	private String idioma;
	
	private int cantidadPaginas;
	
	private String descripcion;
	
	private EstadoLibro estadoLibro;
	
	private int idGeneros;
	
	private int idAutor;
	
	public UpdateLibroRequest(){ }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(int cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdGeneros() {
		return idGeneros;
	}

	public void setIdGeneros(int idGeneros) {
		this.idGeneros = idGeneros;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public EstadoLibro getEstadoLibro() {
		return estadoLibro;
	}

	public void setEstadoLibro(EstadoLibro estadoLibro) {
		this.estadoLibro = estadoLibro;
	}
}
