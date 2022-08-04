package tp.servicio;

import java.util.List;

import tp.dominio.Biblioteca;

public interface IBibliotecaService {
	
	int create(Biblioteca entity);
	
	void delete(int id);
	
	Biblioteca update(Biblioteca entity);
	
	Biblioteca readOne(int id);
	
	List<Biblioteca> selectList();
}
