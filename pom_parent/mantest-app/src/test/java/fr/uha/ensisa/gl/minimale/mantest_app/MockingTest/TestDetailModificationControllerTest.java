package fr.uha.ensisa.gl.minimale.mantest_app.MockingTest;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.web.servlet.ModelAndView;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import fr.uha.ensisa.gl.minimale.mantest_app.controller.TestDetailModificationController;




public class TestDetailModificationControllerTest {

	@Mock DaoFactory daoFactory;
	@Mock SystemDao system;
	@Mock StoreDao<SystemDao> storeSystem;
	@Mock List<SystemDao> listSystem;
	@Mock StoreDao<TestDao> storeTest;
	@Mock List<TestDao> listTest;
	@Mock TestDao testDao;


	public TestDetailModificationController sut;

	private String title;
	private String description;
	
	private String new_title;
	private String new_desc;
	
	private long id;


	@BeforeEach
	public void prepareDao() {
		MockitoAnnotations.openMocks(this);
		
		this.id = 0;
		
		when(daoFactory.getSystemsStore()).thenReturn(this.storeSystem);
		when(daoFactory.getSystemsStore().getStore()).thenReturn(this.listSystem);
		when(daoFactory.getSystemsStore().getStore().get(0)).thenReturn(this.system);
		
		
		sut = new TestDetailModificationController();
		sut.factory = this.daoFactory;

		when(system.getId()).thenReturn((long)0);
		when(system.getTitle()).thenReturn("SystemSimulated");
		when(system.getDescription()).thenReturn("A mockito system");
		
		when(this.system.getStoreTest()).thenReturn(storeTest);
		when(this.storeTest.getStore()).thenReturn(listTest);
		
		
		when(listTest.get((int)id)).thenReturn(testDao);
		
		new_title = "new_title";
		new_desc = "new_description";

		
		when(testDao.getId()).thenReturn(id);
		when(testDao.getName()).thenReturn(title);
		when(testDao.getDescription()).thenReturn(description);

	}



	@Test
	public void showTestDetails() throws IOException {
		ModelAndView ret = sut.definitivelyNotsystemUnitPresentation(0, id, "", "");
		assertEquals(ret.getModelMap().get("idSystem"), (long) 0);
		assertEquals(ret.getModelMap().get("syst_title"), "SystemSimulated");
		
		assertEquals(ret.getModelMap().get("title"), title);
		assertEquals(ret.getModelMap().get("description"), description);
		
		verify(testDao, never()).setName(anyString());
		verify(testDao, never()).setDescription(anyString());
	}
	
	@Test
	public void modifyTest() throws IOException {
		ModelAndView ret = sut.definitivelyNotsystemUnitPresentation(0, id, new_title, new_desc);
		verify(testDao).setName(new_title);
		verify(testDao).setDescription(new_desc);
	}

	



}


















