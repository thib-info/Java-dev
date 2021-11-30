package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface DaoFactory {
    public ModelDao getModel(); 
    public SystemDao getSystem();
    
    public void initTest(SystemDao sut);
}