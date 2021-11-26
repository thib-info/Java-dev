package fr.uha.ensisa.gl2122_minimale_project.mantest.TestDao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.DaoFactoryMem;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.ModelDaoMem;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.SystemDaoMem;

class DaoFactoryMemTest {

	 private DaoFactory factory;

	    @BeforeEach
	    public void setUp() throws Exception {
	        this.factory = new DaoFactoryMem();
	    }

	    @Test
	    void getModelTest() {
	        assertEquals(this.factory.getModel().getClass(), new ModelDaoMem().getClass());
	    }
	    
	    @Test
	    void getSystemTest() {
	        SystemDao sut = this.factory.getSystem();
	        SystemDao sutTest = new SystemDaoMem("BRAS ROBOTIQUE", "Un bras permetant de se mouvoir dans l'espace", 1);
	        
	        assertEquals(this.factory.getSystem().getClass(), sutTest.getClass());
	        assertEquals(sut.getTitle(), sutTest.getTitle());
	        assertEquals(sut.getDescription(), sutTest.getDescription());
	        assertEquals(sut.getId(), sutTest.getId());
	    }

	}
