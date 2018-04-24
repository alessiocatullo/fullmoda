package it.sopra.stage.fullmoda.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.ColorVariantProductData;
import it.sopra.stage.fullmoda.dto.PriceData;
import it.sopra.stage.fullmoda.dto.ProductData;
import it.sopra.stage.fullmoda.model.BaseProduct;
import it.sopra.stage.fullmoda.model.ColorVariantProduct;
import it.sopra.stage.fullmoda.model.Price;

@Component
public class BaseProductConverter {

	@Autowired
	private ColorVariantProductConverter colorVariantConverter;
	
	@Autowired
	private PriceConverter priceConverter;
	
	public ProductData convert(BaseProduct product) {
		List<ColorVariantProduct> colorVariants = product.getColorVariants();
		List<ColorVariantProductData> colorVariantDataList = new ArrayList<>();
		for(ColorVariantProduct colorVariant : colorVariants) {
			ColorVariantProductData colorVariantData = colorVariantConverter.convert(colorVariant);
			colorVariantDataList.add(colorVariantData);
		}
		ProductData productData = new ProductData(product.getCode(), product.getName(), product.getDescription(), colorVariantDataList);
		List<PriceData> priceDataList = new ArrayList<>();
		if(product.getPriceList() != null) {
			for( Price price : product.getPriceList()) {
				priceDataList.add(priceConverter.convert(price));
			}
			//TODO only a try to be modified
			productData.setPrice(priceDataList.get(0));
		}
		return productData;
	}

	

	
}
