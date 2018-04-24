package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Embeddable
public class PricePK implements Serializable {

	private static final long serialVersionUID = 396227577505564629L;

	@OneToOne (cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="currency", insertable=false, updatable=false)
	private Currency curr;

	@ManyToOne (cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="product",  insertable=false, updatable=false)
	private BaseProduct prod;

    public PricePK() {}

    public PricePK(BaseProduct prod, Currency curr) {
        this.prod = prod;
        this.curr = curr;
    }

	
	public Currency getCurr() {
		return curr;
	}

	public void setCurr(Currency curr) {
		this.curr = curr;
	}

	public BaseProduct getProd() {
		return prod;
	}

	public void setProd(BaseProduct prod) {
		this.prod = prod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curr == null) ? 0 : curr.hashCode());
		result = prime * result + ((prod == null) ? 0 : prod.hashCode());
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
		PricePK other = (PricePK) obj;
		if (curr == null) {
			if (other.curr != null)
				return false;
		} else if (!curr.equals(other.curr))
			return false;
		if (prod == null) {
			if (other.prod != null)
				return false;
		} else if (!prod.equals(other.prod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PricePK [curr=" + curr + ", prod=" + prod + "]";
	}

	
	

}
