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
	public List<Biblioteca> selectList() {
		return _bibliotecaDao.selectList();
	}

}
