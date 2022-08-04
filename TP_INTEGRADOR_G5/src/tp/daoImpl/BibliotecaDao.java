package tp.daoImpl;

import org.springframework.stereotype.Repository;

import tp.dao.IBibliotecaDao;
import tp.dominio.Biblioteca;

@Repository("bibliotecaDao")
public class BibliotecaDao extends GenericDao<Biblioteca> implements IBibliotecaDao{

	public BibliotecaDao() {
		super(Biblioteca.class);
	}

}
