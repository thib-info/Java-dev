package fr.uha.ensisa.gl.minimale.mantest_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;

@Controller
public class RapportTestController {
	
	@Autowired
	public DaoFactory factory;

	
	@RequestMapping(value="/rapport")
	public ModelAndView rapportTestPresentation(@RequestParam(required=true) long idSystem, @RequestParam(required=true) long idTest) {
		ModelAndView ret = new ModelAndView("rapportTestPresentation");
		
		SystemDao sut = this.factory.getSystemsStore().getItem(idSystem);
		TestDao test = (TestDao) sut.getStoreTest().getItem(idTest);
		
		ret.addObject("test", test);
		ret.addObject("result", test.getResult());
		
		return ret;
	}
	
}
