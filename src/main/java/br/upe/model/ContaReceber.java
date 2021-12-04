package br.upe.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ContaReceber extends OperacaoEntrada{

	private Date dataVencimento;
	//private String status;
	

}
