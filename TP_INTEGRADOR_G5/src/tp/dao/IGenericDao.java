package tp.dao;

public interface IGenericDao<T> {
	int create(T entity);
}
