package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface DaoFactory {
    public ModelDao getModel();
    public StoreDao<SystemDao> getSystemsStore();
    
    public void initTest(SystemDao sut);
    public void initSystem();
    public void initProtocol(SystemDao sut);
}