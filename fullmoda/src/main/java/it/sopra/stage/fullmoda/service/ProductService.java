package it.sopra.stage.fullmoda.service;

import it.sopra.stage.fullmoda.model.BaseProduct;
import it.sopra.stage.fullmoda.model.ColorVariantProduct;
import it.sopra.stage.fullmoda.model.SizeVariantProduct;

public interface ProductService {

	Iterable<BaseProduct> getProductList();
	
	BaseProduct findProduct(String code);
	
	Iterable<SizeVariantProduct> findSizeVariantProductList(String colorVariantCode);
	
	Iterable<ColorVariantProduct> findColorVariantProductList(String productCode);
}
