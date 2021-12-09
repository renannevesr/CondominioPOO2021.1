package br.upe.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Pessoa{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String nome;
	@Column(unique = true)
	private String cpf;

}
