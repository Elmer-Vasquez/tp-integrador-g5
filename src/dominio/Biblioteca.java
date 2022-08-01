package dominio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Biblioteca implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade= {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name="idLibro")
	private Libro libro;
	
	private Date fechaAlta;
	
	private int estado;
	
	public Biblioteca() {}
	
	public Biblioteca(int id, Libro libro, Date fechaAlta, int estado) {
		super();
		this.id = id;
		this.libro = libro;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public String GetDatosPunto2() {
		return "\nId: " + id + "\nFecha alta: " + fechaAlta + "\nTitulo libro: " + libro.getTitulo() + "\n";
	}

	@Override
	public String toString() {
		return "\nBiblioteca [id=" + id + ", libro=" + libro + ", fechaAlta=" + fechaAlta + ", estado=" + estado + "]";
	}
}
