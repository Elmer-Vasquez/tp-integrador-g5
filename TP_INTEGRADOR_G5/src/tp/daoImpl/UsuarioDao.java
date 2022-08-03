package tp.daoImpl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tp.dao.IUsuarioDao;
import tp.dominio.Usuario;

@Repository("usuarioDao")
public class UsuarioDao extends GenericDao<Usuario> implements IUsuarioDao{
	
	public Usuario usuario;

	public UsuarioDao() {
		super(Usuario.class);
	}
	
	public Usuario login(String email, String password) {
		conexion = new Conexion();
		usuario = new Usuario();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		usuario = (Usuario)session.createQuery("from Usuario where password='" + password + "'").uniqueResult();
        conexion.cerrarSession();
		return usuario;
	}

}
