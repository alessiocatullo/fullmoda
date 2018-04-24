package it.sopra.stage.fullmoda.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.BaseProduct;

public interface BaseProductRepository extends JpaRepository<BaseProduct, String> {
	
	BaseProduct findByCode(String code);
	
	List<BaseProduct> findByOnlineDateAfterAndOfflineDateBefore(Date onlineDate, Date offlineDate);
	
}
