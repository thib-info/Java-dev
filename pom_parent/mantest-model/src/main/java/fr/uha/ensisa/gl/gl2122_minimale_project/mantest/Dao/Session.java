package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface Session extends Model {
 	public String getDate();
    public void setStatus(int status);
    public int getStatus();
    public void setFailed(long id);
    public long getFailed();
    public void setCommentary(String commentary);
    public String getCommentary();
}
