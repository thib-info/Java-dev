package fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao;

public interface Test extends Model {
    public void addSession(Session session);
    public void addStep(Step step);
    

    public void removeStep(long id);


    public void modifyStep(long id, Step step);

    public Session getSession(long id);
    public Step getStep(long id);

    public Store<Session> allSessions();
    public Store<Step> allSteps();

    public long countSessions();
    public long countSteps();
    
}