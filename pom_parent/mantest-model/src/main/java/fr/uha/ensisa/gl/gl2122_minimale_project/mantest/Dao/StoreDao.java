package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface StoreDao<Test> {
	public void save(long id, Test obj);
    public void remove(long id);
    public Test find(long id);
    public long count();
}