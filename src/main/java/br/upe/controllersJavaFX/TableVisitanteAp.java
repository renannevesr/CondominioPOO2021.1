package br.upe.controllersJavaFX;

import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Visitante;
import lombok.Data;

@Data
public class TableVisitanteAp {
	
	private Long idAp;
	private Long idVisitante;
	private int numero;
	private Blocos bloco;
	private String nome;
	private String cpf;
	
	public TableVisitanteAp(Visitante v, Apartamento a) {
		this.numero = a.getNumero();
		this.bloco = a.getBloco();
		this.idAp = a.getId();
		this.cpf = v.getCpf();
		this.nome = v.getNome();
		this.idVisitante = v.getId();
	}

}
