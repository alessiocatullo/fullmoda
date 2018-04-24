package it.sopra.stage.fullmoda.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="website")
@Data
@NoArgsConstructor
public class Website implements Serializable {

	private static final long serialVersionUID = 8896356598765703885L;

	@Id
	@Column(name ="website_id")
	private String websiteId;
	
	@OneToOne
	@JoinColumn (name="language")
	private Language language;

	public Website(String websiteId, Language language) {
		this.websiteId = websiteId;
		this.language = language;
	}

	
	
}
