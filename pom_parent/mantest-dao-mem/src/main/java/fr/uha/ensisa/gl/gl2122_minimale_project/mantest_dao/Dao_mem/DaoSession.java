package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.Session;

public class DaoSession extends DaoModel implements Session {
	private String date;
    private int status;
    private long failed;
    private String commentary;

    public DaoSession() {
        this.date = "now";
        this.status = 0;
        this.failed = -1;
    }

    @Override
    public String getDate() {
        return this.date;
    }


    private void setStatus(int status){
        this.status = status;
        if (this.status >= 0) this.commentary = null;
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public void setFailed(long id){
    	
    	if (id < 0) {
    		this.setStatus(1);
    	}
    	else {
    		this.setStatus(-1);
    	}
    	
        this.failed = id;
    	
    }

    @Override
    public long getFailed() {
        return this.failed;
    }

    @Override
    public void setCommentary(String commentary){
    	if (this.getStatus() < 0) this.commentary = commentary;
    }

    @Override
    public String getCommentary() {
        return this.commentary;
    }
}
