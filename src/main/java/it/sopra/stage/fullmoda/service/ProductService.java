package it.sopra.stage.fullmoda.service;

import java.util.List;

import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.model.BaseProduct;
import it.sopra.stage.fullmoda.model.ColorVariantProduct;
import it.sopra.stage.fullmoda.model.SizeVariantProduct;

public interface ProductService {

	List<BaseProduct> getProductList();
	
	BaseProduct findProduct(String code);
	
	ColorVariantProduct findColor(String code);
	
	List<SizeVariantProduct> findSizeVariantProductList(String colorVariantCode);
	
	List<ColorVariantProduct> findColorVariantProductList(String productCode);
	
	BaseProduct findBySizeProduct(String code);
	
	ColorVariantProduct findBySizeColor(String code);
	
	SizeVariantProduct findSize (String sizeCode);

	SizeVariantProduct findBySizeAndColorVariantProduct(String codeSize, String codeColor);
}
