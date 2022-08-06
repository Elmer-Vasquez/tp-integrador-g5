package tp.Request;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import common.EstadoLibro;
import tp.dominio.Autor;
import tp.dominio.Genero;

@Component
public class CreateLibroRequest {

	private int id;
	
	private int isbn;
	
	private String titulo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaLanzamiento;
	
	private String idioma;
	
	private int cantidadPaginas;
	
	private Autor autor;
	
	private String descripcion;
	
	private Set<Genero> generos;
	
	private EstadoLibro estadoLibro;

	private boolean estado;
	
	public CreateLibroRequest(){ estado = true; }

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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}

	public EstadoLibro getEstadoLibro() {
		return estadoLibro;
	}

	public void setEstadoLibro(EstadoLibro estadoLibro) {
		this.estadoLibro = estadoLibro;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
