package br.upe.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor implements EntidadeBase{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String documentoId;
	@OneToMany(mappedBy = "fornecedor",cascade = CascadeType.ALL)
	private List<Movimentacao> movimentacao;
	@OneToMany(mappedBy = "fornecedor",cascade = CascadeType.ALL)
	private List<ListaServicos> servicos;

}
