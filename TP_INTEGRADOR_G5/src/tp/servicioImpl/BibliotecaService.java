package tp.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tp.dao.IBibliotecaDao;
import tp.dominio.Biblioteca;
import tp.servicio.IBibliotecaService;

@Service("bibliotecaService")
public class BibliotecaService implements IBibliotecaService{
	
	private IBibliotecaDao _bibliotecaDao;
	
	@Autowired
	public BibliotecaService(@Qualifier("bibliotecaDao") IBibliotecaDao bibliotecaDao)
	{
		_bibliotecaDao = bibliotecaDao;
	}

	@Override
	public int create(Biblioteca entity) {
		return _bibliotecaDao.create(entity);
	}

	@Override
	public void delete(int id) {
		
	}

	@Override
	public Biblioteca update(Biblioteca entity) {
		return _bibliotecaDao.update(entity);
	}

	@Override
	public Biblioteca readOne(int id) {
		return _bibliotecaDao.readOne(id);
	}

	@Override
	public List<Biblioteca> selectList() {
		return _bibliotecaDao.selectList();
	}

}
