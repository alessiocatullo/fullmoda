package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SizeVariantProductData implements Serializable{

	private static final long serialVersionUID = -299235303386525891L;
	
	private String code;
	private SizeData size;
	private ColorVariantProductData color;
	
	public SizeVariantProductData() {
		
	}
	public SizeVariantProductData(String code, SizeData size) {
		this.code = code;
		this.size = size;
	}

	@Override
	public String toString() {
		return "SizeVariantProductData [code=" + code + ", size=" + size + "]";
	}
}
