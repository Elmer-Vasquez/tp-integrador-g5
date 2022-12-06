package tp.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tp.dao.IGeneroDao;
import tp.dominio.Genero;
import tp.dominio.Nacionalidad;
import tp.servicio.IGeneroService;

@Service("generoService")
public class GeneroService implements IGeneroService{

	private IGeneroDao _generoDao;
	
	@Autowired
	public GeneroService(@Qualifier("generoDao") IGeneroDao generoDao)
	{
		_generoDao = generoDao;
	}
	
	@Override
	public List<Genero> selectList() {
		return _generoDao.selectList();
	}

	@Override
	public Genero readOne(int id) {
		return _generoDao.readOne(id);
	}

}
