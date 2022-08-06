package tp.servicio;

import java.util.List;

import tp.dominio.Biblioteca;

public interface IBibliotecaService {
	
	List<Biblioteca> selectList();
	Biblioteca readOne(int id);
}
