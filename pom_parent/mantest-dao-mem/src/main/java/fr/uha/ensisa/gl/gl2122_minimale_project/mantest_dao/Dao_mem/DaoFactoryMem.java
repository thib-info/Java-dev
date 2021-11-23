package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.*;

public class DaoFactoryMem implements DaoFactory {
	
	public ModelDao getModel() {
		ModelDao model = new ModelDaoMem();
		return model;
	}
}
