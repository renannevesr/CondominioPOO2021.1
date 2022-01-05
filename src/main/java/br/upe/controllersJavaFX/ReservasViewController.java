package br.upe.controllersJavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import br.upe.model.entity.Blocos;
import br.upe.model.entity.Espacos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ReservasViewController implements Initializable{

    @FXML
    private ComboBox<Blocos> bloco_AP;

    @FXML
    private ComboBox<Blocos> bloco_set;

    @FXML
    private Button btn_excluir;

    @FXML
    private Button btn_funcionario;

    @FXML
    private Button btn_reserva;

    @FXML
    private ComboBox<String> button_servico;

    @FXML
    private ComboBox<String> button_unidade;

    @FXML
    private TableView<?> condominoTable;

    @FXML
    private DatePicker dataUtilizacao;

    @FXML
    private ComboBox<Espacos> espaco;

    @FXML
    private ComboBox<Integer> num_AP;

    @FXML
    private TableColumn<?, ?> tableBloco;

    @FXML
    private TableColumn<?, ?> tableData;

    @FXML
    private TableColumn<?, ?> tableEspaco;

    @FXML
    private TableColumn<?, ?> tableUnidade;

    @FXML
    private TableColumn<?, ?> tableValor;

    @FXML
    private ComboBox<Integer> unidade_set;

    @FXML
    private ImageView user;

    @FXML
    private TextField valor;

    @FXML
    void EditarCondomino(MouseEvent event) {

    }

    @FXML
    void ExcluirCondomino(MouseEvent event) {

    }

    @FXML
    void PesquisaAp(MouseEvent event) {

    }

    @FXML
    void Select(ActionEvent event) {

    }

    @FXML
    void logout(MouseEvent event) {

    }

    @FXML
    void salvarCondomino(MouseEvent event) {

    }

    @FXML
    void switchToAlmoxarifado(MouseEvent event) {

    }

    @FXML
    void switchToContabil(MouseEvent event) {

    }

    @FXML
    void switchToFuncionario(MouseEvent event) {

    }

    @FXML
    void switchToReserva(MouseEvent event) {

    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarTableView();
	}
	
	public void carregarTableView() {
		ObservableList<String> listUni = FXCollections.observableArrayList("Condômino", "Morador", "Visitante",
				"Veículo");
		
		ObservableList<Espacos> listEspaco = FXCollections.observableArrayList(Espacos.values());

		ObservableList<String> listServico = FXCollections.observableArrayList("Serviço geral", "Serviço de produto");

		button_unidade.setItems(listUni);
		button_servico.setItems(listServico);
		ObservableList<Integer> list1 = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		ObservableList<Blocos> list2 = FXCollections.observableArrayList(Blocos.values());
		ObservableList<Integer> list5 = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		ObservableList<Blocos> list6 = FXCollections.observableArrayList(Blocos.A, Blocos.B, Blocos.C);

		num_AP.setItems(list1);
		bloco_AP.setItems(list2);
		bloco_set.setItems(list6);
		unidade_set.setItems(list5);
		espaco.setItems(listEspaco);
	}


}
