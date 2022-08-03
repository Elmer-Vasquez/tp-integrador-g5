package tp.servicio;

import java.util.List;

import tp.dominio.Cliente;

public interface IClienteService {
	int create(Cliente entity);

	Cliente readOne(int id);

	Cliente update(Cliente entity);

	void delete(int id);

	List<Cliente> selectList();
}
