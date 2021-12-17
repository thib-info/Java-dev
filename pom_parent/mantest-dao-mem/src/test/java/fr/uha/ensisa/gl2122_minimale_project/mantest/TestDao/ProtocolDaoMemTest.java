package fr.uha.ensisa.gl2122_minimale_project.mantest.TestDao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.ProtocolDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.ProtocolDaoMem;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.StoreDaoMem;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.TestDaoMem;

class ProtocolDaoMemTest {
	
	private ProtocolDao prot;
	private ProtocolDao prot2;

	@BeforeEach
	void setUp() {
		this.prot = new ProtocolDaoMem();
	}
		
	@Test
	void initialDefaultCaracteristicsTest() {
		String category = "Default";
		int status = 0;
		int nbrTest = 0;
		StoreDao<TestDao> testsList = new StoreDaoMem<TestDao>();
		assertEquals(this.prot.getCategory(), category);
		assertEquals(this.prot.getStatus(), status);
		assertEquals(this.prot.getNbrTest(), nbrTest);
		assertTrue(this.prot.getTests().getClass() == testsList.getClass());
	}
	
	@Test
	void initialComplexCaracteristicTest() {
		String category = "Default";
		String title = "Robotic";
		int status = 0;
		int nbrTest = 0;
		int id=1;
		this.prot2 = new ProtocolDaoMem(title, category, id);
		
		assertEquals(this.prot2.getCategory(), category);
		assertEquals(this.prot2.getStatus(), status);
		assertEquals(this.prot2.getNbrTest(), nbrTest);
		assertEquals(this.prot2.getTitle(), title);
		assertTrue(this.prot2.getTests() != null);
	}
	
	@Test
	void removeTestProtocolTest() {
		assertEquals(this.prot.getTests().count(), 0);
		TestDao test = new TestDaoMem();
		this.prot.addTest(test);
		assertEquals(this.prot.getTests().count(), 1);
		this.prot.removeTest(test.getId());
		assertEquals(this.prot.getTests().count(), 0);
	}
	
	@Test
	void setCategoryTest() {
		String newCat = "NewCat";
		this.prot.setCategory(newCat);
		assertEquals(this.prot.getCategory(), newCat);
	}
	
	@Test
	void setStautsTest() {
		int newStat = 1;
		this.prot.setStatus(newStat);
		assertEquals(this.prot.getStatus(), newStat);
	}

}
