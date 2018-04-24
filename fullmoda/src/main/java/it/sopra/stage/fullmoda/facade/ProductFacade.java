package it.sopra.stage.fullmoda.facade;

import java.util.List;

import it.sopra.stage.fullmoda.dto.ProductData;

public interface ProductFacade {

	List<ProductData> getProductList();
	
	ProductData findProduct(String code);
	
	List<ProductData> getProductList(String currency);
	
	ProductData findProduct(String code, String currency);
}
