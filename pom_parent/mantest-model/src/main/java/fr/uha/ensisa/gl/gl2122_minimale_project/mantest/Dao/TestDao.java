package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface TestDao {
	public void setName(String name);
	public void setDescription(String description);
	public void setId(long id);
	
	public String getName();
	public String getDescription();
	public long getId();
	public TestResultDao getResult();
}
