package it.sopra.stage.fullmoda.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoreLocatorController {

	@RequestMapping(value= {"/store"}, method=RequestMethod.GET)
	public String showHomePage(Model model){
		return "store";
	}
}
