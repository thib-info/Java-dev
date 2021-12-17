package fr.uha.ensisa.gl.minimale.mantest_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.ProtocolDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.ProtocolDaoMem;

@Controller
public class AddProtocolController {

	@Autowired
	public DaoFactory factory;
	
	@ResponseBody
	@RequestMapping(value="/addProtocol")
	public void addProtocol(@RequestParam(required=true) long idSystem, @RequestParam(required=true) String titleProtocol, @RequestParam(required=true) String descriptionProtocol) {
		SystemDao sus = this.factory.getSystemsStore().getItem(idSystem);
		long idNewProtocol = sus.getStoreProtocol().maxId();
		ProtocolDao newProtocol = new ProtocolDaoMem(titleProtocol, descriptionProtocol, idNewProtocol);
		sus.getStoreProtocol().save(newProtocol);
	}
}
