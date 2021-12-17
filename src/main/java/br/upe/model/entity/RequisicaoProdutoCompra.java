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
	/*@OneToMany 
	@JoinColumn(name="reqProdutoCompra_id")
	private List<Produto> produtos;*/
	@OneToMany 
	@JoinColumn(name="reqProdutoCompra_id")
	private List<Item> produtos;
	
	public double getValorTotal() {
		double valor = 0;
		
		for(Item listaproduto: produtos) {
			valor += listaproduto.getValor()*listaproduto.getQuantidade();
		}
		
		return valor;
	}

	public RequisicaoProdutoCompra(Double valorTotal, Date data, Conta conta, String tipo, List<Item> produtos) {
		super(valorTotal, data, conta);
		this.tipo = tipo;
		this.produtos = produtos;
	}
}
