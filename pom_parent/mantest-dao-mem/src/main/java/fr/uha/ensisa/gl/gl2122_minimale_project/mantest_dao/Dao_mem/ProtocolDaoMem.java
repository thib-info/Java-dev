package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.ProtocolDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;

public class ProtocolDaoMem extends ModelDaoMem implements ProtocolDao {
	
	private String category;
	private int status;
	private StoreDao<TestDao> tests;
	
	public ProtocolDaoMem() {
		this.category = "Default";
		this.status = 0;
		this.tests = new StoreDaoMem<TestDao>();
	}
	
	public ProtocolDaoMem(String name, String type) {
		this.setTitle(name);
		this.category = type;
		this.status = 0;
		this.tests = new StoreDaoMem<TestDao>();
	}
	
	@Override
	public void addTest(TestDao test) {
		this.tests.save(test);
	}
	
	@Override
	public void removeTest(long id) {
		this.tests.remove(this.tests.getItem(id));
	}
	
	@Override
	public StoreDao<TestDao> getTests(){
		return this.tests;
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
