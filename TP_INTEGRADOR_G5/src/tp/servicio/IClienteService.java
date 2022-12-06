package tp.servicio;

import java.util.List;

import common.Response;
import tp.dominio.Cliente;

public interface IClienteService {
	
	Response create(Cliente entity);

	Cliente readOne(int id);

	Response update(Cliente entity);

	Response delete(int id);

	List<Cliente> selectList();

	List<Cliente> selectListByProperty(String property, String value);
}
