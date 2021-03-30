package ar.edu.um.disenio.dogsupport.servicio;

import java.io.Serializable;
import java.util.List;

public interface Crud<T, ID extends Serializable> {
	public T create(T object);
	public T remove(T object);
	public T update(T object);
	public List<T> findAll();
	public T findById(ID id);
	public List<T> findByQuery(String property, String text);
	public List<T> findAllByForeignKey(String property, Object value);
	
}
