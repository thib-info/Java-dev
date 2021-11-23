package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;

public class SystemDaoMem extends ModelDaoMem implements SystemDao {
	
    public StoreDaoMem<TestDao> protocols;

    public SystemDaoMem(){
        this.protocols = new StoreDaoMem<TestDao>();
    }

	@Override
	public void addTest(TestDao test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTest(TestDao test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyTest(long id, TestDao test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TestDao getTest(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreDao<TestDao> allTest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countTest() {
		// TODO Auto-generated method stub
		return 0;
	}
}