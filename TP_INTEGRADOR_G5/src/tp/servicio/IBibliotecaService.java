package tp.servicio;

import java.util.List;

import tp.dominio.Biblioteca;

public interface IBibliotecaService {
	
	Biblioteca readOne(int id);

	List<Biblioteca> selectListByProperty(String propertySelect, String inputText);

	List<Biblioteca> selectList();
	Biblioteca readOne(int id);
}
