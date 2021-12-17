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
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.ProtocolDaoMem;

@Controller
public class ProtocolController {

	@Autowired
	public DaoFactory factory;
	
	@ResponseBody
	@RequestMapping(value="/addProtocol")
	public void addProtocol(@RequestParam(required=true) long idSystem, @RequestParam(required=true) String titleProtocol, @RequestParam(required=true) String descriptionProtocol) {
		SystemDao sus = this.factory.getSystemsStore().getItem(idSystem);
		long idNewProtocol = sus.getStoreProtocol().maxId() + 1;
		ProtocolDao newProtocol = new ProtocolDaoMem(titleProtocol, descriptionProtocol, idNewProtocol);
		sus.getStoreProtocol().save(newProtocol);
	}
	
	@ResponseBody
	@RequestMapping(value="/removeProtocol")
	public void removeProtocol(@RequestParam(required=true) long idSystem, @RequestParam(required=true) long idProtocol) {
		SystemDao sus = this.factory.getSystemsStore().getItem(idSystem);
		sus.getStoreProtocol().remove(sus.getStoreProtocol().getItem(idProtocol));
	}
	
	@ResponseBody
	@RequestMapping(value="/addTestToProtocol")
	public void addTestTpProtocol(@RequestParam(required=true) long idSystem, @RequestParam(required=true) long idProtocol, @RequestParam(required=true) long idTest) {
		SystemDao sus = this.factory.getSystemsStore().getItem(idSystem);
		sus.getStoreProtocol().getItem(idProtocol).addTest(sus.getStoreTest().getItem(idTest));
	}
	
	@ResponseBody
	@RequestMapping(value="/getAllTestsSystem")
	public StoreDao<TestDao> getAllTestsSystem(@RequestParam(required=true) long idSystem, @RequestParam(value="0", required=false) Object idProt) {
		SystemDao sus = this.factory.getSystemsStore().getItem(idSystem);
		return sus.getStoreTest();
	}
}
