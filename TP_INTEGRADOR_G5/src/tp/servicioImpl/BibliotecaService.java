package tp.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import common.Response;
import tp.dao.IBibliotecaDao;
import tp.dominio.Biblioteca;
import tp.dominio.Cliente;
import tp.servicio.IBibliotecaService;

@Service("bibliotecaService")
public class BibliotecaService implements IBibliotecaService{
	
	private IBibliotecaDao _bibliotecaDao;
	
	public BibliotecaService() {}
	
	@Autowired
	public BibliotecaService(@Qualifier("bibliotecaDao") IBibliotecaDao bibliotecaDao)
	{
		_bibliotecaDao = bibliotecaDao;
	}

	@Override
	public Response create(Biblioteca entity) {
		try {
			_bibliotecaDao.create(entity);
			return Response.SUCCES;
		} catch (Exception ex) {
			return Response.ERROR;
		}
	}

	@Override
	public Biblioteca readOne(int id) {
		return _bibliotecaDao.readOne(id);
	}
	
	@Override
	public Response update(Biblioteca entity) {
		try {
			_bibliotecaDao.update(entity);
			return Response.SUCCES;
		} catch (Exception ex) {
			return Response.ERROR;
		}
	}

	@Override
	public Response delete(int id) {
		try {
			Biblioteca biblioteca = new Biblioteca();
			biblioteca.setId(id);
			_bibliotecaDao.delete(biblioteca);
			return Response.SUCCES;
		} catch (Exception ex) {
			return Response.ERROR;
		}
	}

	public List<Biblioteca> selectList() {
		return _bibliotecaDao.selectList();
	}

	@Override
	public List<Biblioteca> selectListByProperty(String propertySelect, String inputText) {
		List<Biblioteca> list = new ArrayList<Biblioteca>();
		
		List<Object[]> list2 = new ArrayList<Object[]>();
		if(propertySelect.equals("libro.isbn") || propertySelect.equals("libro.cantidadPaginas")) {
			list2 = _bibliotecaDao.selectListByInnerIntegerProperty(propertySelect, inputText);
		}else {
			list2 = _bibliotecaDao.selectListByInnerStringProperty(propertySelect, inputText);
		}
		for (Object[] obj : list2) {
			list.add((Biblioteca) obj[0]);
		}
		return list;
	}

}
