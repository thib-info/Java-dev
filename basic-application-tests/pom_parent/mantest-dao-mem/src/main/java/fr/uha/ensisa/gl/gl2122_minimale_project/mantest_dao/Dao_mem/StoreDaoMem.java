package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import java.util.ArrayList;
import java.util.List;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.*;

public class StoreDaoMem<T> implements StoreDao<T> {
	private List<ModelDao> store;
	
	public StoreDaoMem(){
		this.store = new ArrayList<ModelDao>();
	}

	@Override
	public void save(T obj) {
		this.store.add((ModelDao)obj);
	}

	@Override
	public void remove(T obj) {
		this.store.remove((ModelDao)obj);
	}

	@Override
	public T find(T obj) {
		// TODO Auto-generated method stub
		int index = this.store.indexOf((ModelDao)obj);
		
		if(index >= 0)
			return (T)this.store.get(index);
		else
			return null;
	}

	@Override
	public int count() {
		return this.store.size();
	}
	
	@Override
	public List<ModelDao> getStore(){
		return  this.store;
	}
	
	
	@Override
	public T getItem(long id) {
		for (ModelDao obj : getStore()) {
			if (obj.getId() == id) return (T)obj;
		}
		return null;
	}

	@Override
	public long maxId() {
		long id_t = 0;
		for (ModelDao obj : getStore()) {
			if (id_t < obj.getId()) {
				id_t = obj.getId();
			}
		}
		return id_t;
	}
	
}
