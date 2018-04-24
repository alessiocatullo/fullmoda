package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CartData implements Serializable{

	private static final long serialVersionUID = -7606284881257243451L;

	
	private Long id;
	private List<CartEntryData> entries;
	private UserData user;
	private WebsiteData website;
	
	public CartData() {
	}
			
	
	public CartData(Long id, List<CartEntryData> entries, UserData user, WebsiteData website) {
		this.id = id;
		this.entries = entries;
		this.user = user;
		this.website = website;
	}


	@Override
	public String toString() {
		return "CartData [id=" + id + ", entries=" + entries + ", user=" + user + ", website=" + website + "]";
	}
	
	
	
	
}
