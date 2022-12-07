package tp.servicio;

import java.util.List;

import common.EstadoLibro;
import common.Response;
import tp.dominio.Biblioteca;
import tp.dominio.Cliente;

public interface IBibliotecaService {

	Response create(Biblioteca entity);
	
	Biblioteca readOne(int id);

	Response update(Biblioteca entity);

	Response delete(int id);
	
	List<Biblioteca> selectList();

	List<Biblioteca> selectListByProperty(String property, String value);
	
	List<Biblioteca> selectListByEstado(EstadoLibro estado);
}
