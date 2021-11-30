package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface StoreDao<T> {
	public void save(T obj);
    public void remove(T obj);
    public T find(T obj);
    public int count();
}