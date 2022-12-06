package tp.Request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UpdateBibliotecaRequest {
	
	private int id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaAlta;
	
	private int estado;

	public UpdateBibliotecaRequest() {}

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
