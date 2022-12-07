package tp.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Prestamo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="biblioteca_id")
	private Biblioteca biblioteca;
	
	private Date fechaPrestamo;
	
	private int cantidadDias;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	public Prestamo() {}
	
	public Prestamo(Biblioteca biblioteca, Cliente cli, int cantidadDias, Date fechaPrestamo) {
		super();
		this.biblioteca = biblioteca;
		this.cliente = cli;
		this.cantidadDias = cantidadDias;
		this.fechaPrestamo = fechaPrestamo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public int getCantidadDias() {
		return cantidadDias;
	}
	public void setCantidadDias(int cantidadDias) {
		this.cantidadDias = cantidadDias;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getFechaPrestamoReal() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return formatter.format(this.fechaPrestamo);
		} catch (Exception ex) {
			return this.fechaPrestamo.toString();
		}
	}
	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", biblioteca=" + biblioteca + ", fechaPrestamo=" + fechaPrestamo
				+ ", cantidadDias=" + cantidadDias + ", cliente=" + cliente + "]";
	}
	
}
