package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;


import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SessionDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StepDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;

public class TestDaoMem extends ModelDaoMem implements TestDao {

	private StoreDaoMem<SessionDao> sessions;
    private StoreDaoMem<StepDao> steps;
	
    
    public TestDaoMem() {
    	this.sessions = new StoreDaoMem<SessionDao>();
    	this.steps = new StoreDaoMem<StepDao>();
    }
	@Override
	public void addSession(SessionDao session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStep(StepDao step) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStep(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyStep(long id, StepDao step) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SessionDao getSession(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StepDao getStep(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreDao<SessionDao> allSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoreDao<StepDao> allSteps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countSessions() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long countSteps() {
		// TODO Auto-generated method stub
		return 0;
	}

}
