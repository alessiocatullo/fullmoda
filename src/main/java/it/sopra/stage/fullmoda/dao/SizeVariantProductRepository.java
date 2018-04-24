package it.sopra.stage.fullmoda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.SizeVariantProduct;

public interface SizeVariantProductRepository extends JpaRepository<SizeVariantProduct, String>{

	List<SizeVariantProduct> findByColorVariantProductCode(String code);
	
	SizeVariantProduct findByCode(String code);
	
	SizeVariantProduct findBySizeAndColorVariantProduct(String codeSize, String codeColor);
}
