package fr.uha.ensisa.gl.minimale.mantest_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
	
	
	@RequestMapping(value="/")
	public RedirectView redirectOnSystem() {
		return new RedirectView("system");
	}
}
