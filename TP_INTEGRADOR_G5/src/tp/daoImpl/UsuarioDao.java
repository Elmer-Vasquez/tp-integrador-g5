package tp.daoImpl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tp.dao.IUsuarioDao;
import tp.dominio.Persona;
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
		Object[] objeto = (Object[])session.createQuery("from Usuario as u inner join u.persona as p where u.password='" + password + "' and p.email='" + email + "'").uniqueResult();
        usuario = (Usuario) objeto[0];
        usuario.setPersona((Persona)objeto[1]);
		conexion.cerrarSession();
		return usuario;
	}

}
