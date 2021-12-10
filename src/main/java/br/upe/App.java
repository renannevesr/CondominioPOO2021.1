package br.upe;

import java.util.Date;

import br.upe.controller.FuncionarioController;
import br.upe.controller.UsuarioController;
import br.upe.model.dao.FuncionarioDAO;
import br.upe.model.dao.FuncionarioDAO.JPAFuncionarioDAO;
import br.upe.model.dao.PessoaDAO;
import br.upe.model.dao.PessoaDAO.JPAPessoaDAO;
import br.upe.model.entity.Funcionario;
import br.upe.model.entity.Usuario;


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
        
        //@SuppressWarnings("deprecation")
        //Funcionario novoFuncionario = new Funcionario(new Date(120, 10, 20), "209885", "Porteiro");
        //novoFuncionario.setNome("Dudu");
        //novoFuncionario.setCpf("12786461945");
        //FuncionarioController funcionario = new FuncionarioController();
        //funcionario.cadastrar(novoFuncionario);
        
        //JPAFuncionarioDAO dao = new JPAFuncionarioDAO(); 
        //Funcionario novoFuncionario = dao.buscarPorId(1l);

        
//        Usuario novoUsuario = new Usuario(null, "dev1234", novoFuncionario, null);
  //      novoUsuario.setUser(novoFuncionario);
    //    UsuarioController usuario = new UsuarioController();
      //  usuario.cadastrar(novoUsuario);
        
        PessoaDAO dao = new JPAPessoaDAO();
        System.out.println(dao.buscarCPF("12786461945"));
        
        //Condominio b = new Condominio(null, "Torres Gemeas", "78945698714", "Rua da Meretrix")
        		
        //Condomino b = new Condomino("(81) - 9 9845-7989");
        //b.setNome("André da massa");
        //b.setCpf("65432185189");
        //Apartamento a = new Apartamento(null, 71, b, 432.78,"Bloco A");
        //Veiculo novoVeiculo = new Veiculo(null, "PEN-0070", "Celta", "Preto", a);
        //VeiculoService veiculo = new VeiculoService();
        //veiculo.cadastrar(novoVeiculo);
    }
    
}
