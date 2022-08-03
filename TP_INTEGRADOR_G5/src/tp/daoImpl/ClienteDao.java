package tp.daoImpl;

import org.springframework.stereotype.Repository;

import tp.dao.IClienteDao;
import tp.dominio.Cliente;

@Repository("clienteDao")
public class ClienteDao extends GenericDao<Cliente> implements IClienteDao{

	public ClienteDao() {
		super(Cliente.class);
		// TODO Auto-generated constructor stub
	}

}
