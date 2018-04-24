package it.sopra.stage.fullmoda.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cart")
@Data
@NoArgsConstructor
public class Cart implements Serializable{

	private static final long serialVersionUID = -7045639864968292433L;

	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(orphanRemoval= true, mappedBy="cart")
	private List<CartEntry> cartEntries;
	
	@Column(name="lastmodified")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModified;
	
	@Column(name="created")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@OneToOne
	@JoinColumn(name="user")
	private User user;
	
	@OneToOne
	@JoinColumn(name="website")
	private Website website;
	
	public Cart(User user, Website website) {
		this.user = user;
		this.website = website;
	}

	public void addCartEntry(CartEntry cartEntry) {
		if(this.cartEntries == null) {
			this.cartEntries = new LinkedList<>();
		}
		cartEntries.add(cartEntry);
	}
	
	public void addCartEntries(List<CartEntry> cartEntryList) {
		if(this.cartEntries == null) {
			this.cartEntries = new LinkedList<>();
		}
		cartEntries.addAll(cartEntryList);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cart [id=").append(id).append(", ");
		if(cartEntries != null) {
			sb.append("entries:[");
			for(CartEntry entry : cartEntries) {
				
				sb.append("->[").append(entry).append("]");
			}
		}
		sb.append("] , user=").append(user).append(", website=").append(website).append(", created=").append(created).append(", lastmodified=").append(lastModified).append("]");
		return sb.toString();
	}
	
}
