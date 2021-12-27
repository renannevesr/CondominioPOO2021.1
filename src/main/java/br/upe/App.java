package br.upe;

import java.io.IOException;
import java.nio.file.Paths;

import br.upe.migrations.Migration;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

//public class App {
public class App extends Application {

    private static Scene scene;
  
    @Override
    public void start(Stage stage) throws IOException {
    	music();
    	scene = new Scene(loadFXML("login"), 700, 500);
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    MediaPlayer mediaPlayer;
	public void music() {
		String s = "./mp3/login_music.mp3";
		Media h = new Media(Paths.get(s).toUri().toString());
		mediaPlayer = new MediaPlayer(h);
		mediaPlayer.setVolume(0.01);
//		mediaPlayer.play();
	}
	
    public static void main(String[] args) throws Exception {
    	Migration.init();
    
    	launch();
//        System.out.println("Condomínio UPE");
//
        
//        
//        JPAPessoaDAO dao = new JPAPessoaDAO(); 
//
//        Funcionario novoFuncionario =  (Funcionario) dao.buscarCPF(new Funcionario(), "12786461945");
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