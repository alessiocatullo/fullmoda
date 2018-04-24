package it.sopra.stage.fullmoda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.sopra.stage.fullmoda.dto.ColorVariantProductData;
import it.sopra.stage.fullmoda.dto.ProductData;
import it.sopra.stage.fullmoda.facade.ProductFacade;

@Controller
public class ProductController {

	
	@Autowired
	private ProductFacade productFacade;
	
	@RequestMapping(value= {"/products"}, method=RequestMethod.GET)
	public String getProducts(Model model){
		List<ProductData> productList = productFacade.getProductList();
		model.addAttribute("productList", productList);
		return "full_product_list";	
	}
	
	@RequestMapping(value="/p-{productCode}", method=RequestMethod.GET)
	public String getProduct(@PathVariable("productCode") String productCode, Model model) {
		ProductData productData = productFacade.findProduct(productCode);
		ColorVariantProductData colorData = new ColorVariantProductData();
		model.addAttribute("product", productData);
		model.addAttribute("color", colorData);
		return "product";
	}
	
	@RequestMapping(value="/color-{productCode}-{colorCode}", method=RequestMethod.GET)
	public String getSize(@PathVariable("productCode")String productCode, @PathVariable("colorCode")String colorCode, Model model) {
		ProductData productData = productFacade.findProduct(productCode);
		ColorVariantProductData colorData = productFacade.findColor(colorCode);
		model.addAttribute("product", productData);
		model.addAttribute("color", colorData);
		return "product";
	}
}
