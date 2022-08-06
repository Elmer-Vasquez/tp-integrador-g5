package tp.daoImpl;

import org.springframework.stereotype.Repository;

import tp.dao.ILocalidadDao;
import tp.dominio.Localidad;

@Repository("localidadDao")
public class LocalidadDao extends GenericDao<Localidad> implements ILocalidadDao{

	public LocalidadDao() {
		super(Localidad.class);
		// TODO Auto-generated constructor stub
	}

}
