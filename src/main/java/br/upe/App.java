package br.upe;

import br.upe.dao.ContaDAO.JPAContaDAO;
import br.upe.dao.RequisicaoProdutoDAO.JPARequisicaoProdutoDAO;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Condomínio UPE");
        
        //Conta novaConta = new Conta();
        //Movimentacao novaMovimentacao = new Movimentacao(350.0, null, novaConta, "1", null);
             
        JPAContaDAO contaDao = new JPAContaDAO();
        JPARequisicaoProdutoDAO requisicaoProdutoDAO = new JPARequisicaoProdutoDAO();
        //movimentacaoDAO.salvar(novaMovimentacao);
       
        System.out.println(requisicaoProdutoDAO.listar());
        System.out.println(contaDao.listar());
        System.out.println(requisicaoProdutoDAO.buscarPorId(1l).getValorTotal());
        //listar as movimentacoes por conta
        System.out.println(contaDao.buscarPorId(1l).getMovimentacao());
        
        System.out.println("Chama as meretrizes que a multa tá paga");
        
    }
    
}
