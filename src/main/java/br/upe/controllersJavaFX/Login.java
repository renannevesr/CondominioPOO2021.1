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
				Alerts.alertError("Não pode deixar campo em branco seu burro!");
			}else {
				FuncionarioController funcController = new FuncionarioController();
				Funcionario f = funcController.buscaCPF(login);
				if(f.getSenha().equals(password)) {
					Alerts.alertSuccess("Bem vindo, " + f.getNome() + "!");
					App.setRoot("administrativo");
				}else{
					Alerts.alertError("Login e/ou senha incorreto(a) sua besta!");
				}
			}
			
		}catch(NoResultException result) {
			Alerts.alertError("Login e/ou senha incorreto(a) sua besta!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
    }

}
