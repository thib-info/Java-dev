package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface SessionDao extends ModelDao {
 	public String getDate();
    public int getStatus();
    public void setFailed(long id);
    public long getFailed();
    public void setCommentary(String commentary);
    public String getCommentary();
}
