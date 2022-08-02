package tp.daoImpl;

import org.springframework.stereotype.Repository;

import tp.dao.IUsuarioDao;
import tp.dominio.Usuario;

@Repository("usuarioDao")
public class UsuarioDao extends GenericDao<Usuario> implements IUsuarioDao{


}
