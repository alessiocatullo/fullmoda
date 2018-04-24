package it.sopra.stage.fullmoda.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.facade.AuthFacade;
import it.sopra.stage.fullmoda.form.LoginForm;

@Controller
public class LoginController {

	private static final Logger LOG = Logger.getLogger(LoginController.class);

	@Autowired
	private AuthFacade loginFacade;

	@Autowired
	private MessageSource messageSource;
 

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(Model model){
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, Model model, HttpServletRequest request){

		
		if (bindingResult.hasErrors()) {
			LOG.warn(String.format("Validation error on login page, found %s errors", bindingResult.getErrorCount()));
			return "login";
		}
		UserData userData = loginFacade.validateUser(loginForm.getEmail(), loginForm.getPassword());
		if (userData == null) {
			LOG.warn(String.format("User not found for parameters: email [%s], password [%s]", loginForm.getEmail(), loginForm.getPassword()));
			Locale currentLocale = LocaleContextHolder.getLocale();
			bindingResult.addError(new ObjectError("globalerrors", messageSource.getMessage("login.invalid.credentials",
					null, currentLocale)));
			return "login";
		}
		 model.addAttribute("user", userData);
		 request.getSession().setAttribute("user", userData);

		return "redirect:/products";
	}
	
}
