package tp.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tp.dao.IUsuarioDao;
import tp.dominio.Cliente;
import tp.dominio.Usuario;
import tp.servicio.IUsuarioService;

@Service("usuarioService")
public class UsuarioService implements IUsuarioService{
	
	private IUsuarioDao _usuarioDao;
	
	@Autowired
	public UsuarioService(@Qualifier("usuarioDao") IUsuarioDao usuarioDao)
	{
		_usuarioDao = usuarioDao;
	}
	
	@Override
	public Usuario readOne(int id) {
		return _usuarioDao.readOne(id);
	}

	@Override
	public Usuario login(String email, String password) {
		return _usuarioDao.login(email, password);
	}

	

}
