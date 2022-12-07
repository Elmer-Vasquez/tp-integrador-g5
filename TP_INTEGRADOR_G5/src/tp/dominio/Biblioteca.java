package tp.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import common.EstadoLibro;
import tp.Request.CreateBibliotecaRequest;
import tp.Request.CreateLibroRequest;
import tp.Request.UpdateBibliotecaRequest;
import tp.Request.UpdateClienteRequest;

@Component
@Entity
public class Biblioteca implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "libro_id")
	private Libro libro;

	private Date fechaAlta;

	private int estado;

	public Biblioteca() {}

	public Biblioteca(CreateBibliotecaRequest request, Libro libro) {
		this.id = request.getId();
		this.fechaAlta = request.getFechaAlta();
		this.estado = request.getEstado();
		this.libro = libro;
	}

	public Biblioteca(int id, Libro libro, Date fechaAlta, int estado) {
		super();
		this.id = id;
		this.libro = libro;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
	}
	
	public Biblioteca(Libro libro, Genero genero, Autor autor) {
		this.libro = libro;
		this.libro.setGeneros(new HashSet<Genero>(Arrays.asList(genero)));
		this.libro.setAutor(autor);
		this.fechaAlta = new Date();
		this.estado = 0;
	}

	public Biblioteca(CreateBibliotecaRequest request, Libro libro, Genero genero, Autor autor) {
		this.id = request.getId();
		this.libro = libro;
		this.libro.setAutor(autor);
		this.libro.setGeneros(new HashSet<Genero>(Arrays.asList(genero)));
		this.fechaAlta = request.getFechaAlta();
		this.estado = request.getEstado();
	}

	public void update(Autor autor, Genero genero, Libro libro, UpdateBibliotecaRequest request) {
		this.id = request.getId();
		this.libro = libro;
		this.libro.setAutor(autor);
		this.libro.setGeneros(new HashSet<Genero>(Arrays.asList(genero)));
		this.fechaAlta = request.getFechaAlta();
		this.estado = request.getEstado();
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

	public String getFechaAlta() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return formatter.format(this.fechaAlta);
		} catch (Exception ex) {
			return this.fechaAlta.toString();
		}
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

	public String getEstadoReal() {
		return (this.estado == EstadoLibro.biblioteca.getPosicion()) ? "En biblioteca" : "Prestado";
	}
	
	public String GetDatosPunto2() {
		return "\nId: " + id + "\nFecha alta: " + fechaAlta + "\nTitulo libro: " + libro.getTitulo() + "\n";
	}

	@Override
	public String toString() {
		return "\nBiblioteca [id=" + id + ", libro=" + libro + ", fechaAlta=" + fechaAlta + ", estado=" + estado + "]";
	}
}
