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
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Administrativo implements Initializable {

    @FXML
    private ComboBox button_unidade;

    @FXML
    private ComboBox button_reserva;

    @FXML
    private ComboBox button_servico;
    
    @FXML
    private ComboBox button_funcionario;


    @FXML
    void Select(ActionEvent event) throws IOException {
    	String opcaoUnidade = button_unidade.getSelectionModel().getSelectedItem().toString();
    	switch (opcaoUnidade) {
    		case "Condômino":
    			switchScreen("administrativo_condomino");
    			break;
    		case "Morador":
    			// trocar tela da direita
    			System.out.println(opcaoUnidade);
    			break;
    		case "Visitante":
    			// trocar tela da direita
    			System.out.println(opcaoUnidade);
    			break;
    		case "Veículo":
    			// trocar tela da direita
    			System.out.println(opcaoUnidade);
    			break;
    	}
    	
    	String opcaoReserva = button_reserva.getSelectionModel().getSelectedItem().toString();
    	switch (opcaoReserva) {
    		case "Espaços":
    			// trocar tela da direita
    			System.out.println(opcaoReserva);
    			break;
    		case "Nova reserva":
    			// trocar tela da direita
    			System.out.println(opcaoReserva);
    			break;
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list1 = FXCollections.observableArrayList("Condômino", "Morador", "Visitante", "Veículo");
		ObservableList<String> list2 = FXCollections.observableArrayList("Espaços", "Nova reserva");
		ObservableList<String> list3 = FXCollections.observableArrayList("Serviço geral", "Serviço de produto");
		ObservableList<String> list4 = FXCollections.observableArrayList("Novo funcionário", "Procurar funcionario");
		
		button_unidade.setItems(list1);
		button_reserva.setItems(list2);
		button_servico.setItems(list3);
		button_funcionario.setItems(list4);
		
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