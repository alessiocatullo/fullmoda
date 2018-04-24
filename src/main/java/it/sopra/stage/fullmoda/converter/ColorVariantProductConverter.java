package it.sopra.stage.fullmoda.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.ColorData;
import it.sopra.stage.fullmoda.dto.ColorVariantProductData;
import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.model.BaseProduct;
import it.sopra.stage.fullmoda.model.Color;
import it.sopra.stage.fullmoda.model.ColorVariantProduct;
import it.sopra.stage.fullmoda.model.SizeVariantProduct;

@Component
public class ColorVariantProductConverter {

	@Autowired
	private ColorConverter colorConverter;
	
	@Autowired
	private SizeVariantProductConverter sizeVariantConverter;

	@Autowired
	private BaseProductConverter productConverter;
	
	public ColorVariantProductData convert(ColorVariantProduct product) {
		String code = product.getCode();
		ColorData color = colorConverter.convert(product.getColor());
		List<SizeVariantProduct> sizeVariantList = product.getSizeVariantProducts();
		System.out.println("sizeVariantList_______________________"+sizeVariantList.size());
		List<SizeVariantProductData> sizeVariantDataList = new ArrayList<>();
		for(SizeVariantProduct sizeProduct : sizeVariantList) {
			SizeVariantProductData sizeProductData = sizeVariantConverter.convert(sizeProduct);
			sizeVariantDataList.add(sizeProductData);
		}
		return new ColorVariantProductData(code, color,sizeVariantDataList);
	}
}
