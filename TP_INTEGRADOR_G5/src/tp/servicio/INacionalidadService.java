package tp.servicio;

import java.util.List;

import tp.dominio.Nacionalidad;

public interface INacionalidadService {
	List<Nacionalidad> selectList();
	Nacionalidad readOne(int id);
}
