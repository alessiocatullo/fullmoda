package it.sopra.stage.fullmoda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.ColorVariantProduct;

public interface ColorVariantProductRepository extends JpaRepository<ColorVariantProduct, String>{

	public List<ColorVariantProduct> findByBaseproductCode(String code);
	
	ColorVariantProduct findByCode(String code);
}
