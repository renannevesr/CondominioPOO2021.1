package br.upe.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Servicos extends Requisicao{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private List<Servico> servico;
	private Fornecedor prestador;

}
