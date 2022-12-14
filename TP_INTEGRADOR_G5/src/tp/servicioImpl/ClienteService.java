package tp.servicioImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import common.Response;
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
	
	public ClienteService() {
		
	}

	@Override
	public Response create(Cliente entity) {
		try {
			_clienteDao.create(entity);
			return Response.SUCCES;
		} catch (Exception ex) {
			return Response.ERROR;
		}
	}

	@Override
	public Cliente readOne(int id) {
		return _clienteDao.readOne(id);
	}

	@Override
	public Response update(Cliente entity) {
		try {
			_clienteDao.update(entity);
			return Response.SUCCES;
		} catch (Exception ex) {
			return Response.ERROR;
		}
	}

	@Override
	public Response delete(int id) {
		try {
			Cliente clienteTODelete = new Cliente();
			clienteTODelete.setId(id);
			_clienteDao.delete(clienteTODelete);
			return Response.SUCCES;
		} catch (Exception ex) {
			return Response.ERROR;
		}
	}

	@Override
	public List<Cliente> selectList() {
		return _clienteDao.selectList();
	}

	@Override
	public List<Cliente> selectListByProperty(String property, String value) {
		List<Cliente> list = new ArrayList<Cliente>();
		
		List<Object[]> list2 = new ArrayList<Object[]>();
		if(property.equals("persona.telefono") || property.equals("persona.dni")) {
			list2 = _clienteDao.selectListByInnerIntegerProperty(property, value);
		}else {
			list2 = _clienteDao.selectListByInnerStringProperty(property, value);
		}
		for (Object[] obj : list2) {
			list.add((Cliente) obj[0]);
		}
		return list;
	}

}
