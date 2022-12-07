package tp.Request;

import java.util.Date;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import common.EstadoLibro;
import tp.dominio.Autor;
import tp.dominio.Genero;
import tp.dominio.Libro;

public class CreateBibliotecaRequest {
	private int id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaAlta;

	private Libro libro;

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	private int estado;

	public CreateBibliotecaRequest() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
