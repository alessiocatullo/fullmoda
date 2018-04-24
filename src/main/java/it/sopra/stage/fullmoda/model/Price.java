package it.sopra.stage.fullmoda.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table (name="price")
@Data
@NoArgsConstructor
public class Price implements Serializable {

	private static final long serialVersionUID = 8385173020735659L;

	@EmbeddedId 
	private PricePK pricePK;

	@Column(name="value",precision = 19, scale = 4)
	private BigDecimal value;
	
	@OneToOne (cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="currency", insertable=false, updatable=false)
	private Currency currency;
	
	@ManyToOne (cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="product",  insertable=false, updatable=false)
	private BaseProduct baseProduct;

	
	public Price(PricePK pricePK, BigDecimal value, BaseProduct baseProduct, Currency currency) {
		this.pricePK = pricePK;
		this.value = value;
		this.baseProduct = baseProduct;
		this.currency = currency;
		
	}

	@Override
	public String toString() {
		return "Price [ value=" + value + ", pricePK="+pricePK+", currency ="+currency+"]";
	}
	
	
}
