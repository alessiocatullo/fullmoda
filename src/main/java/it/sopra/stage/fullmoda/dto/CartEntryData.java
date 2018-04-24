package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CartEntryData implements Serializable{
	
	private static final long serialVersionUID = 6085296029306004258L;
	
	private Long id;
	private SizeVariantProductData product;
	private int quantity;
	
	public CartEntryData() {
		
	}
	
	public CartEntryData(Long id, SizeVariantProductData product, int quantity) {
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "CartEntryData [id=" + id + ", product=" + product + ", quantity=" + quantity + "]";
	}
}
