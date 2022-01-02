package br.upe.controllersJavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.App;
import br.upe.model.entity.Blocos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VeiculoViewController implements Initializable{

    @FXML
    private TableView<?> VeiculoTable;

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
    private TextField cor;

    @FXML
    private TextField modelo;

    @FXML
    private ComboBox<Integer> num_AP;

    @FXML
    private TextField placa;

    @FXML
    private TableColumn<?, ?> tableBloco;

    @FXML
    private TableColumn<?, ?> tableCor;

    @FXML
    private TableColumn<?, ?> tableModelo;

    @FXML
    private TableColumn<?, ?> tablePlaca;

    @FXML
    private TableColumn<?, ?> tableUnidade;

    @FXML
    private ComboBox<Integer> unidade_set;

    @FXML
    void switchToReserva(MouseEvent event) {

    }

    @FXML
    void EditarVeiculo(MouseEvent event) {

    }

    @FXML
    void ExcluirVeiculo(MouseEvent event) {

    }

    @FXML
    void PesquisaAp(MouseEvent event) {

    }

    @FXML
    void salvarVeiculo(MouseEvent event) {

    }
    

	 @FXML
		void switchToFuncionario(MouseEvent event) throws IOException {
			switchScreen("administrativo_funcionario");
		}

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
		
		public void switchScreen(String screen) throws IOException {
			Stage stage;
			Parent root;

			stage = (Stage) button_unidade.getScene().getWindow();
			root = App.loadFXML(screen);
			Scene scene = new Scene(root, 1280, 720);
			stage.setScene(scene);
			stage.show();
		}
		
		  @Override
			public void initialize(URL location, ResourceBundle resources) {
				carregarTableView();
				//atualizaTabela();
		}
		  
		  public void carregarTableView() {
				
				ObservableList<String> listUni = FXCollections.observableArrayList("Condômino", "Morador", "Visitante",
						"Veículo");

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
		    	
		    }


}
