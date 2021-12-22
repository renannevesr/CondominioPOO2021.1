package br.upe.controllersJavaFX;

//import java.awt.Desktop.Action;
import java.io.IOException;

import javax.persistence.NoResultException;

import br.upe.App;
import br.upe.controller.FuncionarioController;
import br.upe.model.entity.Funcionario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

//public class Login extends Application {
public class Login{
	
	private Parent parent;
    private Stage stage;
    private Scene scene;
	
	@FXML
	private TextField user;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button login_button;
	
//	@Override
//    public void start(Stage stage) throws IOException {
//    	scene = new Scene(App.loadFXML("administrativo"), 1280, 720);
//    	stage.setScene(scene);
//    	stage.setResizable(false);
//    	stage.show();
//    }
	
//	@FXML
    public void switchToHome(ActionEvent event) throws IOException {
		
		String login = this.user.getText();
		String password = this.password.getText();
		try {
			if(login.isEmpty() || password.isEmpty()) {
				Alerts.alertError("Não pode deixar campo em branco seu burro!");
			}
			else {
				FuncionarioController funcController = new FuncionarioController();
				Funcionario f = funcController.buscaCPF(login);
				if(f.getSenha().equals(password)) {
					Alerts.alertSuccess("Bem vindo, " + f.getNome() + "!");
					
					
					Stage stage;
			        Parent root;
			        
			        stage = (Stage) login_button.getScene().getWindow();
			        root = App.loadFXML("administrativo");
			        Scene scene = new Scene(root, 1280, 720);
			        stage.setScene(scene);
			        stage.show();
					
				}
				else{
					Alerts.alertError("Login e/ou senha incorreto(a) sua besta!");
				}
			}
			
		}
		catch(NoResultException result) {
			Alerts.alertError("Login e/ou senha incorreto(a) sua besta!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }
    
//    public void launchLoginScene(Stage stage) {
//        this.stage = stage;
//         stage.setScene(scene);
//         stage.setResizable(true);
//
//         stage.widthProperty().addListener(new ChangeListener<Number>() {
//             @Override
//             public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
//                 setCurrentWidthToStage(number2); 
//             }
//    });

}
