package tp.daoImpl;

import org.springframework.stereotype.Repository;

import tp.dao.ILibroDao;
import tp.dominio.Libro;

@Repository("libroDao")
public class LibroDao extends GenericDao<Libro> implements ILibroDao{

	public LibroDao() {
		super(Libro.class);
	}

}
