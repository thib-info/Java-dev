package fr.uha.ensisa.gl.minimale.mantest_app.MockingTest;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
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
import fr.uha.ensisa.gl.minimale.mantest_app.controller.AddTestController;
import fr.uha.ensisa.gl.minimale.mantest_app.controller.SystemUnitController;

class AddTestControllerTest {

	@Mock DaoFactory daoFactory;
	@Mock SystemDao system;
	@Mock StoreDao<SystemDao> storeSystem;
	@Mock List<SystemDao> listSystem;
	@Mock StoreDao<TestDao> storeTest;
	@Mock List<TestDao> listTest;
	public AddTestController sut;
	String titleTest;

	@BeforeEach
	public void prepareDao() {
		MockitoAnnotations.openMocks(this);
		this.titleTest = "Test1";
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
	}

	@BeforeEach
	public void initController() {
		sut = new AddTestController();
		sut.factory = this.daoFactory;
	}
	
	@Test
	public void createTest() throws IOException {
		sut.addTest(0, this.titleTest, null);
		assertEquals("1","1");
		verify(this.storeTest).save(any(fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao.class));
	}
	
}
