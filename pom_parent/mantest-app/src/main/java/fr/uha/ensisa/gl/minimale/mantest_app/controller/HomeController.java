package fr.uha.ensisa.gl.minimale.mantest_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;

@Controller
public class HomeController {
	
	@Autowired
	public DaoFactory factory;

	@RequestMapping(value="/hello")
	public ModelAndView hello(@RequestParam(required=false, defaultValue="World") String name) {
		ModelAndView ret = new ModelAndView("home");
		// Adds an objet to be used in home.jsp
		ret.addObject("name", name);
		
		SystemDao sus = this.factory.getSystemsStore().getStore().get(0);
		ret.addObject("title", sus.getTitle());
		
		return ret;
	}
}
