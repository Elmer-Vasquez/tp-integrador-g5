package tp.servicio;

import java.util.List;

import tp.dominio.Genero;

public interface IGeneroService {
	List<Genero> selectList();
	Genero readOne(int id);
}
