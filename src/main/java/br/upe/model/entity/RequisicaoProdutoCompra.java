package br.upe.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RequisicaoProdutoCompra extends Requisicao{

	private String tipo;
	@OneToMany (cascade = CascadeType.ALL)
	@JoinColumn(name="reqProdutoCompra_id")
	private List<Produto> produtos;
	

	public RequisicaoProdutoCompra(Double valorTotal, Date data, Conta conta, String tipo, List<Produto> produtos) {
		super(valorTotal, data, conta);
		this.tipo = tipo;
		this.produtos = produtos;
	}
}
