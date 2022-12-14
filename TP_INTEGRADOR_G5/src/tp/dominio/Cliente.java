package tp.dominio;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import tp.Request.CreateClienteRequest;
import tp.Request.UpdateClienteRequest;

@Component
@Entity
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name="persona_id")
	private Persona persona;
	
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "localidad_id")
	private Localidad localidad;
	
	public Cliente() { }
	
	public Cliente(CreateClienteRequest request, Nacionalidad nac, Localidad loc) {
		this.persona = new Persona(request.getNombre(), request.getApellido(), request.getEmail(), request.getSexo(), request.getFechaNacimiento(), request.getDni(),
				request.getTelefono(), nac);
		this.localidad = loc;
	}
	
	public void update(Nacionalidad nac, Localidad loc, UpdateClienteRequest request) {
		this.persona.setNacionalidad(nac);
		this.persona.setNombre(request.getNombre());
		this.persona.setApellido(request.getApellido());
		this.persona.setEmail(request.getEmail());
		this.persona.setSexo(request.getSexo());
		this.persona.setFechaNacimiento(request.getFechaNacimiento());
		this.persona.setDni(request.getDni());
		this.persona.setTelefono(request.getTelefono());
		this.localidad = loc;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	public String getNombreComplete() {
		return this.persona.getNombre() + " " + this.persona.getApellido();
	}
	

	//Metodo sin implementar, a futuro se puede buscar las propiedades por nombre y devolver una lista para manipular
	//Para que funcione es necesario tener las propiedades en public
	public static List<String> getPropertiesToString()
	{
		Field properties[] = Cliente.class.getFields();
		List<String> propToString = new ArrayList<String>();
		for (int i = 0; i < properties.length; i++) {
			propToString.add(properties[i].getName().toUpperCase());
		}
		return propToString;
	}
	
}
