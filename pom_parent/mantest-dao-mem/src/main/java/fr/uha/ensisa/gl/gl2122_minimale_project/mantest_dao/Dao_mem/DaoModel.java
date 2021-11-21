package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.Model	;

public class DaoModel implements Model {
	private long id;
    private String title;
    private String description;
    
    public DaoModel() {
    	
    }

    @Override
    public void setTitle(String title){
        this.title = title;
    }
    
    @Override
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String getTitle(){ 
        return this.title;
    }

    @Override
    public String getDescription(){ 
        return this.description;
    }
    
    @Override
    public long getId() {
    	return this.id;
    }
    
    @Override
    public void setId(long id) {
    	this.id = id;
    }
}
