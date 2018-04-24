package it.sopra.stage.fullmoda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dao.BaseProductRepository;
import it.sopra.stage.fullmoda.dao.ColorVariantProductRepository;
import it.sopra.stage.fullmoda.dao.SizeVariantProductRepository;
import it.sopra.stage.fullmoda.model.BaseProduct;
import it.sopra.stage.fullmoda.model.ColorVariantProduct;
import it.sopra.stage.fullmoda.model.SizeVariantProduct;

@Component
public class DefaultProductService implements ProductService {

	@Autowired
	BaseProductRepository productRepository;
	
	@Autowired
	ColorVariantProductRepository colorVariantRepository;
	
	@Autowired
	SizeVariantProductRepository sizeVariantRepository;
	
	@Override
	public Iterable<BaseProduct> getProductList() {
		return productRepository.findAll();
	}

	@Override
	public BaseProduct findProduct(String code) {
		BaseProduct baseProduct =  productRepository.findOne(code);
//		Iterable<ColorVariantProduct> colorVariants = findColorVariantProductList(code);
//		baseProduct.addColorVariants(Lists.newArrayList(colorVariants));
		return baseProduct;
	}

	@Override
	public Iterable<SizeVariantProduct> findSizeVariantProductList(String colorVariantCode) {
		return sizeVariantRepository.findByColorVariantProductCode(colorVariantCode);
	}

	@Override
	public Iterable<ColorVariantProduct> findColorVariantProductList(String productCode) {
		Iterable<ColorVariantProduct> colorVariants = colorVariantRepository.findByBaseproductCode(productCode);
		
		return colorVariants;
	}

}
