package br.upe.controllersJavaFX;

import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Condomino;
import lombok.Data;

@Data
public class TableCondominoAp {
	
	private int numero;
	private Blocos bloco;
	private String nome;
	private String cpf;
	private String contato;
	private Long idAp;
	private Long idCond;
	
	public TableCondominoAp(Condomino c, Apartamento a) {
		this.numero = a.getNumero();
		this.bloco = a.getBloco();
		this.idAp = a.getId();
		this.cpf = c.getCpf();
		this.nome = c.getNome();
		this.idCond = c.getId();
		this.contato = c.getContato();
	}
	
	public static Condomino toCondomino(TableCondominoAp ap) {
		Condomino c = new Condomino();
		c.setId(ap.getIdCond());
		c.setContato(ap.getContato());
		c.setCpf(ap.getCpf());
		c.setNome(ap.getNome());
		c.getApartamentos().add(TableCondominoAp.toApartamento(ap));
		return c;
	}
	
	public static Apartamento toApartamento(TableCondominoAp ap) {
		Apartamento a = new Apartamento();
		a.setBloco(ap.getBloco());
		a.setId(ap.getIdAp());
		a.setNumero(ap.getNumero());
		return a;
	}
	
}
