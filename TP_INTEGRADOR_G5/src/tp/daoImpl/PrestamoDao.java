package tp.daoImpl;

import org.springframework.stereotype.Repository;

import tp.dao.IPrestamoDao;
import tp.dominio.Prestamo;

@Repository("prestamoDao")
public class PrestamoDao extends GenericDao<Prestamo> implements IPrestamoDao {

	public PrestamoDao() {
		super(Prestamo.class);
	}

}
