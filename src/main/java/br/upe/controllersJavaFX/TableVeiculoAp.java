package br.upe.controllersJavaFX;

import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Veiculo;
import lombok.Data;

@Data
public class TableVeiculoAp {

	private Long idAp;
	private Long idVeiculo;
	private int numero;
	private Blocos bloco;
	private String placa;
	private String modelo;
	private String cor;

	
	public TableVeiculoAp(Veiculo v, Apartamento a) {
		this.numero = a.getNumero();
		this.bloco = a.getBloco();
		this.idAp = a.getId();
		this.placa = v.getPlaca();
		this.modelo = v.getModelo();
		this.cor = v.getCor();
		this.idVeiculo = v.getId();
	}
	
}
