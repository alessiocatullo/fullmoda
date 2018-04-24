package it.sopra.stage.fullmoda.converter;

import org.springframework.stereotype.Component;

import it.sopra.stage.fullmoda.dto.SizeData;
import it.sopra.stage.fullmoda.model.Size;

@Component
public class SizeConverter {

	public SizeData convert (Size size) {
		return new SizeData(size.getCode());
	}
}
