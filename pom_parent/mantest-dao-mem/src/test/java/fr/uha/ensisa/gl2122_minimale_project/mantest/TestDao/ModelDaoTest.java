package fr.uha.ensisa.gl2122_minimale_project.mantest.TestDao;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.ModelDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.ModelDaoMem;

class ModelDaoTest {

	private ModelDao sut;
	
	@BeforeEach
	private void createModel() {
		this.sut = new ModelDaoMem();
	}
	
	@Test
	public void testTitle() {
		String title = "test";
		this.sut.setTitle(title);
		assertEquals(title, this.sut.getTitle());
	}
	
	@Test 
	public void testDescription() {
		String descrip = "test";
		this.sut.setDescription(descrip);
		assertEquals(descrip, this.sut.getDescription());
	}
	
	@Test 
	public void testId() {
		long id = 5;
		this.sut.setId(id);
		assertEquals(id, this.sut.getId());
	}
	
}
