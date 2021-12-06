package br.upe;

import br.upe.dao.ContaDAO.JPAContaDAO;
import br.upe.dao.MovimentacaoDAO.JPAMovimentacaoDAO;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Condomínio UPE");
        
        //Conta novaConta = new Conta();
        //Movimentacao novaMovimentacao = new Movimentacao(350.0, null, novaConta, "1", null);
             
        JPAContaDAO contaDao = new JPAContaDAO();
        JPAMovimentacaoDAO movimentacaoDAO = new JPAMovimentacaoDAO();
        //movimentacaoDAO.salvar(novaMovimentacao);
       
        System.out.println(movimentacaoDAO.listar());
        System.out.println(contaDao.listar());
        System.out.println(movimentacaoDAO.buscarPorId(1l).getValorTotal());
        //listar as movimentacoes por conta
        System.out.println(contaDao.buscarPorId(1l).getMovimentacao());
        
    }
    
}
