package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;


import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.Store;

public class DaoStore<T> implements Store<T> {
    private final Map<Long, T> store = Collections.synchronizedMap(new TreeMap<Long, T>());

    @Override
    public void save(long id, T obj) {
        store.put(id, obj);
    } 

    @Override
    public void remove(long id){
        store.remove(id);
    }

    @Override
    public T find(long id){
        return store.get(id);
    }

    @Override
    public Collection<T> findAll(){
        return store.values();
    }

    @Override
    public long count() {
        return store.size();
    }

}
