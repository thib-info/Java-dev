package fr.uha.ensisa.gl2122_minimale_project.mantest.TestDao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.TestDaoMem;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.TestResultDaoMem;

class TestDaoMemTest {
	
	private TestDao test;

	@BeforeEach
	void setUp() throws Exception {
		this.test = new TestDaoMem();
	}

	@Test
	void setNameTest() {
		String name = "test-name";
		this.test.setName(name);
		assertEquals(this.test.getName(), name);
	}
	
	@Test
	void setDescriptionTest() {
		String description = "test description";
		this.test.setDescription(description);
		assertEquals(this.test.getDescription(), description);
	}
	
	@Test
	void setIdTest() {
		long id = 10;
		this.test.setId(id);
		assertEquals(this.test.getId(), id);
	}
	
	@Test
	void getResultTest() {
		TestDao newTest = new TestDaoMem("jump", "move from the floor", 10);
		assertEquals(newTest.getResult().getClass(), new TestResultDaoMem().getClass());
	}
	
	@Test
	void getTitleTest() {
		this.test.setTitle("test");
		String title = this.test.getTitle();
		assertTrue(title != null);
		assertTrue(title.getClass().getName() == title.getClass().getName());
	}
	
	@Test
	void setTitleTest() {
		String newTitle = "NewTit";
		this.test.setTitle(newTitle);
		assertEquals(this.test.getTitle(), newTitle);
	}

}
