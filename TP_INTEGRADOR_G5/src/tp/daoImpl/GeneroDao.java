package tp.daoImpl;

import org.springframework.stereotype.Repository;

import tp.dao.IGeneroDao;
import tp.dominio.Genero;

@Repository("generoDao")
public class GeneroDao extends GenericDao<Genero> implements IGeneroDao{

	public GeneroDao() {
		super(Genero.class);
	}

}
