package it.sopra.stage.fullmoda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.ColorVariantProductConverter;
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
	@Autowired
	ColorVariantProductConverter colorVariantProductConverter;
	
	@Override
	public List<BaseProduct> getProductList() {
		return productRepository.findAll();
	}

	@Override
	public BaseProduct findProduct(String code) {
		BaseProduct baseProduct =  productRepository.findOne(code);
		return baseProduct;
	}

	@Override
	public List<SizeVariantProduct> findSizeVariantProductList(String colorVariantCode) {
		return sizeVariantRepository.findByColorVariantProductCode(colorVariantCode);
	}

	@Override
	public List<ColorVariantProduct> findColorVariantProductList(String productCode) {
		List<ColorVariantProduct> colorVariants = colorVariantRepository.findByBaseproductCode(productCode);
		return colorVariants;
	}

	@Override
	public BaseProduct findBySizeProduct(String code) {
		BaseProduct product = sizeVariantRepository.findByCode(code).getColorVariantProduct().getBaseproduct();
		return product;
	}

	@Override
	public SizeVariantProduct findBySizeAndColorVariantProduct(String codeSize, String codeColor) {
		return sizeVariantRepository.findBySizeAndColorVariantProduct(codeSize, codeColor);
	}

	@Override
	public ColorVariantProduct findBySizeColor(String code) {
		ColorVariantProduct color = sizeVariantRepository.findByCode(code).getColorVariantProduct();
		return color;
	}

	@Override
	public ColorVariantProduct findColor(String code) {
		return colorVariantRepository.findByCode(code);
	}

	@Override
	public SizeVariantProduct findSize(String sizeCode) {
		return sizeVariantRepository.findByCode(sizeCode);
	}
}
