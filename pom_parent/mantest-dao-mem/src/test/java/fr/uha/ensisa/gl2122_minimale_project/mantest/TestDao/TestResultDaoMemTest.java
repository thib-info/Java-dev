package fr.uha.ensisa.gl2122_minimale_project.mantest.TestDao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestResultDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.TestResultDaoMem;

class TestResultDaoMemTest {

	private TestResultDao result;
	
	@BeforeEach
	void setUp() throws Exception {
		this.result = new TestResultDaoMem();
	}

	@Test
	void getStatusTest() {
		int status = this.result.getStatus();
		assertTrue(status < 3 && status >= 0);
	}
	
	@Test
	void setStatusTest() {
		this.result.setStatus(1);
		assertEquals(this.result.getStatus(), 1);
	}

}
