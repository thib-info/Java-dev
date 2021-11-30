package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.ModelDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;

public class DaoFactoryMem implements DaoFactory {
    
    public ModelDao getModel() {
        ModelDao model = new ModelDaoMem();
        return model;
    }
    
    public SystemDao getSystem() {
        String title = "BRAS ROBOTIQUE";
        String description = "Un bras permetant de se mouvoir dans l'espace";
        long id = 1;
        
        SystemDao sut = new SystemDaoMem(title, description, id);
        this.initTest(sut);
        
        
        
        return sut;
    }

	@Override
	public void initTest(SystemDao sut) {
		TestDao moveTest = new TestDaoMem("Move", "Check if the system can move", 0);
		TestDao stopTest = new TestDaoMem("Stop", "Check if the system can stop", 1);
		
		sut.getStoreTest().save(moveTest);
		sut.getStoreTest().save(stopTest);
	}
    
}