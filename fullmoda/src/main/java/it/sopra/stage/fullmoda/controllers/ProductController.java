package it.sopra.stage.fullmoda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.sopra.stage.fullmoda.dto.ProductData;
import it.sopra.stage.fullmoda.facade.ProductFacade;

@Controller
public class ProductController {

	
	@Autowired
	private ProductFacade productFacade;
	
	@RequestMapping(value= {"/products"}, method=RequestMethod.GET)
	public String getProducts(Model model){
		
		Iterable<ProductData> productList = productFacade.getProductList();
		model.addAttribute("productList", productList);
		return "full_product_list";	
	}
	
	
	@RequestMapping(value="/p-{code}", method=RequestMethod.GET)
	public String getProduct(@PathVariable("code") String code, Model model) {
		ProductData productData = productFacade.findProduct(code);
		model.addAttribute("product", productData);
		return "product";
	}
}
