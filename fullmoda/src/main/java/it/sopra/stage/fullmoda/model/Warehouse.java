package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="warehouse")
@Data
@NoArgsConstructor
public class Warehouse implements Serializable {

	private static final long serialVersionUID = 6494391594061672262L;

	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;

	
	public Warehouse(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Warehouse [code=" + code + ", name=" + name + "]";
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
		Warehouse other = (Warehouse) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	
}
