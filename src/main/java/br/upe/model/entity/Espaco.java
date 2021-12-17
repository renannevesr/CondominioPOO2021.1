package br.upe.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Espaco{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column (unique = true)
	@Enumerated (EnumType.STRING)
	private Espacos nomeEspaco;
	private String observacoes;
	
	public Espaco(Espacos nomeEspaco) {
		this.nomeEspaco =nomeEspaco;
	}

}
