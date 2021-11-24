package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.*;

public class DaoFactoryMem implements DaoFactory {
	
	public ModelDao getModel() {
		ModelDao model = new ModelDaoMem();
		return model;
	}
	
	public SystemDao getSystem() {
		String title = "BRAS ROBOTIQUE";
		String description = "Un bras permetant de se mouvoir dans l'espace";
		long id = 1;
		
		SystemDao sys = new SystemDaoMem(title, description, id);
		return sys;
	}
	
}
