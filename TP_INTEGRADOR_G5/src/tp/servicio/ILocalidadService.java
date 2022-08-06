package tp.servicio;

import java.util.List;

import tp.dominio.Localidad;

public interface ILocalidadService {
	List<Localidad> selectList();
	Localidad readOne(int id);
}
