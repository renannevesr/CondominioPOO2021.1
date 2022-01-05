package br.upe.controllersJavaFX;

import java.time.LocalDate;

import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Espacos;
import br.upe.model.entity.Reservas;
import lombok.Data;

@Data
public class TableReservaAp {
	
	private Long idAp;
	private Long idReserva;
	private int numero;
	private Blocos bloco;
	private Espacos espaco;
	private double valor;
	private LocalDate dataUtilizacao;

	
	public TableReservaAp(Reservas r, Apartamento a) {
		this.numero = a.getNumero();
		this.bloco = a.getBloco();
		this.idAp = a.getId();
		this.valor = r.getValor();
		this.espaco = r.getEspaco();
		this.dataUtilizacao = r.getDataUtilizacao();
		this.idReserva = r.getId();
	}

}
