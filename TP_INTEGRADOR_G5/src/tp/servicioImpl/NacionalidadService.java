package tp.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tp.dao.INacionalidadDao;
import tp.dominio.Nacionalidad;
import tp.servicio.INacionalidadService;

@Service("nacionalidadService")
public class NacionalidadService implements INacionalidadService{

	private INacionalidadDao _nacionalidadDao;
	
	@Autowired
	public NacionalidadService(@Qualifier("nacionalidadDao") INacionalidadDao nacionalidadDao) {
		_nacionalidadDao = nacionalidadDao;
	}

	@Override
	public List<Nacionalidad> selectList() {
		return _nacionalidadDao.selectList();
	}

	@Override
	public Nacionalidad readOne(int id) {
		return _nacionalidadDao.readOne(id);
	}

}
