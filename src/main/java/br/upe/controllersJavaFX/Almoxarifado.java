package br.upe.controllersJavaFX;

import java.io.IOException;

import br.upe.App;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Almoxarifado {

    @FXML
    private Button btn_produto;

    @FXML
    private Button btn_requisicao;

    @FXML
    void switchToAdministrativo(MouseEvent event) throws IOException {
    	switchScreen("administrativo");
    }
    
    @FXML
    void switchToContabil(MouseEvent event) throws IOException {
    	switchScreen("contabil");
    }
    

    @FXML
    void switchToAlmoxarifado_produto(MouseEvent event) {

    }

    @FXML
    void switchToAlmoxarifado_requisicao(MouseEvent event) {

    }

    @FXML
    void logout(MouseEvent event) throws IOException {
    	if (Alerts.alertConfirmation("Desejar sair do sistema?", null)) {
    		switchScreen("login");
    	}
    }

    
    public void switchScreen(String screen) throws IOException {
		Stage stage;
        Parent root;
        Scene scene;
        
        stage = (Stage) btn_produto.getScene().getWindow();
        root = App.loadFXML(screen);
        if (screen.equals("login")) {
        	scene = new Scene(root, 700, 500);
        }else {
        	scene = new Scene(root, 1280, 720);
        }
        stage.setScene(scene);
        stage.show();
	}
}
