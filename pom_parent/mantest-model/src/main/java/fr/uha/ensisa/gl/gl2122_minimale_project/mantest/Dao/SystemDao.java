package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface SystemDao extends ModelDao {
	public void addTest(TestDao test);
	public void removeTest(TestDao test);
	public void modifyTest(long id, TestDao test);
	public TestDao getTest(long id);
	public StoreDao<TestDao> allTest();
	public long countTest();

}
