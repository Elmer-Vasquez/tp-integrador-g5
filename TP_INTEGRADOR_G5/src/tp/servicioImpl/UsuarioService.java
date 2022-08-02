package tp.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tp.dao.IUsuarioDao;
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
	public int create(Usuario entity) {
		_usuarioDao.create(entity);
		return 0;
	}

	@Override
	public Usuario readOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario update(Usuario entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

}
