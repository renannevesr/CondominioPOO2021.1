package br.upe.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter 
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String placa;
	private String modelo;
	private String cor;
	@ManyToOne
	@JoinColumn (name = "apartamento_id")
	private Apartamento apartamento;

}
