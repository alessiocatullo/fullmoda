package it.sopra.stage.fullmoda.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.CartEntryData;
import it.sopra.stage.fullmoda.dto.SizeVariantProductData;
import it.sopra.stage.fullmoda.model.CartEntry;

@Component
public class CartEntryConverter {

	@Autowired
	private SizeVariantProductConverter sizeProductConverter;

	public CartEntryData convert(CartEntry entry) {
		Long entryId = entry.getEntryId();
		int quantity = entry.getQuantity();
		SizeVariantProductData sizeProductData = sizeProductConverter.convert(entry.getProduct());
		return new CartEntryData(entryId, sizeProductData, quantity);
	}
}
