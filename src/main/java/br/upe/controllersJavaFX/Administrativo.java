package br.upe.controllersJavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class Administrativo_unidade implements Initializable {

    @FXML
    private ComboBox button_unidade;
    
    @FXML
    private ComboBox button_funcionario;

    @FXML
    private ComboBox button_reserva;

    @FXML
    private ComboBox button_servico;


    @FXML
    void Select(ActionEvent event) {
    	String s = button_unidade.getSelectionModel().getSelectedItem().toString();
    	switch (s) {
    		case "Condômino":
    			// trocar tela da direita
    			System.out.println(s);
    			break;
    		case "Morador":
    			// trocar tela da direita
    			System.out.println(s);
    			break;
    		case "Visitante":
    			// trocar tela da direita
    			System.out.println(s);
    			break;
    		case "Veículo":
    			// trocar tela da direita
    			System.out.println(s);
    			break;
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list1 = FXCollections.observableArrayList("Condômino", "Morador", "Visitante", "Veículo");
		button_unidade.setItems(list1);
	}
}