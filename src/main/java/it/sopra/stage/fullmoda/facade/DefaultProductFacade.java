package it.sopra.stage.fullmoda.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.converter.BaseProductConverter;
import it.sopra.stage.fullmoda.converter.ColorVariantProductConverter;
import it.sopra.stage.fullmoda.converter.PriceConverter;
import it.sopra.stage.fullmoda.converter.SizeVariantProductConverter;
import it.sopra.stage.fullmoda.dto.ColorVariantProductData;
import it.sopra.stage.fullmoda.dto.PriceData;
import it.sopra.stage.fullmoda.dto.ProductData;
import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.model.BaseProduct;
import it.sopra.stage.fullmoda.model.ColorVariantProduct;
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
	@Autowired
	private ColorVariantProductConverter colorConverter;
	@Autowired
	private SizeVariantProductConverter sizeConverter;
	
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

	@Override
	public ColorVariantProductData findBySizeColor(String code) {
		ColorVariantProductData color = colorConverter.convert(productService.findBySizeColor(code));
		return color;
	}

	@Override
	public ProductData findBySizeProduct(String code) {
		ProductData product = productConverter.convert(productService.findBySizeProduct(code));
		return product;
	}

	@Override
	public SizeVariantProductData bildProduct(SizeVariantProductData product) {
		ProductData temp = findBySizeProduct(product.getCode());
		ColorVariantProductData color = findBySizeColor(product.getCode());
		color.setProduct(temp);
		product.setColor(color);
		return product;
	}

	@Override
	public List<ColorVariantProductData> findColorVariantProductList(String productCode) {
		List<ColorVariantProduct> colors = productService.findColorVariantProductList(productCode);
		List<ColorVariantProductData> colorsData = new ArrayList<>();
		colors.forEach(e-> colorsData.add(colorConverter.convert(e)));
		return null;
	}

	@Override
	public ColorVariantProductData findColor(String colorCode) {
		ColorVariantProductData color = colorConverter.convert(productService.findColor(colorCode));
		return color;
	}

	@Override
	public SizeVariantProductData findSize(String sizeCode) {
		SizeVariantProductData size = sizeConverter.convert(productService.findSize(sizeCode));
		return size;
	}
}
