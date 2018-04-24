package it.sopra.stage.fullmoda.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.WebsiteData;
import it.sopra.stage.fullmoda.model.Website;

@Component
public class WebsiteConverter {

	@Autowired
	private LanguageConverter languageConverter;
	
	public WebsiteData convert(Website website) {
		return new WebsiteData(website.getWebsiteId(), languageConverter.convert(website.getLanguage()));
	}
}
