package tp.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import tp.dao.IGenericDao;

public abstract class GenericDao<T> implements IGenericDao<T>{
	private Class<T> entityClass;
	
	@Autowired
	public Conexion conexion;
	
	public GenericDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public int create(T entity)
	{
		Session session= conexion.abrirConexion();
		session.beginTransaction();
	    int id = (Integer) session.save(entity);
	    session.getTransaction().commit();
		conexion.cerrarSession();
		return id;
	}
	
	public T readOne(int id)
	{
		Session session= conexion.abrirConexion();
		session.beginTransaction();
        T entity = (T) session.get(entityClass, id);
        conexion.cerrarSession();
        return entity;
	}
	
	public T update(T entity)
	{
		Session session= conexion.abrirConexion();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();     
        conexion.cerrarSession();
        return entity;
	}

	public void delete(T entity)
	{
		Session session= conexion.abrirConexion();
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        conexion.cerrarSession();
	}
	
	public List<T> selectList(String query)
	{
		Session session= conexion.abrirConexion();
		session.beginTransaction();
		List<T> list = session.createQuery("FROM " + entityClass.getName() + " " + query).list();
        conexion.cerrarSession();
        return list;
	}

	public T selectUnique(String query) 
	{
		Session session= conexion.abrirConexion();
		session.beginTransaction();
        T entity = (T) session.createQuery("FROM " + entityClass.getName() + " " + query).uniqueResult();
        conexion.cerrarSession();
        return entity;
	}
	
}

