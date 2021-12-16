package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.ProtocolDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;

public class ProtocolDaoMem extends ModelDaoMem implements ProtocolDao {
	
	private String category;
	private int status;
	private StoreDao<TestDao> tests;
	private int nbrTest;
	
	public ProtocolDaoMem() {
		this.category = "Default";
		this.status = 0;
		this.tests = new StoreDaoMem<TestDao>();
		this.nbrTest = 0;
	}
	
	public ProtocolDaoMem(String name, String type) {
		this.setTitle(name);
		this.category = type;
		this.status = 0;
		this.tests = new StoreDaoMem<TestDao>();
		this.nbrTest = 0;
	}
	
	@Override
	public void addTest(TestDao test) {
		this.tests.save(test);
		this.nbrTest++;
	}
	
	@Override
	public void removeTest(long id) {
		this.tests.remove(this.tests.getItem(id));
		this.nbrTest--;
	}
	
	@Override
	public StoreDao<TestDao> getTests(){
		return this.tests;
	}
	
	public int getNbrTest() {
		return this.nbrTest;
	}
	
	@Override
	public void setCategory(String type) {
		this.category = type;
	}
	
	@Override
	public String getCategory() {
		return this.category;
	}
	
	@Override
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public int getStatus() {
		return this.status;
	}
	
	
}
