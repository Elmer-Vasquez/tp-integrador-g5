package tp.dao;

import java.util.List;

public interface IGenericDao<T> {
	int create(T entity);
	T readOne(int id);
	T update(T entity);
	void delete(T entity);
	List<T> selectList(String query);
	T selectUnique(String query);
}
