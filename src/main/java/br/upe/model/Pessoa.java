package br.upe.model;

import java.util.ArrayList;

//import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
//@Builder
@Data
@NoArgsConstructor
public abstract class Pessoa {
	
	private String nome; 
	private String cpf;
	private ArrayList<String> acesso;
}
