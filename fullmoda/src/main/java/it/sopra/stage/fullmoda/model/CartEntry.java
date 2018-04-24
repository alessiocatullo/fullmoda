package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cart_entries")
@Data
@NoArgsConstructor
public class CartEntry implements Serializable {

	private static final long serialVersionUID = -2582703987960111108L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idcart_entries")
	private Long entryId;
	
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="product")
	private SizeVariantProduct product;
	
	@Column(name="quantity")
	private int quantity;

	public CartEntry(SizeVariantProduct product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartEntry [entryId=" + entryId + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
	
	
}
