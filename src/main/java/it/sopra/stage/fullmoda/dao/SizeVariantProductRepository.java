package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.SizeVariantProduct;

public interface SizeVariantProductRepository extends JpaRepository<SizeVariantProduct, String>{

	public Iterable<SizeVariantProduct> findByColorVariantProductCode(String code);
	
	SizeVariantProduct findByCode(String code);
}
