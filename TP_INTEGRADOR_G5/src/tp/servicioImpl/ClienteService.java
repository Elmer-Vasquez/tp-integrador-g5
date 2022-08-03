package tp.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tp.dao.IClienteDao;
import tp.dominio.Cliente;
import tp.servicio.IClienteService;

@Service("clienteService")
public class ClienteService implements IClienteService{
	
	private IClienteDao _clienteDao;
	
	@Autowired
	public ClienteService(@Qualifier("clienteDao") IClienteDao clienteDao) 
	{
		_clienteDao = clienteDao;
	}

	@Override
	public int create(Cliente entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cliente readOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente update(Cliente entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

}
