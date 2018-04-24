package it.sopra.stage.fullmoda.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class WebsiteData implements Serializable{

	private static final long serialVersionUID = -770850860150576671L;

	private String websiteId;
	
	private LanguageData language;

	public WebsiteData() {
		
	}

	public WebsiteData(String websiteId, LanguageData language) {
		this.websiteId = websiteId;
		this.language = language;
	}

	@Override
	public String toString() {
		return "WebsiteData [websiteId=" + websiteId + ", language=" + language + "]";
	}
	
	
}
