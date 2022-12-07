package tp.servicio;

import java.util.List;

import common.Response;
import tp.dominio.Libro;

public interface ILibroService {
	
	int create(Libro entity);
	
	void delete(Libro entity);
	
	Libro update(Libro entity);
	
	Response update1(Libro entity);
	
	Libro readOne(int id);
	
	List<Libro> selectList();
	
}
