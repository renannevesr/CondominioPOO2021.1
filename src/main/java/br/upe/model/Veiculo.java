package br.upe.model;

import lombok.*;

import javax.persistence.*;

@Getter 
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String placa;
	private String modelo;
	private String cor;

	@ManyToOne
	private Apartamento apartamento;

}
