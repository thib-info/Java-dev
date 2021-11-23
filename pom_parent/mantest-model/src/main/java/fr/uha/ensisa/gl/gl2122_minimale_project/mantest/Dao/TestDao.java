package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface TestDao extends Model {
    public void addSession(SessionDao session);
    public void addStep(StepDao step);
    

    public void removeStep(long id);


    public void modifyStep(long id, StepDao step);

    public SessionDao getSession(long id);
    public StepDao getStep(long id);

    public StoreDao<SessionDao> allSessions();
    public StoreDao<StepDao> allSteps();

    public long countSessions();
    public long countSteps();
    
}