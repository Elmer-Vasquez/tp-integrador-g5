package tp.servicio;

import java.util.List;

import common.Response;
import tp.dominio.Prestamo;

public interface IPrestamoService {
	Response create(Prestamo entity);

	Response delete(int id);

	Response update(Prestamo entity);

	Prestamo readOne(int id);

	List<Prestamo> selectList();

	List<Prestamo> selectListByProperty(String property, String value);
	
}
