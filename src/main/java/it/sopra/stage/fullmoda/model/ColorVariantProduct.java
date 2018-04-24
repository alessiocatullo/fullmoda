package it.sopra.stage.fullmoda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="color_product")
@Data
@NoArgsConstructor
public class ColorVariantProduct  implements Serializable{

	private static final long serialVersionUID = 161584907401149534L;

	@Id
	@Column(name="code")
	private String code;
	
	@OneToOne (cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="color")
	private Color color;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="baseproduct")
	private BaseProduct baseproduct;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="colorVariantProduct", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<SizeVariantProduct> sizeVariantProducts;
	
	public List<SizeVariantProduct> getSizeVariantProducts() {
		return sizeVariantProducts;
	}
	public void setSizeVariantProducts(List<SizeVariantProduct> sizeVariantProducts) {
		this.sizeVariantProducts = sizeVariantProducts;
	}
	public ColorVariantProduct(String code, Color color, BaseProduct baseProduct) {

		this.code = code;
		this.color = color;
		this.baseproduct= baseProduct;
	}
	
	public void addSizeVariantProduct(SizeVariantProduct sizeVariantProduct) {
		if(this.sizeVariantProducts == null) {
			this.sizeVariantProducts = new ArrayList<SizeVariantProduct>();
		}
		this.sizeVariantProducts.add(sizeVariantProduct);
	}
	
	public void addSizeVariantProductList(List<SizeVariantProduct> sizeVariantProductList) {
		if(this.sizeVariantProducts == null) {
			this.sizeVariantProducts = new ArrayList<SizeVariantProduct>();
		}
		this.sizeVariantProducts.addAll(sizeVariantProductList);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ColorVariantProduct [code=").append(code).append(", color=").append(color);
		if(sizeVariantProducts != null) {
			sb.append(", sizeVariantProducts=[");
			for (SizeVariantProduct sizeProduct : sizeVariantProducts) {
				sb.append("->[").append(sizeProduct).append("]");
			}
			sb.append("]");
		}
		return sb.toString();
	}
	
	
	
	
}
