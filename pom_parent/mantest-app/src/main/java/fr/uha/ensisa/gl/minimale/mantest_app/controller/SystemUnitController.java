package fr.uha.ensisa.gl.minimale.mantest_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;

@Controller
public class SystemUnitController {
	
	@Autowired
	public DaoFactory factory;

	@RequestMapping(value="/system")
	public ModelAndView systemUnitPresentation(@RequestParam(required=false, defaultValue="0") long idSys) {
		ModelAndView ret = new ModelAndView("systemUnitPresentation");
		
		SystemDao sus = this.factory.getSystemsStore().getItem(idSys);
		ret.addObject("title", sus.getTitle());
		ret.addObject("description", sus.getDescription());
		ret.addObject("id", sus.getId());
		
		ret.addObject("nbrTest", sus.getStoreTest().count());
		ret.addObject("storeTest", sus.getStoreTest().getStore());
		
		return ret;
	}
}
