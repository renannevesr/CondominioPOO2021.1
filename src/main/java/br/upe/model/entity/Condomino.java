package br.upe.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class Condomino extends Pessoa{
	
	@OneToMany(mappedBy = "condomino", cascade={CascadeType.PERSIST})
	private List<Apartamento> apartamentos = new ArrayList<Apartamento>();
	private String contato;

}
