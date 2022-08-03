package tp.dao;

import tp.dominio.Usuario;

public interface IUsuarioDao extends IGenericDao<Usuario>{
	public Usuario login(String email, String password);
}
