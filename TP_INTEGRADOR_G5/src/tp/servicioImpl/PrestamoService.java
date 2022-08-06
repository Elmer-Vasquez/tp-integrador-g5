package tp.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tp.dao.IPrestamoDao;
import tp.dominio.Prestamo;
import tp.servicio.IPrestamoService;

@Service("prestamoService")
public class PrestamoService implements IPrestamoService {
private IPrestamoDao _PrestamoDao;
	
	@Autowired
	public PrestamoService(@Qualifier("prestamoDao") IPrestamoDao PrestamoDao)
	{
		_PrestamoDao = PrestamoDao;
	}

	@Override
	public int create(Prestamo entity) {
		return _PrestamoDao.create(entity);
	}

	@Override
	public void delete(Prestamo entity) {
		_PrestamoDao.delete(entity);
		
	}

	@Override
	public Prestamo update(Prestamo entity) {
		return _PrestamoDao.update(entity);
	}

	@Override
	public Prestamo readOne(int id) {
		return _PrestamoDao.readOne(id);
	}
	
	@Override
	public List<Prestamo> selectList() {
		return _PrestamoDao.selectList();
	}
}
