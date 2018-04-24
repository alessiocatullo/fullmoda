package it.sopra.stage.fullmoda.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.BaseProductConverter;
import it.sopra.stage.fullmoda.converter.PriceConverter;
import it.sopra.stage.fullmoda.dto.PriceData;
import it.sopra.stage.fullmoda.dto.ProductData;
import it.sopra.stage.fullmoda.model.BaseProduct;
import it.sopra.stage.fullmoda.model.Price;
import it.sopra.stage.fullmoda.service.PriceService;
import it.sopra.stage.fullmoda.service.ProductService;

@Component
public class DefaultProductFacade implements ProductFacade {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private PriceService priceService;
	
	@Autowired
	private BaseProductConverter productConverter;
	
	@Autowired
	private PriceConverter priceConverter;
	
	@Override
	public List<ProductData> getProductList() {
		
		List<ProductData> productDataList = new ArrayList<>();
		Iterable<BaseProduct> productList = productService.getProductList();
		for(BaseProduct product : productList) {
			productDataList.add(productConverter.convert(product));
		}
		return productDataList;
	}

	@Override
	public ProductData findProduct(String code, String currencyCode) {
		ProductData productData = findProduct(code);
		Price price = priceService.findProductPrice(code, currencyCode);
		PriceData priceData = priceConverter.convert(price);
		productData.setPrice(priceData);
		return productData;
	}

	@Override
	public ProductData findProduct(String code) {
		BaseProduct product = productService.findProduct(code);
		ProductData productData = null;
		if(product != null) {
			productData = productConverter.convert(product);
		}
		return productData;
	}

	@Override
	public List<ProductData> getProductList(String currency) {
		List<ProductData> productDataList = new ArrayList<>();
		Iterable<BaseProduct> productList = productService.getProductList();
		for(BaseProduct product : productList) {
			ProductData productData = productConverter.convert(product);
			Price price = priceService.findProductPrice(product.getCode(), currency);
			PriceData priceData = priceConverter.convert(price);
			productData.setPrice(priceData);
			productDataList.add(productData);
		}
		return productDataList;
	}

}
