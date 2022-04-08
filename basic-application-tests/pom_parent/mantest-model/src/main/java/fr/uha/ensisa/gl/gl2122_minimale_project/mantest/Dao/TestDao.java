package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface TestDao extends ModelDao{
	public void setName(String name);
	
	public String getName();
	public TestResultDao getResult();
}
