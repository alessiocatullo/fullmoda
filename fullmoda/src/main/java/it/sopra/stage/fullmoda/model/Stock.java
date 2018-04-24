package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="stock")
@Data
@NoArgsConstructor
public class Stock implements Serializable {

	private static final long serialVersionUID = -5190480780262686322L;

	@EmbeddedId 
	private StockPK stockPK;
	
	@ManyToOne (cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="product",  insertable=false, updatable=false)
	private SizeVariantProduct product;
	
	@OneToOne (cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="warehouse", insertable=false, updatable=false)
	private Warehouse warehouse;
	
	@Column(name="available")
	private int available;
	
	@Column(name="reserved")
	private int reserved;

	
	public Stock(StockPK stockPK, SizeVariantProduct product, Warehouse warehouse, int available, int reserved) {
		this.stockPK = stockPK;
		this.product = product;
		this.warehouse = warehouse;
		this.available = available;
		this.reserved = reserved;
	}

	@Override
	public String toString() {
		return "Stock [stockPK=" + stockPK + ", product=" + product + ", warehouse=" + warehouse + ", available="
				+ available + ", reserved=" + reserved + "]";
	}
	
	
	
}
