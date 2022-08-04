package tp.dao;

import java.util.List;

public interface IGenericDao<T> {
	int create(T entity);
	T readOne(int id);
	T update(T entity);
	void delete(T entity);
	List<T> selectList(String query);
	List<T> selectList();
	T selectUnique(String query);
	List<T> selectListByStringProperty(String property, String value);
	List<T> selectListByIntegerProperty(String property, String value);
	List<Object[]> selectListByInnerStringProperty(String property, String value);
	List<Object[]> selectListByInnerIntegerProperty(String property, String value);
}
