package tp.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tp.dao.IAutorDao;
import tp.dominio.Autor;
import tp.servicio.IAutorService;

@Service("autorService")
public class AutorService implements IAutorService{
	
	private IAutorDao _autorDao;
	
	@Autowired
	public AutorService (@Qualifier("autorDao") IAutorDao autorDao) {
		_autorDao = autorDao;
	}

	@Override
	public List<Autor> selectList() {
		return _autorDao.selectList();
	}

}
