package tp.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tp.dao.ILocalidadDao;
import tp.dominio.Localidad;
import tp.servicio.ILocalidadService;

@Service("localidadService")
public class LocalidadService implements ILocalidadService{

	private ILocalidadDao _localidadDao;
	
	@Autowired
	public LocalidadService(@Qualifier("localidadDao") ILocalidadDao localidadDao)
	{
		_localidadDao = localidadDao;
	}
	
	@Override
	public List<Localidad> selectList() {
		return _localidadDao.selectList();
	}

	@Override
	public Localidad readOne(int id) {
		return _localidadDao.readOne(id);
	}

}
