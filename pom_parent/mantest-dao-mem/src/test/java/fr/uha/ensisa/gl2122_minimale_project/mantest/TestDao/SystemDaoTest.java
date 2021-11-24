package fr.uha.ensisa.gl2122_minimale_project.mantest.TestDao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.SystemDaoMem;

class SystemDaoTest {
	
	private SystemDao sut;
	private SystemDao sut2;

	@BeforeEach
	void setUp() throws Exception {
		this.sut = new SystemDaoMem();
	}
	

	@Test
	public void defaultImplementation() {
		String defaultTitle = "DefaultSystem";
		String defaultDescription = "Only implement a default "
				+ "System";
		long defaultID = 0;
		assertEquals(defaultTitle, this.sut.getTitle());
		assertEquals(defaultDescription, this.sut.getDescription());
		assertEquals(defaultID, this.sut.getId());
	}
	
	@Test
	public void parametersImplementation() {
		String title = "porte";
		String description = "Permet d'ouvrir l'accès à un espace";
		long id = 0;
		this.sut2 = new SystemDaoMem(title, description, id);
		assertEquals(title, this.sut2.getTitle());
		assertEquals(description, this.sut2.getDescription());
		assertEquals(id, this.sut2.getId());
	}
	

}
