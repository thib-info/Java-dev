package fr.uha.ensisa.gl2122_minimale_project.mantest.TestDao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.StoreDaoMem;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.TestDaoMem;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.*;

class StroreDaoMemTest {
	
	private static final String TestDao = null;
	private StoreDao<Object> store;

	@BeforeEach
	void setUp() throws Exception {
		this.store = new StoreDaoMem<Object>();
	}

	@Test
	void removeTest() {
		this.store.save(1);
		this.store.save(5);
		this.store.save(3);
		
		assertEquals(this.store.count(), 3);
		
		this.store.remove(5);
		
		assertEquals(this.store.count(), 2);
		assertTrue(this.store.getStore().get(0) == (Object) 1);
		assertTrue(this.store.getStore().get(1) == (Object) 3);
	}
	
	@Test
	void findTest() {
		TestDao test1 = new TestDaoMem("alerte", "one alert", 3);
		TestDao test2 = new TestDaoMem();
		
		this.store.save(test2);
		
		assertEquals(this.store.find(test2), test2);
		assertEquals(this.store.find(test1), null);
	}

}
