package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

import java.util.Collection;

public interface StoreDao<T> {
	
	    public void save(long id, T obj);
	    public void remove(long id);
	    public T find(long id);
	    public Collection<T> findAll();
	    public long count();
}
