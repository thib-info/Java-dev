package fr.uha.ensisa.gl.minimale.mantest_app.MockingTest;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.DaoFactoryMem;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.StoreDaoMem;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.SystemDaoMem;
import fr.uha.ensisa.gl.minimale.mantest_app.controller.SystemUnitController;

class SystemUnitControllerTest {
	
	@Mock DaoFactory daoFactory;
	@Mock SystemDao system;
	@Mock StoreDao<SystemDao> storeSystem;
	@Mock List<SystemDao> listSystem;
	public SystemUnitController sut;
	
	
	@BeforeEach
	public void prepareDao() {
		MockitoAnnotations.initMocks(this);
		when(system.getTitle()).thenReturn("DefaultSystem");
		when(daoFactory.getSystemsStore()).thenReturn(this.storeSystem);
		when(daoFactory.getSystemsStore().getStore()).thenReturn(this.listSystem);
		when(daoFactory.getSystemsStore().getStore().get(0)).thenReturn(this.system);
		//sut = new SystemUnitController();
		//sut.factory = this.daoFactory;
	}
	
	@Test
	public void testNameSys() throws IOException {
		assertEquals(system.getTitle(), "DefaultSystem");
		assertEquals(daoFactory.getSystemsStore().getStore().get(0).getTitle(), "DefaultSystem");
	}

	/*
	@Test
	public void printTestsList() throws IOException {
		ModelAndView ret = sut.systemUnitPresentation(0);
		Collection<fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao> tests = (Collection<fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao>) ret.getModelMap().get("tab-tests");
		assertNotNull(tests);
		assertTrue(tests.isEmpty());
	}
	*/
}
