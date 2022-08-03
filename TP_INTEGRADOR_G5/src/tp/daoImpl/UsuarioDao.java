package tp.daoImpl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tp.dao.IUsuarioDao;
import tp.dominio.Usuario;

@Repository("usuarioDao")
public class UsuarioDao extends GenericDao<Usuario> implements IUsuarioDao{
	
	@Autowired
	public Conexion conexion;
	public Usuario usuario;

	public UsuarioDao() {
		super(Usuario.class);
	}
	
	public Usuario login(String email, String password) {
		usuario = new Usuario();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		usuario = (Usuario)session.createQuery(String.format
				("from Usuario where email='{0}', password='{1}'",
						email, password)).uniqueResult();
        conexion.cerrarSession();
		return usuario;
	}

}
