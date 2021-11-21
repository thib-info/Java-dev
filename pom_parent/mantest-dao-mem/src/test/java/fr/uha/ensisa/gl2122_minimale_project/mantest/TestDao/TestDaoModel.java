package fr.uha.ensisa.gl2122_minimale_project.mantest.TestDao;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.DaoModel;

public class TestDaoModel {

	private DaoModel sut;
	
	@BeforeEach
	private void createModel() {
		this.sut = new DaoModel();
	}
	
	@Test
	public void testTitle() {
		String title = "test";
		this.sut.setTitle(title);
		assertEquals(title, this.sut.getTitle());
	}
	
	@Test void testDescription() {
		String descrip = "test";
		this.sut.setDescription(descrip);
		assertEquals(descrip, this.sut.getDescription());
	}
	
	@Test void testId() {
		long id = 5;
		this.sut.setId(id);
		assertEquals(id, this.sut.getId());
	}
	
	
}
