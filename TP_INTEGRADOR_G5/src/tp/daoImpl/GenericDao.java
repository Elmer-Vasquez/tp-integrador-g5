package tp.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import tp.dao.IGenericDao;

public abstract class GenericDao<T> implements IGenericDao<T>{
	private Class<T> entityClass;
	
//	public GenericDao(Class<T> entityClass) {
//		this.entityClass = entityClass;
//	}

	public int create(T entity)
	{
//		ConfigHibernate ch = ConfigHibernate.getInstance();
//		Session session= ch.abrirConexion();
//		session.beginTransaction();
//	    int id = (Integer) session.save(entity);
//	    session.getTransaction().commit();
//		ch.cerrarSession();
//		return id;
		return 0;
	}
//	
//	public T readOne(int id)
//	{
//		ConfigHibernate config = ConfigHibernate.getInstance();
//		Session session= config.abrirConexion();
//		session.beginTransaction();
//        T entity = (T) session.get(entityClass, id);
//        config.cerrarSession();
//        return entity;
//	}
//	
//	public T update(T entity)
//	{
//		ConfigHibernate config = ConfigHibernate.getInstance();
//		Session session= config.abrirConexion();
//        session.beginTransaction();
//        session.update(entity);
//        session.getTransaction().commit();     
//        config.cerrarSession();
//        return entity;
//	}
//	
//	public void delete(T entity)
//	{
//		ConfigHibernate config = ConfigHibernate.getInstance();
//		Session session= config.abrirConexion();
//        session.beginTransaction();
//        session.delete(entity);
//        session.getTransaction().commit();
//        config.cerrarSession();
//	}
//	
//	public List<T> selectList(String query){
//		ConfigHibernate config = ConfigHibernate.getInstance();
//		Session session= config.abrirConexion();
//		session.beginTransaction();
//		List<T> list = session.createQuery("FROM " + entityClass.getName() + " " + query).list();
//        config.cerrarSession();
//        return list;
//	}
//
//	public T selectUnique(String query) {
//		ConfigHibernate config = ConfigHibernate.getInstance();
//		Session session= config.abrirConexion();
//		session.beginTransaction();
//        T entity = (T) session.createQuery("FROM " + entityClass.getName() + " " + query).uniqueResult();
//        config.cerrarSession();
//        return entity;
//	}
//	
//	public int selectMaxByField(String field) {
//		ConfigHibernate config = ConfigHibernate.getInstance();
//		Session session= config.abrirConexion();
//		session.beginTransaction();
//        Integer result = (Integer) session.createQuery("SELECT MAX" + "(" + field + ")" + "FROM " + entityClass.getName()).uniqueResult();
//        config.cerrarSession();
//        return result;
//	}
}

