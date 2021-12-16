package fr.uha.ensisa.gl.minimale.mantest_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;


@Controller
public class RemoveTestController {
	@Autowired 
	public DaoFactory factory;
	
	@ResponseBody
	@RequestMapping(value="/removeTest")
	public void removeTest(@RequestParam(required=true) int idSystem, @RequestParam(required=true) long idTest) {
		SystemDao sus = this.factory.getSystemsStore().getItem(idSystem);
		TestDao currentTest = (TestDao) sus.getStoreTest().getItem(idTest);
		sus.getStoreTest().remove(currentTest);
	}
}
