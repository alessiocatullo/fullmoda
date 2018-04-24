package it.sopra.stage.fullmoda.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.form.LoginForm;

@Controller
public class MyAccountController {

	private static final Logger LOG = Logger.getLogger(MyAccountController.class);
	
	@RequestMapping(value="/my-account", method = RequestMethod.GET)
	public String showMyAccountPage(Model model, HttpServletRequest request){
		
		/** so trivial... :) */
		UserData user = (UserData)request.getSession().getAttribute("user");
		if(user == null) {
			LOG.debug("User not logged - Redirect to home");
			model.addAttribute("loginForm", new LoginForm());
			return "login";
		}
		model.addAttribute("user", user);
		return "my-account";
	}
}
