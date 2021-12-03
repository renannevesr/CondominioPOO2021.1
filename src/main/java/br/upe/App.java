package br.upe;

import java.util.ArrayList;
import java.util.List;

import br.upe.dao.GenericDAO;
import br.upe.model.Apartamento;
import br.upe.model.Condomino;
import br.upe.model.ContaReceber;
import br.upe.model.Morador;
import br.upe.model.Veiculo;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Condomínio UPE");
        
        Apartamento apartamento = new Apartamento();
        Apartamento apartamento2 = new Apartamento();
        Morador morador = new Morador();
        Condomino condomino = new Condomino();
       
        GenericDAO<Apartamento> daoApartamento = new GenericDAO<Apartamento>();
        GenericDAO<ContaReceber> daoContaReceber = new GenericDAO<ContaReceber>();
        Veiculo v1 = new Veiculo ();
             
        List<Morador> listamorador = new ArrayList();
        List<Veiculo> listaVeiculo = new ArrayList();
        listamorador.add(morador);
        listaVeiculo.add(v1);
        apartamento.setMoradores(listamorador);
        apartamento.setNumero(103);
        apartamento.setCondomino(condomino);
        apartamento.setTaxaCondominio(1500);
        apartamento.setVeiculos(listaVeiculo);
        apartamento.setBloco("A");
        
        v1.setApartamento(apartamento);
        morador.setApartamento(apartamento);
        
        daoApartamento.salvarOuAtualizar(apartamento);
        daoApartamento.salvarOuAtualizar(apartamento2);
        
        ContaReceber contareceber = new ContaReceber();
        ContaReceber contareceber2 = new ContaReceber();
        contareceber.setApartamento(apartamento);
        contareceber2.setApartamento(apartamento2);
        daoContaReceber.salvarOuAtualizar(contareceber);
        daoContaReceber.salvarOuAtualizar(contareceber2);
        

        
    }
    
}
