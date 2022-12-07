package tp.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import common.QueryUtil;
import tp.dao.IPrestamoDao;
import tp.dominio.Prestamo;

@Repository("prestamoDao")
public class PrestamoDao extends GenericDao<Prestamo> implements IPrestamoDao {

	public PrestamoDao() {
		super(Prestamo.class);
	}
	
	public List<Object[]> selectListByBiblioteca(String property, String value){
		String posibleQuery = queryBiblioteca(value);
		this.conexion = new Conexion();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		List<Object[]> list = session.createQuery(queryBiblioteca(value)).list();
		this.conexion.cerrarSession();
		return list;
	}
	
	public List<Object[]> selectListByCliente(String property, String value){
		String posibleQuery = queryCliente(value);
		this.conexion = new Conexion();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		List<Object[]> list = session.createQuery(queryCliente(value)).list();
		this.conexion.cerrarSession();
		return list;
	}
	
	private String queryBiblioteca(String value) {
		return "FROM prestamo AS PR INNER JOIN PR.biblioteca AS BIB INNER JOIN BIB.libro AS LIB WHERE LIB.titulo LIKE " + "'%" + value + "%'";
	}
	
	private String queryCliente(String value) {
		return "FROM prestamo AS PR INNER JOIN PR.cliente AS CL INNER JOIN CL.persona AS PER WHERE PER.nombre LIKE " + "'%" + value + "%' OR PER.apellido LIKE '%" + value + "%'";
	}

}
