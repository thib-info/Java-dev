package fr.uha.ensisa.gl.minimale.mantest_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.DaoFactory;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.SystemDao;
import fr.uha.ensisa.gl.gl2122_minimale_project.mantest.Dao.TestDao;

@Controller
public class TestDetailModificationController {
	
	@Autowired
	public DaoFactory factory;
	
	@RequestMapping(value="/Test",  method = RequestMethod.POST)
	public ModelAndView definitivelyNotsystemUnitPresentation(@RequestParam(required=true) long idSystem, @RequestParam(required=true) long idTest, @RequestParam(required=false,defaultValue="") String titleTest, @RequestParam(required=false,defaultValue="") String descriptionTest) {
		ModelAndView ret = new ModelAndView("testUnitPresentation");
		
		
		SystemDao syst = this.factory.getSystemsStore().getItem(idSystem);
		TestDao tus = syst.getStoreTest().getItem( idTest);
		
		if (titleTest != "" && descriptionTest != "") {
			tus.setName(titleTest);
			tus.setDescription(descriptionTest);
		}
		
		ret.addObject("idSystem", idSystem);
		ret.addObject("idTest", idTest);
		ret.addObject("syst_title", syst.getTitle());
		ret.addObject("title", tus.getName());
		ret.addObject("description", tus.getDescription());
		
		return ret;
	}

}
