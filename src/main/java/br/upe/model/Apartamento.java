package br.upe.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento implements EntidadeBase{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int numero;
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="propietario_id")
	private Condomino propietario;
	private double taxaCondominio;
	@OneToMany(mappedBy = "apartamento", cascade = CascadeType.ALL)
	private List<Morador> moradores;
	@OneToMany(mappedBy = "apartamento", cascade = CascadeType.ALL)
	private List<Veiculo> veiculos;

}
