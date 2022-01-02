package br.upe.controllersJavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Administrativo implements Initializable {

    @FXML
    private ComboBox<String> button_unidade;

    @FXML
    private ComboBox<String> button_servico;
    
    @FXML
    private Button btn_funcionario;
    
    @FXML
    private Button btn_reserva;
   

    @FXML
    void Select(ActionEvent event) throws IOException {
    	String opcaoUnidade = button_unidade.getSelectionModel().getSelectedItem().toString();
    	switch (opcaoUnidade) {
    		case "Condômino":
    			switchScreen("administrativo_condomino");
    			break;
    		case "Morador":
    			// trocar tela da direita
    			switchScreen("administrativo_morador");
    			break;
    		case "Visitante":
    			// trocar tela da direita
    			switchScreen("administrativo_visitante");
    			break;
    		case "Veículo":
    			// trocar tela da direita
    			switchScreen("administrativo_veiculo");
    			break;
    	}
    
    }
    
    @FXML
    void switchToFuncionario(MouseEvent event) throws IOException {
    	switchScreen("administrativo_funcionario");

    }
    
    @FXML
    void switchToReserva(MouseEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list1 = FXCollections.observableArrayList("Condômino", "Morador", "Visitante", "Veículo");

		ObservableList<String> list2 = FXCollections.observableArrayList("Serviço geral", "Serviço de produto");

		button_unidade.setItems(list1);
		button_servico.setItems(list2);

		
	}
	
	public void switchScreen(String screen) throws IOException {
		Stage stage;
        Parent root;
        
        stage = (Stage) button_unidade.getScene().getWindow();
        root = App.loadFXML(screen);
        Scene scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
	}
}