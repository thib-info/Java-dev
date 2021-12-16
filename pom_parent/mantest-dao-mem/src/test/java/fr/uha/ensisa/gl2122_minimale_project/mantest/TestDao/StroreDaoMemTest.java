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
		TestDao test1 = new TestDaoMem("alerte", "one alert", 3);
		TestDao test2 = new TestDaoMem("alerte", "one alert", 4);
		TestDao test3 = new TestDaoMem("alerte", "one alert", 5);
		
		store.save(test1);
		store.save(test2);
		store.save(test3);
		assertEquals(this.store.count(), 3);
		
		this.store.remove(test3);
		
		assertEquals(this.store.count(), 2);
		assertTrue(this.store.getItem((long)3) == test1);
		assertTrue(this.store.getItem((long)4) == test2);
	}
	
	@Test
	void findTest() {
		TestDao test1 = new TestDaoMem("alerte", "one alert", 3);
		TestDao test2 = new TestDaoMem();
		
		this.store.save(test2);
		
		assertEquals(this.store.find(test2), test2);
		assertEquals(this.store.find(test1), null);
	}
	
	
	@Test
	void testGetItem() {
		TestDao test1 = new TestDaoMem("alerte", "one alert", 3);
		TestDao test2 = new TestDaoMem("alerte", "one alert", 4);
		TestDao test3 = new TestDaoMem("alerte", "one alert", 5);
		
		store.save(test1);
		store.save(test2);
		store.save(test3);
		
		this.store.getItem(test1.getId());
		
		assertEquals(this.store.getItem(test1.getId()), test1);
		assertEquals(this.store.getItem(test2.getId()), test2);
		assertEquals(this.store.getItem(test3.getId()), test3);
		assertEquals(this.store.getItem((long) 9), null);
	}
	
	@Test
	void testMaxId() {
		TestDao test1 = new TestDaoMem("alerte", "one alert", 9);
		TestDao test2 = new TestDaoMem("alerte", "one alert", 4);
		TestDao test3 = new TestDaoMem("alerte", "one alert", 5);
		
		store.save(test1);
		store.save(test2);
		store.save(test3);
		
		assertEquals(this.store.maxId(), (long) 9);
	}
	
	

}
