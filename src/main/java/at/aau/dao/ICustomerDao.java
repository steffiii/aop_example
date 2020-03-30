package at.aau.dao;



import at.aau.exceptions.MissingElementException;
import at.aau.exceptions.OverflowException;

import java.util.List;


public interface ICustomerDao<T> {

	public T findOne(Long id);
	public T insert(T element) throws OverflowException;
	public void delete(Long id) throws MissingElementException;
	public T update(T element);
	public List<T> findAll();
}
