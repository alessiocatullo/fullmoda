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
import org.springframework.web.bind.annotation.SessionAttributes;

import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.dto.UserTypeEnum;
import it.sopra.stage.fullmoda.exception.UserAlreadyRegistered;
import it.sopra.stage.fullmoda.facade.AuthFacade;
import it.sopra.stage.fullmoda.form.RegisterForm;

@SessionAttributes("user")
@Controller
public class RegisterController {

	private static final Logger LOG = Logger.getLogger(RegisterController.class);
	
	@Autowired
	private AuthFacade authFacade;
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String showRegisterPage(Model model){
		model.addAttribute("registerForm", new RegisterForm());
		return "register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("registerForm") RegisterForm registerForm, BindingResult bindingResult, Model model, HttpServletRequest request){
		Locale currentLocale = LocaleContextHolder.getLocale();
		if (bindingResult.hasErrors()) {
			LOG.warn(String.format("Validation error on register page, found %s errors", bindingResult.getErrorCount()));
			return "register";
		}
		UserData userData = null;
		CartData cartData = null;
		try {
			userData = authFacade.register(registerForm, UserTypeEnum.USERTYPE.CUSTOMER);
			cartData = authFacade.newCart(userData);
		} catch (UserAlreadyRegistered e) {
			LOG.warn(String.format("User already registered, input parameters:%s", registerForm.toString()));
			bindingResult.addError(new ObjectError("globalerrors", messageSource.getMessage("register.page.already.registered.error",
					null, currentLocale)));
			return "register";
		}
		if(userData == null || cartData == null) {
			LOG.warn(String.format("User not saved, input parameters:%s", registerForm.toString()));
			bindingResult.addError(new ObjectError("global.error", messageSource.getMessage("register.page.generic.error",
					null, currentLocale)));
			return "register";
		}
		model.addAttribute("user", userData);
		request.getSession().setAttribute("cart", cartData);
		return "redirect:/account_view";
	}	
}
