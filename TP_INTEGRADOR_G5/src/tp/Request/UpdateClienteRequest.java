package tp.Request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UpdateClienteRequest {
	
	private String id;
	
	private String nombre;

	private String apellido;
	
	private String email;
	
	private String sexo;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaNacimiento;
	
	private int dni;
	
	private int telefono;

	private int nacionalidadId;
	
	private int localidadId;
	
	public UpdateClienteRequest() {}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getNacionalidadId() {
		return nacionalidadId;
	}

	public void setNacionalidadId(int nacionalidadId) {
		this.nacionalidadId = nacionalidadId;
	}

	public int getLocalidadId() {
		return localidadId;
	}

	public void setLocalidadId(int localidadId) {
		this.localidadId = localidadId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
