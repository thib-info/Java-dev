package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import java.util.ArrayList;
import java.util.List;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.*;

public class StoreDaoMem<T> implements StoreDao<T> {
	private List<T> store;
	
	public StoreDaoMem(){
		this.store = new ArrayList<T>();
	}

	@Override
	public void save(T obj) {
		this.store.add(obj);
	}

	@Override
	public void remove(T obj) {
		this.store.remove(obj);
	}

	@Override
	public T find(T obj) {
		// TODO Auto-generated method stub
		int index = this.store.indexOf(obj);
		
		if(index >= 0)
			return this.store.get(index);
		else
			return null;
	}

	@Override
	public int count() {
		return this.store.size();
	}
	
	@Override
	public List<T> getStore(){
		return this.store;
	}
	
	@Override
	public T getItem(long id) {
		for (T obj : getStore()) {
			if (((ModelDaoMem)obj).getId() == id) return obj;
		}
		return null;
	}

	@Override
	public long maxId() {
		long id_t = 0;
		for (T obj : getStore()) {
			if (id_t < ((ModelDaoMem)obj).getId() ) id_t = ((ModelDaoMem)obj).getId();
		}
		return id_t;
	}
	
}
