package it.sopra.stage.fullmoda.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.sopra.stage.fullmoda.dto.UserData;

@Controller
public class LogoutController {

	private static final Logger LOG = Logger.getLogger(LogoutController.class);
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String showLogoutPage(Model model, HttpServletRequest request){
		
		UserData user = (UserData)request.getSession().getAttribute("user");
		LOG.info("Logging out user "+user);
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("cart");
		return "redirect:/home";
	}
}
