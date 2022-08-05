package tp.servicio;

import tp.dominio.Prestamo;

public interface IPrestamoService {
	int create(Prestamo entity);
	void delete(Prestamo entity);
	Prestamo update(Prestamo entity);
	Prestamo readOne(int id);
}
