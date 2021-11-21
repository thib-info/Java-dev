package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface Model {

    public void setTitle(String title);
    public void setDescription(String description);
    public String getTitle();
    public String getDescription();
    public long getId();
    public void setId(long id);
}