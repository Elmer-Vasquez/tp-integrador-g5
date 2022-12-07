package tp.dao;

import java.util.List;

import tp.dominio.Libro;
import tp.dominio.Prestamo;

public interface IPrestamoDao extends IGenericDao<Prestamo>{
	List<Object[]> selectListByBiblioteca(String property, String value);
	List<Object[]> selectListByCliente(String property, String value);
}
