package tp.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import common.Response;
import tp.dao.IPrestamoDao;
import tp.dominio.Prestamo;
import tp.servicio.IPrestamoService;

@Service("prestamoService")
public class PrestamoService implements IPrestamoService {
	private IPrestamoDao _PrestamoDao;

	@Autowired
	public PrestamoService(@Qualifier("prestamoDao") IPrestamoDao PrestamoDao) {
		_PrestamoDao = PrestamoDao;
	}

	@Override
	public Response create(Prestamo entity) {
		try {
			_PrestamoDao.create(entity);
			return Response.SUCCES;
		} catch (Exception ex) {
			return Response.ERROR;
		}
	}

	@Override
	public Response delete(int id) {
		try {
			Prestamo prestamoTODelete = new Prestamo();
			prestamoTODelete.setId(id);
			_PrestamoDao.delete(prestamoTODelete);
			return Response.SUCCES;
		} catch (Exception ex) {
			return Response.ERROR;
		}

	}

	@Override
	public Response update(Prestamo entity) {
		try {
			_PrestamoDao.update(entity);
			return Response.SUCCES;
		} catch (Exception ex) {
			return Response.ERROR;
		}
	}

	@Override
	public Prestamo readOne(int id) {
		return _PrestamoDao.readOne(id);
	}

	@Override
	public List<Prestamo> selectList() {
		return _PrestamoDao.selectList();
	}

	@Override
	public List<Prestamo> selectListByProperty(String property, String value) {
		List<Prestamo> list = new ArrayList<Prestamo>();

		List<Object[]> list2 = new ArrayList<Object[]>();
		if (property.equals("biblioteca") || property.equals("cliente")) {
			list2 = property.equals("biblioteca") 
					? _PrestamoDao.selectListByBiblioteca(property, value)
					: _PrestamoDao.selectListByCliente(property, value);

			for (Object[] obj : list2) {
				list.add((Prestamo) obj[0]);
			}

		} else if(property.equals("fechaPrestamo")){
			list = _PrestamoDao.selectListByStringProperty(property, value);
		} else {
			list = _PrestamoDao.selectListByIntegerProperty(property, value);
		}
		return list;
	}
}
