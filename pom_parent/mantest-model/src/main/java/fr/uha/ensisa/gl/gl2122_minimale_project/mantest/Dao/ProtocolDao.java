package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

import java.util.List;

public interface ProtocolDao extends ModelDao {
	public void addTest(TestDao test);
	public void removeTest(long id);
	public StoreDao<TestDao> getTests();
	
	public void setCategory(String type);
	public String getCategory();
	
	public void setStatus(int status);
	public int getStatus();
}
