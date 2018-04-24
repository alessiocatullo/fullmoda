package it.sopra.stage.fullmoda.facade;

import java.util.List;

import it.sopra.stage.fullmoda.dto.ColorVariantProductData;
import it.sopra.stage.fullmoda.dto.ProductData;
import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.model.ColorVariantProduct;
import it.sopra.stage.fullmoda.model.SizeVariantProduct;

public interface ProductFacade {

	List<ProductData> getProductList();
	
	ProductData findProduct(String code);
	
	List<ProductData> getProductList(String currency);
	
	List<ColorVariantProductData> findColorVariantProductList(String productCode);
	
	ProductData findProduct(String code, String currency);
	
	ColorVariantProductData findColor(String colorCode);
	
	ColorVariantProductData findBySizeColor(String code);
	
	ProductData findBySizeProduct(String code);
	
	SizeVariantProductData findSize(String sizeCode);
	
	SizeVariantProductData bildProduct(SizeVariantProductData product);
}
