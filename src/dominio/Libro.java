package dominio;

import java.io.Serializable;
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
import javax.persistence.UniqueConstraint;

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
	@JoinColumn(name="idAutor")
	private Autor autor;
	
	private String descripcion;
	
	@ManyToMany(cascade= {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name="libros_x_generos",
	    joinColumns=
	        @JoinColumn(name="id_libro"),
	    inverseJoinColumns=
	        @JoinColumn(name="id_genero")
    )
	private Set<Genero> generos;
	
	public Libro(){
		this.generos = new HashSet<Genero>();
	}
	
	public Libro(int isbn, String titulo, Date fechaLanzamiento, String idioma, int cantidadPaginas, Autor autor,
			String descripcion, Set<Genero> generos) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.idioma = idioma;
		this.cantidadPaginas = cantidadPaginas;
		this.autor = autor;
		this.descripcion = descripcion;
		this.generos = generos;
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

	@Override
	public String toString() {
		return "\nLibro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", fechaLanzamiento=" + fechaLanzamiento
				+ ", idioma=" + idioma + ", cantidadPaginas=" + cantidadPaginas + ", autor=" + autor + ", descripcion="
				+ descripcion + ", generos=" + generos + "]";
	}
	
}
