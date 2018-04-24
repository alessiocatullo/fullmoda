package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class StockPK implements Serializable {

	private static final long serialVersionUID = 1992493612925307528L;

	@ManyToOne (cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="product",  insertable=false, updatable=false)
	private SizeVariantProduct product;
	
	@OneToOne (cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="warehouse", insertable=false, updatable=false)
	private Warehouse warehouse;
	
	
	public StockPK() {
		
	}
	public StockPK(SizeVariantProduct product, Warehouse warehouse) {
		this.product = product;
		this.warehouse = warehouse;
	}
	public SizeVariantProduct getProduct() {
		return product;
	}
	public void setProduct(SizeVariantProduct product) {
		this.product = product;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((warehouse == null) ? 0 : warehouse.hashCode());
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
		StockPK other = (StockPK) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (warehouse == null) {
			if (other.warehouse != null)
				return false;
		} else if (!warehouse.equals(other.warehouse))
			return false;
		return true;
	}
	
	
}
