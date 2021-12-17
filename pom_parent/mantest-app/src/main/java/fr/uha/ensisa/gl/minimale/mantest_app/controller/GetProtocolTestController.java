package fr.uha.ensisa.gl.minimale.mantest_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.ProtocolDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.StoreDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;

@Controller
public class GetProtocolTestController {
	
	@Autowired
	public DaoFactory factory;
	
	@ResponseBody
	@RequestMapping(value="/getProtocolTests")
	public StoreDao<TestDao> getTests(@RequestParam(required=true) int idSystem, @RequestParam(required=true) int idProtocol) {
		SystemDao sys = (SystemDao) this.factory.getSystemsStore().getItem((long) idSystem);
		ProtocolDao prot = sys.getStoreProtocol().getItem((long) idProtocol);
		
		return prot.getTests();
	}
	
}
