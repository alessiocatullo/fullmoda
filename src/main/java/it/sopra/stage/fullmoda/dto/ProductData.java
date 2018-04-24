package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ProductData implements Serializable {

	private static final long serialVersionUID = -6303202980170584163L;

	private String code;
	private String description;
	private String shortDescription;
	private List<ColorVariantProductData> variants;
	private PriceData price;
	
	public ProductData() {
		
	}
	
	public ProductData(String code, String shortDescription, String description, List<ColorVariantProductData> variants) {
		this.code = code;
		this.shortDescription = shortDescription;
		this.description = description;
		this.variants = variants;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ProductData ");
		sb.append("[code=").append(this.code).append(", shortDescription=").append(this.shortDescription).append(", description=").append(this.description).append(", variants=[");
		if(this.variants != null) {
			for(ColorVariantProductData colorVariant : this.variants) {
				sb.append("->[").append(colorVariant).append("]");
			}
		}
		if(price != null) {
			sb.append(", price=[").append(price).append("]");
		}
		sb.append("]");
		return sb.toString();
	}
	
	
}
