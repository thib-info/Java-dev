package fr.uha.ensisa.gl2122_minimale_project.mantest.TestDao;

import java.util.Map;
import java.util.TreeMap;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;

public class StoreDaoMem<Test> implements StoreDao<Object> {
	private final Map<Long, Test> store;

	public StoreDaoMem() {
		this.store = null;
	}

	@Override
	public void remove(long id){
		store.remove(id);
	}

	@Override
	public Test find(long id){
		return store.get(id);
	}

	@Override
	public long count() {
		return store.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void save(long id, Object obj) {
		// TODO Auto-generated method stub
		this.store.put(id, (Test) obj);
	}
}
