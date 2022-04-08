package fr.uha.ensisa.gl.minimale.mantest_app.MockingTest;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;
import fr.uha.ensisa.gl.minimale.mantest_app.controller.SystemUnitController;

class SystemUnitControllerTest {
	
	@Mock DaoFactory daoFactory;
	@Mock SystemDao system;
	@Mock StoreDao<SystemDao> storeSystem;
	@Mock StoreDao<TestDao> storeTest;
	public SystemUnitController sut;
	
	
	@BeforeEach
	public void prepareDao() {
		MockitoAnnotations.openMocks(this);
		when(daoFactory.getSystemsStore()).thenReturn(this.storeSystem);
		when(daoFactory.getSystemsStore().getItem((long)0)).thenReturn(this.system);
		sut = new SystemUnitController();
		sut.factory = this.daoFactory;
	}
	
	@BeforeEach
	public void initSystem() {
		when(this.system.getTitle()).thenReturn("DefaultSystem");
		when(this.system.getDescription()).thenReturn("Default description");
		when(this.system.getId()).thenReturn((long) 0);
	}
	
	@BeforeEach
	public void initTestList() {
		when(this.system.getStoreTest()).thenReturn(storeTest);
	}
	
	@Test
	public void sysCaractTest() throws IOException {
		assertEquals(this.system.getTitle(), "DefaultSystem");
		assertEquals(system.getDescription(), "Default description");
		assertEquals(system.getId(), 0);
		
		assertEquals(this.system, this.daoFactory.getSystemsStore().getItem((long)0));
	}

	/*
	@Test
	public void emptyTestsList() throws IOException {
		ModelAndView ret = sut.systemUnitPresentation(0);
		List<TestDao> tests = (List<TestDao>) ret.getModelMap().get("storeTest"); 
		assertNotNull(tests);
		assertTrue(tests.size() == 0);
	}*/
}
