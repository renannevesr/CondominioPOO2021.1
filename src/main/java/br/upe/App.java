package br.upe;

import java.util.ArrayList;

import br.upe.dao.PessoaDAO.JPAPessoaDAO;
import br.upe.dao.VeiculoDAO.JPAVeiculoDAO;
import br.upe.model.Morador;
import br.upe.model.Veiculo;
import br.upe.model.Visitante;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Condomínio UPE");
        
        //JPAPessoaDAO jpaPessoaDAO = new JPAPessoaDAO();
        JPAVeiculoDAO jpaVeiculoDAO = new JPAVeiculoDAO();
        
       // Visitante visitante1 = new Visitante (null, "Teste", "123456789", null, 102);
        //Veiculo v1 = new Veiculo (null, "KKK-0008", "Celta", "Preto");
        
        //jpaPessoaDAO.salva(visitante1);
        //jpaVeiculoDAO.salva(v1);
        jpaVeiculoDAO.lista();
        /*ArrayList<String> acesso = new ArrayList();
        acesso.add("1");
        Morador morador1 = new Morador (null, "Teste", "123456789", acesso );
        
		jpaPessoaDAO.salva(morador1);*/   
		//jpaPessoaDAO.lista();
    }

}
