package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface System extends Model {
	public void addTest(Test test);
	public void removeTest(Test test);
	public void modifyTest(long id, Test test);
	public Test getTest(long id);
	public Store<Test> allTest();
	public long countTest();

}
