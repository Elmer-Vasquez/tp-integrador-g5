package tp.daoImpl;

import org.springframework.stereotype.Repository;

import tp.dao.INacionalidadDao;
import tp.dominio.Nacionalidad;

@Repository("nacionalidadDao")
public class NacionalidadDao extends GenericDao<Nacionalidad> implements INacionalidadDao{

	public NacionalidadDao() {
		super(Nacionalidad.class);
	}

}
