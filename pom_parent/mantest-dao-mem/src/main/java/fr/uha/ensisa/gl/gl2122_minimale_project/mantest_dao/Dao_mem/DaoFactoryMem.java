package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.ModelDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.ProtocolDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;

public class DaoFactoryMem implements DaoFactory {
	
	private StoreDao<SystemDao> systemStore;
	
	public DaoFactoryMem() {
		this.systemStore = new StoreDaoMem<SystemDao>(); 
	}
    
    public ModelDao getModel() {
        ModelDao model = new ModelDaoMem();
        return model;
    }
    
    public StoreDao<SystemDao> getSystemsStore(){
    	if(this.systemStore.count() == 0)
    		initSystem();
    		
    	return this.systemStore;
    }
    
    public void initSystem() {
        String title = "BRAS ROBOTIQUE";
        String description = "Un bras permetant de se mouvoir dans l'espace";
        long id = 0;
        
        SystemDao sut = new SystemDaoMem(title, description, id);
        this.initTest(sut);
        this.initProtocol(sut);
        this.systemStore.save(sut);
    }

	@Override
	public void initTest(SystemDao sut) {
		TestDao moveTest = new TestDaoMem("Move", "Check if the system can move", 0);
		TestDao stopTest = new TestDaoMem("Stop", "Check if the system can stop", 1);
		
		sut.getStoreTest().save(moveTest);
		sut.getStoreTest().save(stopTest);
	}
	
	@Override
	public void initProtocol(SystemDao sut) {
		TestDao turnOnPowerTest = new TestDaoMem("Turn On Power", "Check if the power is enable", 2);
		ProtocolDao protocol = new ProtocolDaoMem("Tests électriques", "Electronique");
		protocol.addTest(turnOnPowerTest);
		sut.getStoreProtocol().save(protocol);
	}
    
}