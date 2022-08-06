package tp.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tp.dao.ILibroDao;
import tp.dominio.Libro;
import tp.servicio.ILibroService;

@Service("libroService")
public class LibroService implements ILibroService{
	
	private ILibroDao _LibroDao;
	
	@Autowired
	public LibroService(@Qualifier("libroDao") ILibroDao LibroDao)
	{
		_LibroDao = LibroDao;
	}

	@Override
	public int create(Libro entity) {
		return _LibroDao.create(entity);
	}

	@Override
	public void delete(Libro entity) {
		_LibroDao.delete(entity);
		
	}

	@Override
	public Libro update(Libro entity) {
		return _LibroDao.update(entity);
	}

	@Override
	public Libro readOne(int id) {
		return _LibroDao.readOne(id);
	}

	@Override
	public List<Libro> selectList() {
		return _LibroDao.selectList();
	}

}
