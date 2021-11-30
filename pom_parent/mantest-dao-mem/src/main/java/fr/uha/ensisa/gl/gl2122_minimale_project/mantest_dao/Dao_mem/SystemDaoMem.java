package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;

public class SystemDaoMem extends ModelDaoMem implements SystemDao {

	private StoreDao<TestDao> storeTest;
	
    public SystemDaoMem(){
        setTitle("DefaultSystem");
        setDescription("Only implement a default System");
        setId(0);
        
        this.storeTest = new StoreDaoMem<TestDao>();
    }
    
    public SystemDaoMem(String title, String description, long id) {
        setTitle(title);
        setDescription(description);
        setId(id);
        
        this.storeTest = new StoreDaoMem<TestDao>();
    }

	@Override
	public StoreDao<TestDao> getStoreTest() {
		return this.storeTest;
	}

}
