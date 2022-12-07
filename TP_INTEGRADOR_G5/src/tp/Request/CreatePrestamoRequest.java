package tp.Request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CreatePrestamoRequest {
	private int bibliotecaId;
	private int clienteId;
	private int cantDias;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	public int getBibliotecaId() {
		return bibliotecaId;
	}

	public void setBibliotecaId(int bibliotecaId) {
		this.bibliotecaId = bibliotecaId;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public CreatePrestamoRequest() {
	}
}
