package br.upe;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
	
    private static Scene scene;
    
    @Override
    public void start(Stage stage) throws IOException {
    	scene = new Scene(loadFXML("login"), 700, 500);
    	stage.setScene(scene);
    	stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
	
    public static void main(String[] args) throws Exception {
    	launch();
//        System.out.println("Condomínio UPE");
//
//        Funcionario novoFuncionario = new Funcionario(new Date(120, 10, 20), "209885", FuncaoFuncionario.PORTEIRO);
//        novoFuncionario.setNome("Dudu");
//        novoFuncionario.setCpf("12569998821");
//        FuncionarioController funcionario = new FuncionarioController();
//        //funcionario.cadastrar(novoFuncionario);
//        
//        JPAPessoaDAO dao = new JPAPessoaDAO(); 
//
//        //Funcionario novoFuncionario =  (Funcionario) dao.buscarCPF(new Funcionario(), "12786461945");
//        Usuario novoUsuario = new Usuario(null, "dev1234", novoFuncionario, null);
//        novoUsuario.setUser(novoFuncionario);
//        UsuarioController usuario = new UsuarioController();
//        //usuario.cadastrar(novoUsuario);
//       
//        Espaco e = new Espaco(null, Espacos.ACADEMIA, "oi");
//        JPAEspacoDAO daoE = new JPAEspacoDAO();
//        //daoE.salvar(e);
//        
//        System.out.print(daoE.buscarPorId(1l));
//
//        Reservas r = new Reservas ();
//       // r.setEspaco(novoEspaco);
//        r.setValor(200.0);
//        DateFormat f = DateFormat.getDateInstance();
//        //Date data2 = f.parse("20/12/2021");
//        r.setDataUtilizacao(new Date(2021, 12, 20));
//        
//        ReservasController rc = new ReservasController();
//       // rc.cadastrar(r);
//        JPAReservasDAO daoR = new JPAReservasDAO();
//       // System.out.println(daoR.buscarPorId(1l).getDataEmissao());
//        
//        
//        
//        //Reservas r = new Reservas (null, new Date(), null, 200.0, null  null, novoEspaco, new Date());
//        
//        //Condominio b = new Condominio(null, "Torres Gemeas", "78945698714", "Rua da Meretrix")
//        		
//        //Condomino b = new Condomino("(81) - 9 9845-7989");
//        //b.setNome("André da massa");
//        //b.setCpf("65432185189");
//  
//        ApartamentoController dao2 = new ApartamentoController();
//        Apartamento a = new Apartamento(null, 72, null, 432.78, Blocos.C);
      //  dao2.cadastrar(a);
        //Veiculo novoVeiculo = new Veiculo(null, "PEN-0070", "Celta", "Preto", a);
        //VeiculoService veiculo = new VeiculoService();
        //veiculo.cadastrar(novoVeiculo);
        
    }
    
}