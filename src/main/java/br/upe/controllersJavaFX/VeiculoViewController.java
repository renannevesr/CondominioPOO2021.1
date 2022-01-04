package br.upe.controllersJavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.upe.App;
import br.upe.controller.ApartamentoController;
import br.upe.controller.VeiculoController;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Veiculo;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VeiculoViewController implements Initializable{
	
	ApartamentoController apartamentoController = new ApartamentoController();
	VeiculoController veiculoController = new VeiculoController();
	
	private ObservableList<TableVeiculoAp> select;

    @FXML
    private TableView<TableVeiculoAp> veiculoTable;

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
    private ImageView user;
    
    @FXML
    void logout(MouseEvent event) throws IOException {
    	if (Alerts.alertConfirmation("Desejar sair do sistema?", null)) {
    		switchScreen("login");
    	}
    }
    
    @FXML
    void switchToReserva(MouseEvent event) {

    }
    

    @FXML
    void EditarVeiculo(MouseEvent event) {
    	this.select = veiculoTable.getSelectionModel().getSelectedItems();
    	this.placa.setText(this.select.get(0).getPlaca());
    	this.cor.setText(this.select.get(0).getCor());
    	this.modelo.setText(this.select.get(0).getModelo());
    	this.bloco_set.setValue(this.select.get(0).getBloco());
    	this.unidade_set.setValue(this.select.get(0).getNumero());
    }

    @FXML
    void ExcluirVeiculo(MouseEvent event) {

    }

    @FXML
    void PesquisaAp(MouseEvent event) {

    }

    @FXML
    void salvarVeiculo(MouseEvent event) throws IOException {
    	if (this.select == null || this.select.isEmpty()) {
    		veiculoTable.getSelectionModel().clearSelection();
    		cadastrarVeiculo();
    	} else {
    		editarVeiculo(veiculoTable.getSelectionModel().getSelectedItem().getIdVeiculo());
    	}
    	
    	veiculoTable.getSelectionModel().clearSelection();
    }
    
    private void cadastrarVeiculo() throws IOException{
    	String placa = this.placa.getText();
    	String cor = this.cor.getText();
    	String modelo = this.modelo.getText();
    	
    	int numero = 0;
		if (this.unidade_set.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.unidade_set.getSelectionModel().getSelectedItem();

		Blocos bloco = (Blocos) this.bloco_set.getSelectionModel().getSelectedItem();
		
		try {
			if (placa == null || cor == null || modelo == null|| bloco == null || numero == 0) {
				Alerts.alertError("Seu burro, sua anta, preencha tudo sua misera!");
			} 
			else {
		
				Apartamento ap = new Apartamento();
				ap = apartamentoController.buscarApartamento(bloco, numero).get(0);
				System.out.println(ap);
				Veiculo veiculo = new Veiculo (null, placa, modelo, cor, ap);
				veiculoController.cadastrar(veiculo);
				Alerts.alertSuccess("Veiculo cadastrado com sucesso!");
				limpaTela();
				atualizaTabela();
				}
				
				
					
		}
		catch (Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Veiculo!\n" + (e.getMessage()));
		}
    }
    
    private void editarVeiculo(Long id) {
    	String placa = this.placa.getText();
    	String cor = this.cor.getText();
    	String modelo = this.modelo.getText();
    	
    	int numero = 0;
		if (this.unidade_set.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.unidade_set.getSelectionModel().getSelectedItem();

		Blocos bloco = (Blocos) this.bloco_set.getSelectionModel().getSelectedItem();
		
		try {
			if (placa == null || cor == null || modelo == null || bloco == null || numero == 0) {
				Alerts.alertError("Seu burro, sua anta, preencha tudo sua misera!");
			}else {
				Veiculo v = veiculoController.buscarPorId(id);
				Apartamento ap = new Apartamento();
				ap = apartamentoController.buscarApartamento(bloco, numero).get(0);
				v.setCor(cor);
				v.setModelo(modelo);
				v.setPlaca(placa);
				v.setApartamento(ap);
				veiculoController.atualizar(v);
				Alerts.alertSuccess("Veiculo atualizado com sucesso!");
				limpaTela();
				atualizaTabela();
			}
			
		}catch(Exception e) {
			Alerts.alertError("Erro ao tentar atualizar esse Veiculo!\n" + (e.getMessage()));
		}
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
			  	limpaTela();
				carregarTableView();
				atualizaTabela();
		}
		  
		    private void atualizaTabela() {
		    	try {
					this.veiculoTable.setItems(FXCollections.observableArrayList(listVeiculoAp()));
				} catch (Exception e) {
					e.printStackTrace();
			}
		    }
		    
		    private void limpaTela() {
				this.placa.setText(null);
				this.modelo.setText(null);
				this.cor.setText(null);
				this.bloco_set.setValue(null);
				this.unidade_set.setValue(null);
			}
		  
		 List<Veiculo> listVeiculo = new ArrayList<Veiculo>();
		    
		    private List<TableVeiculoAp> listVeiculoAp(){
		    	List<TableVeiculoAp> listVeiculoAp = new ArrayList<TableVeiculoAp>();
		    	
		    	try {
		    		this.listVeiculo =  veiculoController.listar();
		    	}catch(Exception e) {
		    		
		    	}
		    	
		    	for(Veiculo v: listVeiculo) {
		    		listVeiculoAp.add(new TableVeiculoAp(v ,v.getApartamento()));
		    	}
		    	return listVeiculoAp;
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
		    	
		    	tablePlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
				tableModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
				tableCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
				tableBloco.setCellValueFactory(new PropertyValueFactory<>("bloco"));
				tableUnidade.setCellValueFactory(new PropertyValueFactory<>("numero"));
		    	
		    	num_AP.setItems(list1);
		    	bloco_AP.setItems(list2);
		    	bloco_set.setItems(list6);
		    	unidade_set.setItems(list5);
		    	
		    }


}
