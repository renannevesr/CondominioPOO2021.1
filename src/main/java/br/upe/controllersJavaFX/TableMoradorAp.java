package br.upe.controllersJavaFX;

import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Morador;
import lombok.Data;

@Data
public class TableMoradorAp {
	
	private Long idAp;
	private Long idMorador;
	private int numero;
	private Blocos bloco;
	private String nome;
	private String cpf;
	
	public TableMoradorAp(Morador m, Apartamento a) {
		this.numero = a.getNumero();
		this.bloco = a.getBloco();
		this.idAp = a.getId();
		this.cpf = m.getCpf();
		this.nome = m.getNome();
		this.idMorador = m.getId();
	}
	
}
