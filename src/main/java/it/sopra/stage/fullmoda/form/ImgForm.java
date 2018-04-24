package it.sopra.stage.fullmoda.form;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ImgForm {

	private long id;
	
	private String image;

}
