package fr.uha.ensisa.gl.minimale.mantest_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest_dao.Dao_mem.TestDaoMem;


@Controller
public class AddTestController {
	
	@Autowired
	public DaoFactory factory;
	
	@ResponseBody
	@RequestMapping(value="/addTest")
	public void addTest(@RequestParam(required=true) long idSystem, @RequestParam(required=true) String titleTest, @RequestParam(required=true) String descriptionTest) {
		SystemDao sus = this.factory.getSystemsStore().getItem(idSystem);
		long idNewTest = sus.getStoreTest().maxId();
		TestDao newTest = new TestDaoMem(titleTest, descriptionTest, (long)idNewTest);
		sus.getStoreTest().save(newTest);
	}
	
}
