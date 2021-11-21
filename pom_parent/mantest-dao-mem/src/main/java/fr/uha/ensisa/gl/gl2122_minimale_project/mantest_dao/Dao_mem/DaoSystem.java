package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.Test;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.Store;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.System;

public class DaoSystem extends DaoModel implements System {
	
    public DaoStore<Test> protocols;

    public DaoSystem(){
        this.protocols = new DaoStore<Test>();
    }

	@Override
	public void addTest(Test test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTest(Test test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyTest(long id, Test test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Test getTest(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Store<Test> allTest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countTest() {
		// TODO Auto-generated method stub
		return 0;
	}
}