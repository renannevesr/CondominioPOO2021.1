package br.upe.controllersJavaFX;

import java.io.IOException;

import javax.persistence.NoResultException;

import br.upe.App;
import br.upe.controller.FuncionarioController;
import br.upe.model.entity.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
	
	
	
	@FXML
	private TextField user;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button login_button;
	
	@FXML
    private void switchToHome() throws IOException {
		String login = this.user.getText();
		String password = this.password.getText();
		try {
			if(login.isEmpty() || password.isEmpty()) {
				Alerts.showAlert("Login", "Login2", "Preencha todos os campos sua besta!", AlertType.ERROR);
			}else {
				FuncionarioController funcController = new FuncionarioController();
				Funcionario f = funcController.buscaCPF(login);
				if(f.getSenha().equals(password)) {
					App.setRoot("home");
				}else{
					Alerts.showAlert("Login", "Login2", "Login ou senha incorreta burro!", AlertType.ERROR);
				}
			}
			
		}catch(NoResultException result) {
			Alerts.showAlert("Login", "Login2", "Login ou senha incorreta burro!", AlertType.ERROR);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }

}
