package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;


import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.Session;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.Step;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.Store;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.Test;

public class DaoTest extends DaoModel implements Test {

	private DaoStore<Session> sessions;
    private DaoStore<Step> steps;
	
    
    public DaoTest() {
    	this.sessions = new DaoStore<Session>();
    	this.steps = new DaoStore<Step>();
    }
	@Override
	public void addSession(Session session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addStep(Step step) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeStep(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyStep(long id, Step step) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Session getSession(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Step getStep(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store<Session> allSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store<Step> allSteps() {
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
