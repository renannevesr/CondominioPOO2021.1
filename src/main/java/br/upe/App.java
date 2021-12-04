package br.upe;

import java.util.ArrayList;
import java.util.List;

import br.upe.dao.GenericDAO;
import br.upe.dao.TipoProdutoDAO.JPATipoProdutoDAO;
import br.upe.model.Apartamento;
import br.upe.model.Condomino;
import br.upe.model.Conta;
import br.upe.model.ContaReceber;
import br.upe.model.Contabil;
import br.upe.model.Morador;
import br.upe.model.Movimentacao;
import br.upe.model.Produto;
import br.upe.model.TipoProduto;
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
        GenericDAO<Conta> daoConta = new GenericDAO<Conta>();
        GenericDAO<Contabil> daoContabil = new GenericDAO<Contabil>();
        GenericDAO<Veiculo> daoVeiculo = new GenericDAO<Veiculo>();
        Veiculo v1 = new Veiculo ();
        Conta c1 = new Conta ();
        Contabil ct1 = new Contabil();
        
        ct1.setSaldoGlobal(100);
        List<Conta> listaContas = new ArrayList();
        listaContas.add(c1);
        ct1.setContas(listaContas);
        daoContabil.salvarOuAtualizar(ct1);
       // daoConta.salvarOuAtualizar(c1);
        
        List<Morador> listamorador = new ArrayList();
        List<Veiculo> listaVeiculo = new ArrayList();
        listamorador.add(morador);
        listaVeiculo.add(v1);
     //   apartamento.setMoradores(listamorador);
        apartamento.setNumero(103);
        apartamento.setCondomino(condomino);
        apartamento.setTaxaCondominio(1500);
      //  apartamento.setVeiculos(listaVeiculo);
        apartamento.setBloco("A");
        
        v1.setApartamento(apartamento);
        morador.setApartamento(apartamento);
        
        Movimentacao m1 = new Movimentacao();
        TipoProduto tp1 = new TipoProduto();
        
        Produto p1 = new Produto ();
        p1.setTipo(tp1);
        p1.setMovimentacao(m1);
        GenericDAO<Produto> daoProduto = new GenericDAO<Produto>();
        daoProduto.salvarOuAtualizar(p1);
        
        JPATipoProdutoDAO daoTipoProduto = new JPATipoProdutoDAO();
        daoTipoProduto.listar(tp1);
        
        //System.out.println(daoProduto.listar(p1));
        daoApartamento.salvarOuAtualizar(apartamento);
        daoVeiculo.salvarOuAtualizar(v1);
        //daoApartamento.salvarOuAtualizar(apartamento2);
        
        /*ContaReceber contareceber = new ContaReceber();
        ContaReceber contareceber2 = new ContaReceber();
        contareceber.setApartamento(apartamento);
        contareceber2.setApartamento(apartamento2);
        daoContaReceber.salvarOuAtualizar(contareceber);
        daoContaReceber.salvarOuAtualizar(contareceber2);*/
        
        //System.out.println(daoApartamento.listar(new Apartamento()));
        //System.out.println(daoVeiculo.listar(new Veiculo()));
        
    }
    
}
