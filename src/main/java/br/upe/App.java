package br.upe;

import java.text.DateFormat;
import java.util.Date;

import br.upe.controller.ApartamentoController;
import br.upe.controller.FuncionarioController;
import br.upe.controller.ReservasController;
import br.upe.controller.UsuarioController;
import br.upe.model.dao.EspacoDAO.JPAEspacoDAO;
import br.upe.model.dao.PessoaDAO.JPAPessoaDAO;
import br.upe.model.dao.ReservasDAO.JPAReservasDAO;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Espaco;
import br.upe.model.entity.Espacos;
import br.upe.model.entity.FuncaoFuncionario;
import br.upe.model.entity.Funcionario;
import br.upe.model.entity.Reservas;
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
        Funcionario novoFuncionario = new Funcionario(new Date(120, 10, 20), "209885", FuncaoFuncionario.PORTEIRO);
        novoFuncionario.setNome("Dudu");
        novoFuncionario.setCpf("12569998821");
        FuncionarioController funcionario = new FuncionarioController();
        //funcionario.cadastrar(novoFuncionario);
        
        JPAPessoaDAO dao = new JPAPessoaDAO(); 

        //Funcionario novoFuncionario =  (Funcionario) dao.buscarCPF(new Funcionario(), "12786461945");
        Usuario novoUsuario = new Usuario(null, "dev1234", novoFuncionario, null);
        novoUsuario.setUser(novoFuncionario);
        UsuarioController usuario = new UsuarioController();
        //usuario.cadastrar(novoUsuario);
       
        Espaco e = new Espaco(null, Espacos.ACADEMIA, "oi");
        JPAEspacoDAO daoE = new JPAEspacoDAO();
        //daoE.salvar(e);
        
        System.out.print(daoE.buscarPorId(1l));

        Reservas r = new Reservas ();
       // r.setEspaco(novoEspaco);
        r.setValor(200.0);
        DateFormat f = DateFormat.getDateInstance();
        //Date data2 = f.parse("20/12/2021");
        r.setDataUtilizacao(new Date(2021, 12, 20));
        
        ReservasController rc = new ReservasController();
       // rc.cadastrar(r);
        JPAReservasDAO daoR = new JPAReservasDAO();
       // System.out.println(daoR.buscarPorId(1l).getDataEmissao());
        
        
        
        //Reservas r = new Reservas (null, new Date(), null, 200.0, null  null, novoEspaco, new Date());
        
        //Condominio b = new Condominio(null, "Torres Gemeas", "78945698714", "Rua da Meretrix")
        		
        //Condomino b = new Condomino("(81) - 9 9845-7989");
        //b.setNome("André da massa");
        //b.setCpf("65432185189");
  
        ApartamentoController dao2 = new ApartamentoController();
        Apartamento a = new Apartamento(null, 72, null, 432.78, Blocos.C);
      //  dao2.cadastrar(a);
        //Veiculo novoVeiculo = new Veiculo(null, "PEN-0070", "Celta", "Preto", a);
        //VeiculoService veiculo = new VeiculoService();
        //veiculo.cadastrar(novoVeiculo);
    }
    
}
