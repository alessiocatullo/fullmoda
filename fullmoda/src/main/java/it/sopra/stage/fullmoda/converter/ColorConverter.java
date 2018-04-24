package it.sopra.stage.fullmoda.converter;

import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.ColorData;
import it.sopra.stage.fullmoda.model.Color;

@Component
public class ColorConverter {

	public ColorData convert (Color color) {
		String code = color.getCode();
		String html_code = color.getHtml_code();
		return new ColorData(code, html_code);
	}
}
