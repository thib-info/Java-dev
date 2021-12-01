package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.*;

public class TestResultDaoMem extends TestDaoMem implements TestResultDao {
	
	private int status; // 0 = not done / 1 = success / 2 = did but fail
	
	public TestResultDaoMem() {
		this.status = 0;
	}

	@Override
	public int getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(int value) {
		this.status = value;
	}
	
}
