package fr.uha.ensisa.gl.minimale.mantest_app.MockingTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestResultDao;
import fr.uha.ensisa.gl.minimale.mantest_app.controller.RapportTestController;

class RapportTestControllerTest {
	
	@Mock DaoFactory daoFactory;
	@Mock SystemDao system;
	@Mock StoreDao<SystemDao> storeSystem;
	@Mock List<SystemDao> listSystem;
	@Mock StoreDao<TestDao> storeTest;
	@Mock List<TestDao> listTest;
	@Mock TestDao test;
	@Mock TestResultDao resTest;
	public RapportTestController sut;

	@BeforeEach
	public void prepareDao() {
		MockitoAnnotations.openMocks(this);
	}
	
	@BeforeEach
	public void initSystems() {		
		when(daoFactory.getSystemsStore()).thenReturn(this.storeSystem);
		when(daoFactory.getSystemsStore().getStore()).thenReturn(this.listSystem);
		when(daoFactory.getSystemsStore().getStore().get(0)).thenReturn(this.system);
	}
	
	@BeforeEach
	public void initTest() {
		when(this.system.getStoreTest()).thenReturn(storeTest);
		when(this.storeTest.getStore()).thenReturn(listTest);
		when(this.listTest.get(0)).thenReturn(test);
		when(this.test.getResult()).thenReturn(resTest);
	}
	
	@BeforeEach
	public void initController() {
		sut = new RapportTestController();
		sut.factory = this.daoFactory;
	}

	@Test
	public void getRapportTest() {
		ModelAndView ret = sut.rapportTestPresentation(0, 0);
		TestResultDao resultTest = (TestResultDao) ret.getModelMap().get("result");
		assertNotNull(resultTest);
		assertTrue(resultTest.getClass().getName() == this.resTest.getClass().getName());
	}

}
