package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="size_product")
@Data
@NoArgsConstructor
public class SizeVariantProduct implements Serializable{

	private static final long serialVersionUID = 806855520003430882L;
	
	@Id
	private String code;
	
	@OneToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="size")
	private Size size;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="baseproduct")
	private ColorVariantProduct colorVariantProduct;
	

	public ColorVariantProduct getColorVariantProduct() {
		return colorVariantProduct;
	}

	public void setColorVariantProduct(ColorVariantProduct colorVariantProduct) {
		this.colorVariantProduct = colorVariantProduct;
	}

	public SizeVariantProduct(String code, Size size, ColorVariantProduct colorVariantProduct) {
		this.code = code;
		this.size = size;
		this.colorVariantProduct = colorVariantProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SizeVariantProduct other = (SizeVariantProduct) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SizeVariantProduct [code=" + code + ", size=" + size + "]";
	}

}
