package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestResultDao;

public class TestDaoMem implements TestDao {
	private String name;
	private String description;
	private long id;
	
	private TestResultDaoMem result;
	
	public TestDaoMem() {
		this.name = "default";
		this.description = "default";
		this.id = 0;
	}
	
	public TestDaoMem(String name, String description, long id) {
		this.name = name;
		this.description = description;
		this.id = id;
		
		this.result = new TestResultDaoMem();
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public long getId() {
		return this.id;
	}
	
	public TestResultDao getResult() {
		return this.result;
	}
	
}
