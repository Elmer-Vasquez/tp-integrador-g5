package tp.servicio;

import java.util.List;

import tp.dominio.Usuario;

public interface IUsuarioService {
	int create (Usuario entity);
	Usuario readOne(int id);
	Usuario update(Usuario entity);
	void delete (int id);
	List<Usuario> selectList();
}
