package br.upe.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ListaServicos extends Requisicao{

	@ManyToMany
	@JoinTable(name = "listaservicos_servicos", joinColumns =  @JoinColumn(name ="listaservicos_id"), inverseJoinColumns = @JoinColumn (name = "servico_id"))
	private List<Servico> listaservicos;

}
