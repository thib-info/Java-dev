package fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;

public class SystemDaoMem extends ModelDaoMem implements SystemDao {

    public SystemDaoMem(){
        setTitle("DefaultSystem");
        setDescription("Only implement a default System");
        setId(0);
    }
    
    public SystemDaoMem(String title, String description, long id) {
        setTitle(title);
        setDescription(description);
        setId(id);
    }

}
