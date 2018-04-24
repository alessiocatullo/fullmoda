package it.sopra.stage.fullmoda.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.exception.EmailAlreadyUsed;
import it.sopra.stage.fullmoda.facade.AuthFacade;
import it.sopra.stage.fullmoda.form.AddressForm;
import it.sopra.stage.fullmoda.form.EmailForm;
import it.sopra.stage.fullmoda.form.ImgForm;
import it.sopra.stage.fullmoda.form.LoginForm;
import it.sopra.stage.fullmoda.form.NameForm;
import it.sopra.stage.fullmoda.form.PswForm;
import it.sopra.stage.fullmoda.model.JsonResponse;
import it.sopra.stage.fullmoda.validator.AddressFormValidator;
import it.sopra.stage.fullmoda.validator.EmailFormValidator;
import it.sopra.stage.fullmoda.validator.NameFormValidator;
import it.sopra.stage.fullmoda.validator.PswFormValidator;

@Controller
public class MyAccountController {

	private static final Logger LOG = Logger.getLogger(MyAccountController.class);
	
	@Autowired
	private AuthFacade authFacade;
	
	@Autowired
	private PswFormValidator pswFormValidator;
	
	@Autowired
	private EmailFormValidator emailFormValidator;
	
	@Autowired
	private AddressFormValidator addressFormValidator;
	
	@Autowired
	private NameFormValidator nameFormValidator;
	
	@RequestMapping(value="/account_view", method = RequestMethod.GET)
	public String showMyAccountPage(Model model, HttpServletRequest request){
		
		/** so trivial... :) */
		UserData user = (UserData)request.getSession().getAttribute("user");
		if(user == null) {
			LOG.debug("User not logged - Redirect to home");
			model.addAttribute("loginForm", new LoginForm());
			return "login";
		}
		model.addAttribute("user", user);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new ByteArrayInputStream(user.getImage().getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (img != null)
			model.addAttribute("img", img);
		return "account_view";
	}
	
	@ResponseBody
	@RequestMapping(value = "/account_view", method = RequestMethod.POST)
	public JsonResponse editMyAccountPage(@RequestBody ImgForm editImg, HttpServletRequest request, Model model) {
		JsonResponse result = new JsonResponse();
		UserData userData = null;
		UserData tmpUser = (UserData)request.getSession().getAttribute("user");
		try {
			editImg.setId(tmpUser.getId());
			userData = authFacade.updateImg(editImg);
		}
		catch (Exception ex) {
			
		}
		request.getSession().setAttribute("user", userData);
		model.addAttribute("user", userData);
		return result;
	}
	
	@RequestMapping(value="/account_name", method = RequestMethod.GET)
	public String showEditAccountName(Model model, HttpServletRequest request){
		UserData user = (UserData)request.getSession().getAttribute("user");
		if(user == null) {
			LOG.debug("User not logged - Redirect to home");
			model.addAttribute("loginForm", new LoginForm());
			return "login";
		}
		model.addAttribute("user", user);
		model.addAttribute("editName", new NameForm());
		return "account_name";
	}
	
	@RequestMapping(value="/account_name", method = RequestMethod.POST)
	public String editAccountName(@Valid @ModelAttribute("editName") NameForm nameForm, Model model, BindingResult result, HttpServletRequest request){
		UserData userData = null;
		UserData tmpUser = (UserData)request.getSession().getAttribute("user");
		nameFormValidator.validate(nameForm, result);
		if (result.hasErrors()) {
			return "account_name";
		} else {
			nameForm.setId(tmpUser.getId());
			userData = authFacade.updateName(nameForm);
			if(userData == null) {
				LOG.warn("Errore");
				return "account_name";
			}
			request.getSession().setAttribute("user", userData);
			model.addAttribute("user", userData);
			return "account_view";
		}
	}
	
	@RequestMapping(value="/account_email", method = RequestMethod.GET)
	public String showEditAccountEmail(Model model, HttpServletRequest request){
		UserData user = (UserData)request.getSession().getAttribute("user");
		if(user == null) {
			LOG.debug("User not logged - Redirect to home");
			model.addAttribute("loginForm", new LoginForm());
			return "login";
		}
		model.addAttribute("user", user);
		model.addAttribute("editEmail", new EmailForm());
		return "account_email";
	}
	
	@RequestMapping(value="/account_email", method = RequestMethod.POST)
	public String editAccountEmail(@Valid @ModelAttribute("editEmail") EmailForm emailForm, BindingResult result, Model model, HttpServletRequest request){
		UserData tmpUser = (UserData)request.getSession().getAttribute("user");
		emailForm.setOldpassword(tmpUser.getPassword());
		emailForm.setOldemail(tmpUser.getEmail());
		emailFormValidator.validate(emailForm, result);
		if (result.hasErrors()) {
			return "account_email";
		}
		UserData userData = null;
		try {
			emailForm.setId(tmpUser.getId());
			userData = authFacade.updateEmail(emailForm);
		}
		catch (EmailAlreadyUsed e) {
			LOG.warn(String.format("Email already used, input parameters:%s", emailForm.toString()));
			result.rejectValue("email", "error.email.duplicate");			
			return "account_email";
		}
		if(userData == null) {
			LOG.warn("Errore");
			return "account_email";
		}
		request.getSession().setAttribute("user", userData);
		model.addAttribute("user", userData);
		return "account_view";
	}

	@RequestMapping(value="/account_password", method = RequestMethod.GET)
	public String showEditAccountPsw(Model model, HttpServletRequest request){
		UserData user = (UserData)request.getSession().getAttribute("user");
		if(user == null) {
			LOG.debug("User not logged - Redirect to home");
			model.addAttribute("loginForm", new LoginForm());
			return "login";
		}
		model.addAttribute("user", user);
		model.addAttribute("editPsw", new PswForm());
		return "account_password";
	}
	
	@RequestMapping(value="/account_password", method = RequestMethod.POST)
	public String editAccountPsw(@Valid @ModelAttribute("editPsw") PswForm pswForm, BindingResult result, Model model, HttpServletRequest request){
		UserData tmpUser = (UserData)request.getSession().getAttribute("user");
		pswForm.setOldpassword(tmpUser.getPassword());
		pswFormValidator.validate(pswForm, result);
		if (result.hasErrors()) {
			return "account_password";
		}
		else {
			UserData userData = null;
			pswForm.setId(tmpUser.getId());
			userData = authFacade.updatePsw(pswForm);
			if(userData == null) {
				LOG.warn("Errore");
				return "account_password";
			}
			request.getSession().setAttribute("user", userData);
			model.addAttribute("user", userData);
			return "account_view";
		}
	}

	@RequestMapping(value="/account_address", method = RequestMethod.GET)
	public String showEditAccountAddress(Model model, HttpServletRequest request){
		UserData user = (UserData)request.getSession().getAttribute("user");
		if(user == null) {
			LOG.debug("User not logged - Redirect to home");
			model.addAttribute("loginForm", new LoginForm());
			return "login";
		}
		model.addAttribute("user", user);
		model.addAttribute("editAddress", new AddressForm());
		return "account_address";
	}
	
	@RequestMapping(value="/account_address", method = RequestMethod.POST)
	public String editAccountAddress(@Valid @ModelAttribute("editAddress") AddressForm addressForm, BindingResult result, Model model, HttpServletRequest request){
		UserData tmpUser = (UserData)request.getSession().getAttribute("user");
		addressFormValidator.validate(addressForm, result);
		if (result.hasErrors()) {
			return "account_address";
		}
		else {
			UserData userData = null;
			addressForm.setId(tmpUser.getId());
			userData = authFacade.updateAddress(addressForm);
			if(userData == null) {
				LOG.warn("Errore");
				return "account_address";
			}
			request.getSession().setAttribute("user", userData);
			model.addAttribute("user", userData);
			return "account_view";
		}
	}

}
