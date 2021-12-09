package br.upe;

import java.util.Date;

import br.upe.model.dao.ContaDAO.JPAContaDAO;
import br.upe.model.dao.RequisicaoProdutoDAO.JPARequisicaoProdutoDAO;
import br.upe.model.entity.Funcionario;
import br.upe.model.service.FuncionarioService;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Condomínio UPE");
        
        //Conta novaConta = new Conta();
        //Movimentacao novaMovimentacao = new Movimentacao(350.0, null, novaConta, "1", null);
             
        //JPAContaDAO contaDao = new JPAContaDAO();
        //JPARequisicaoProdutoDAO requisicaoProdutoDAO = new JPARequisicaoProdutoDAO();
        //movimentacaoDAO.salvar(novaMovimentacao);
       
        //System.out.println(requisicaoProdutoDAO.listar());
        //System.out.println(contaDao.listar());
        //System.out.println(requisicaoProdutoDAO.buscarPorId(1l).getValorTotal());
        //listar as movimentacoes por conta
        //System.out.println(contaDao.buscarPorId(1l).getMovimentacao());
        //Funcionario novoFuncionario = new Funcionario(new Date(2020, 10, 20), "201535", "Porteiro");

        System.out.println("Chama as meretrizes que a multa tá paga");
        
        @SuppressWarnings("deprecation")
        Funcionario novoFuncionario = new Funcionario(new Date(120, 10, 20), "201985", "Jardineiro");
        novoFuncionario.setNome("Tuca do degrade");
        novoFuncionario.setCpf("12345686145");
        FuncionarioService funcionario = new FuncionarioService();
        funcionario.cadastrar(novoFuncionario);
        
    }
    
}
