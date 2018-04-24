package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ColorVariantProductData implements Serializable{

	private static final long serialVersionUID = -1596107255131789067L;

	private String code;
	private ColorData colorData;
	
	private List<SizeVariantProductData> variants;

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ColorVariantProductData [code =").append(code).append(", colorData=").append(colorData).append(", variants=[");
		if(variants != null) {
			for(SizeVariantProductData sizeProduct : variants) {
				sb.append("->[").append(sizeProduct).append("]");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public ColorVariantProductData() {
		
	}
	public ColorVariantProductData(String code, ColorData colorData, List<SizeVariantProductData> variants) {
		this.code = code;
		this.colorData = colorData;
		this.variants = variants;
	}
	
	
	
}
