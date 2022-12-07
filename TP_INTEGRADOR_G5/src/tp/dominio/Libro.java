package tp.dominio;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import common.EstadoLibro;
import tp.Request.CreateBibliotecaRequest;
import tp.Request.CreateLibroRequest;
import tp.Request.UpdateLibroRequest;

@Component
@Entity
public class Libro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private int isbn;
	
	private String titulo;
	
	private Date fechaLanzamiento;
	
	private String idioma;
	
	private int cantidadPaginas;
	
	@ManyToOne(cascade= {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="autor_id")
	private Autor autor;
	
	private String descripcion;
	
	@ManyToMany(cascade= {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name="libros_x_generos",
	    joinColumns=
	        @JoinColumn(name="libro_id"),
	    inverseJoinColumns=
	        @JoinColumn(name="genero_id")
    )
	
	private Set<Genero> generos;
	
	private EstadoLibro estadoLibro;

	private boolean estado;

	public Libro(){
		this.generos = new HashSet<Genero>();
	}
	
	public Libro(CreateBibliotecaRequest request, Genero genero, Autor autor) {
		this.generos = new HashSet<Genero>(Arrays.asList(genero));
		this.autor = autor;
		this.isbn = request.getLibro().getIsbn();
		this.titulo = request.getLibro().getTitulo();
		this.fechaLanzamiento = request.getLibro().getFechaLanzamiento();
		this.idioma = request.getLibro().getIdioma();
		this.cantidadPaginas = request.getLibro().getCantidadPaginas();
		this.descripcion = request.getLibro().getDescripcion();
		this.estadoLibro = EstadoLibro.biblioteca;
		this.estado= true;
	}
	
	public Libro(CreateLibroRequest request) {
		this.isbn = request.getIsbn();
		this.titulo = request.getTitulo();
		this.fechaLanzamiento = request.getFechaLanzamiento();
		this.idioma = request.getIdioma();
		this.cantidadPaginas = request.getCantidadPaginas();
		this.descripcion = request.getDescripcion();
	}
	
	public Libro(int isbn, String titulo, Date fechaLanzamiento, String idioma, int cantidadPaginas, Autor autor,
			String descripcion, Set<Genero> generos, EstadoLibro estadoLibro, boolean estado) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.idioma = idioma;
		this.cantidadPaginas = cantidadPaginas;
		this.autor = autor;
		this.descripcion = descripcion;
		this.generos = generos;
		this.estadoLibro = estadoLibro;
		this.estado= estado;
	}

	public Libro(UpdateLibroRequest request) {
		this.isbn = request.getIsbn();
		this.titulo = request.getTitulo();
		this.fechaLanzamiento = request.getFechaLanzamiento();
		this.idioma = request.getIdioma();
		this.cantidadPaginas = request.getCantidadPaginas();
		this.descripcion = request.getDescripcion();
		this.autor.setPersona(new Persona(request.getIdAutor()));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int iSBN) {
		isbn = iSBN;
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
	
	public void agregarGenero(Genero genero) {
		this.generos.add(genero);
	}
	
	public EstadoLibro getEstadoLibro() {
		return estadoLibro;
	}

	public void setEstadoLibro(EstadoLibro estadoLibro) {
		this.estadoLibro = estadoLibro;
	}
	
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "\nLibro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", fechaLanzamiento=" + fechaLanzamiento
				+ ", idioma=" + idioma + ", cantidadPaginas=" + cantidadPaginas + ", autor=" + autor + ", descripcion="
				+ descripcion + ", generos=" + generos + "]";
	}
	
}
