package it.sopra.stage.fullmoda.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.sopra.stage.fullmoda.dto.CartData;
import it.sopra.stage.fullmoda.dto.CartEntryData;
import it.sopra.stage.fullmoda.dto.ProductData;
import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.dto.UserData;
import it.sopra.stage.fullmoda.facade.CartFacade;
import it.sopra.stage.fullmoda.facade.DefaultProductFacade;

@Controller
public class CartController {

	@Autowired
	private CartFacade cartFacade;

  @Autowired
	private DefaultProductFacade productFacade;
	
    @RequestMapping(value = "/addCart-{code}", method=RequestMethod.GET)
    public String addCart(@PathVariable("code") String code, HttpServletRequest request) {
        UserData user = (UserData)request.getSession().getAttribute("user");
        ProductData size = productFacade.findBySizeProduct(code);
        cartFacade.addToCart(code, user.getId());
        int quantity = (int)request.getSession().getAttribute("quantity");
        quantity ++;
        request.getSession().setAttribute("quantity", quantity);
        return "redirect:/p-" + size.getCode();
    }
	@RequestMapping(value="/addCart-1-{code}", method=RequestMethod.GET)
	public String addOnesToCart(@PathVariable("code") String code, HttpServletRequest request) {
		long codeEntry = Long.parseLong(code);
		cartFacade.addOnesToCart(codeEntry);
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/delete-{code}", method=RequestMethod.GET)
	public String removeProduct(@PathVariable("code") String stringCode, HttpServletRequest request) {
		long codeEntry = Long.parseLong(stringCode);
		cartFacade.removeFromCart(codeEntry);
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/delete-1-{code}", method=RequestMethod.GET)
	public String removeOneProduct(@PathVariable("code") String stringCode, HttpServletRequest request) {
		long codeEntry = Long.parseLong(stringCode);
		cartFacade.removeOnesFromCart(codeEntry);
		return "redirect:/cart";
	}
	
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String getCart(HttpServletRequest request, Model model) {
		UserData user = (UserData)request.getSession().getAttribute("user");
		CartData cartData = cartFacade.findByUserId(user.getId());
		List<CartEntryData> cart = cartData.getEntries();
		List<SizeVariantProductData> products = new ArrayList<>();
		cart.forEach(e-> products.add(productFacade.bildProduct(e.getProduct())));
		for(int i=0; i<cart.size(); i++) {
			cart.get(i).setProduct(products.get(i));
		}
		double tot = 0;
		for(CartEntryData var: cart) {
			tot += var.getQuantity() * var.getProduct().getColor().getProduct().getPrice().getValue().doubleValue();
		}
		BigDecimal bgTot = BigDecimal.valueOf(tot);
		bgTot = bgTot.setScale(2, BigDecimal.ROUND_HALF_UP);
		model.addAttribute("tot", bgTot );
		model.addAttribute("cart", cart);
		model.addAttribute("idCart", cartData.getId());
		int quantity = 0;
		for(CartEntryData cartEntry: cart) {
			quantity = quantity + cartEntry.getQuantity();
		}
		request.getSession().setAttribute("quantity", quantity);
		return "cart";
	}
}
