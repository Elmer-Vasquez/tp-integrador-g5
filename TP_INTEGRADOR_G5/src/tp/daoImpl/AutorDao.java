package tp.daoImpl;

import org.springframework.stereotype.Repository;

import tp.dao.IAutorDao;
import tp.dominio.Autor;

@Repository("autorDao")
public class AutorDao extends GenericDao<Autor> implements IAutorDao{

	public AutorDao() {
		super(Autor.class);
	}

}
