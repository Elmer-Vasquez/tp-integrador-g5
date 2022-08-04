package tp.daoImpl;

import java.util.List;

import org.hibernate.Session;

import common.QueryUtil;
import tp.dao.IGenericDao;

public abstract class GenericDao<T> implements IGenericDao<T>{
	private Class<T> entityClass;
	
	/*
	 * No usamos autowired ya que arroja error cuando se quiere acceder desde otros navegadores
	 * Se realiza una nueva instancia de conexión cada vez que se quiere realizar un transaction
	 */
	public Conexion conexion;
	
	public GenericDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public int create(T entity)
	{
		this.conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
	    int id = (Integer) session.save(entity);
	    session.getTransaction().commit();
		this.conexion.cerrarSession();
		return id;
	}
	
	public T readOne(int id)
	{
		this.conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
        T entity = (T) session.get(entityClass, id);
        this.conexion.cerrarSession();
        return entity;
	}
	
	public T update(T entity)
	{
		this.conexion = new Conexion();
		Session session= conexion.abrirConexion();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();     
        this.conexion.cerrarSession();
        return entity;
	}

	public void delete(T entity)
	{
		this.conexion = new Conexion();
		Session session= conexion.abrirConexion();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        this.conexion.cerrarSession();
	}
	
	public List<T> selectList(String query)
	{
		this.conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		List<T> list = session.createQuery("FROM " + entityClass.getName() + " " + query).list();
        this.conexion.cerrarSession();
        return list;
	}
	
	public List<T> selectList()
	{
		this.conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		List<T> list = session.createQuery("FROM " + entityClass.getName()).list();
        this.conexion.cerrarSession();
        return list;
	}
	
	public List<T> selectListByProperty(String property, String value) {
		String posibleQuery = QueryUtil.buildQueryByProperty(property, this.entityClass.getSimpleName(), value);
		this.conexion = new Conexion();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		List<T> list = session.createQuery(QueryUtil.buildQueryByProperty(property, this.entityClass.getSimpleName(), value)).list();
		this.conexion.cerrarSession();
		return list;
	}
	
	public List<Object[]> selectListByInnerProperty(String property, String value){
		String posibleQuery = QueryUtil.buildQueryByInnerProperty1(property, this.entityClass.getSimpleName(), value);
		this.conexion = new Conexion();
		Session session = conexion.abrirConexion();
		session.beginTransaction();
		List<Object[]> list = session.createQuery(QueryUtil.buildQueryByInnerProperty1(property, this.entityClass.getSimpleName(), value)).list();
		this.conexion.cerrarSession();
		return list;
	}

	public T selectUnique(String query) 
	{
		this.conexion = new Conexion();
		Session session= conexion.abrirConexion();
		session.beginTransaction();
        T entity = (T) session.createQuery("FROM " + entityClass.getName() + " " + query).uniqueResult();
        this.conexion.cerrarSession();
        return entity;
	}
	
}

