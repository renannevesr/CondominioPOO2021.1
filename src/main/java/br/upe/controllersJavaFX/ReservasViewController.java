package br.upe.controllersJavaFX;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.upe.App;
import br.upe.controller.ApartamentoController;
import br.upe.controller.ReservasController;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Espacos;
import br.upe.model.entity.Reservas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ReservasViewController implements Initializable{
	
	ApartamentoController apartamentoController = new ApartamentoController();
	ReservasController reservaController = new ReservasController();
	
	private ObservableList<TableReservaAp> select;

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
    private TableView<TableReservaAp> reservaTable;

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
    void EditarReserva(MouseEvent event) {
    	this.select = reservaTable.getSelectionModel().getSelectedItems();
    	this.espaco.setValue(this.select.get(0).getEspaco());
    	this.dataUtilizacao.setValue(this.select.get(0).getDataUtilizacao());
    	String valorText = Double.toString(this.select.get(0).getValor());		
    	this.valor.setText(valorText);
    	this.bloco_set.setValue(this.select.get(0).getBloco());
    	this.unidade_set.setValue(this.select.get(0).getNumero());
    }

    @FXML
    void ExcluirReserva(MouseEvent event) {
    	if(Alerts.alertConfirmation("Excluir", "Deseja prosseguir com a operação?")) {
			excluirReserva();
		}
    	limpaTela();
		atualizaTabela();
    }
    
    private void excluirReserva() {
    	try {
    		reservaController.remover(reservaTable.getSelectionModel().getSelectedItem().getIdReserva());
    		Alerts.alertSuccess("Reserva deletada com sucesso!");
    	}catch(Exception e) {
    		Alerts.alertError("Não foi possível excluir essa reserva!");
    	}
    }

    @FXML
    void PesquisaAp(MouseEvent event) {

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
		Scene scene;

		stage = (Stage) button_unidade.getScene().getWindow();
		root = App.loadFXML(screen);
		 if (screen.equals("login")) {
	        	scene = new Scene(root, 700, 500);
	        }else {
	        	scene = new Scene(root, 1280, 720);
	        }
		stage.setScene(scene);
		stage.show();
	}


    @FXML
    void logout(MouseEvent event) throws IOException {
    	if (Alerts.alertConfirmation("Desejar sair do sistema?", null)) {
    		switchScreen("login");
    	}
    }

    @FXML
    void salvarReserva(MouseEvent event) throws IOException {
    	if (this.select == null || this.select.isEmpty()) {
			reservaTable.getSelectionModel().clearSelection();
			cadastrarReserva();
		} else {
			atualizarReserva(reservaTable.getSelectionModel().getSelectedItem().getIdReserva());
		}
		reservaTable.getSelectionModel().clearSelection();
    }
    
    private void cadastrarReserva() throws IOException {
    	Espacos espaco = this.espaco.getSelectionModel().getSelectedItem();
    	double valor = Double.parseDouble(this.valor.getText());
    	LocalDate dataUtilizacao = this.dataUtilizacao.getValue();

    	int numero = 0;
		if (this.unidade_set.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.unidade_set.getSelectionModel().getSelectedItem();

		Blocos bloco = (Blocos) this.bloco_set.getSelectionModel().getSelectedItem();
    	try {
    		
    		if(espaco == null || dataUtilizacao == null) {
    			Alerts.alertError("Seu burro, sua anta, preencha tudo sua misera!");
    		}else {
    			Reservas reserva = new Reservas();
    			Apartamento ap = apartamentoController.buscarApartamento(bloco, numero).get(0);
    			reserva.setDataEmissao(new Date());
    			reserva.setDataUtilizacao(dataUtilizacao);
    			reserva.setEspaco(espaco);
    			reserva.setValor(valor);
    			reserva.setApartamento(ap);
    			reservaController.cadastrar(reserva);
    			Alerts.alertSuccess("Reserva cadastrada com sucesso!");
    		}
    		
    		limpaTela();
    		atualizaTabela();
    		
    	}catch (Exception e) {
    		Alerts.alertError("Erro ao tentar cadastrar essa Reserva!\n" + (e.getMessage()
					.compareTo("org.hibernate.exception.ConstraintViolationException: could not execute statement") == 0
							? "Já existe uma reserva nesse local e data!"
							: e.getMessage()));
    	}
    	
    }
    
    private void atualizarReserva(Long id) throws IOException {
    	Espacos espaco = this.espaco.getSelectionModel().getSelectedItem();
    	double valor = Double.parseDouble(this.valor.getText());
    	LocalDate dataUtilizacao = this.dataUtilizacao.getValue();

    	int numero = 0;
		if (this.unidade_set.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.unidade_set.getSelectionModel().getSelectedItem();

		Blocos bloco = (Blocos) this.bloco_set.getSelectionModel().getSelectedItem();
    	try {
    		if(espaco == null || dataUtilizacao == null) {
    			Alerts.alertError("Seu burro, sua anta, preencha tudo sua misera!");
    		}else {
    			System.out.println(id);
    		Reservas reserva = reservaController.buscarPorId(id);
    		System.out.println("Reserva resgatada: " + reserva);
    		Apartamento ap = apartamentoController.buscarApartamento(bloco, numero).get(0);
    		reserva.setApartamento(ap);
    		reserva.setDataUtilizacao(dataUtilizacao);
    		reserva.setValor(valor);
    		reserva.setEspaco(espaco);
    		reservaController.atualizar(reserva);
    		Alerts.alertSuccess("Reserva atualizada com sucesso!");
			limpaTela();
			atualizaTabela();
    		}
    	}catch(Exception e) {
    		Alerts.alertError("Erro ao tentar atualizar essa Reserva!\n" + (e.getMessage()));
    	}
    }
    
    

    @FXML
    void switchToAlmoxarifado(MouseEvent event) throws IOException {
    	switchScreen("almoxarifado");
    }

    @FXML
    void switchToContabil(MouseEvent event) throws IOException {
    	switchScreen("contabil");
    }

    @FXML
    void switchToFuncionario(MouseEvent event) throws IOException {
    	switchScreen("administrativo_funcionario");
    }

    @FXML
    void switchToReserva(MouseEvent event) {
    	
    }
    
    private void atualizaTabela() {
    	try {
			this.reservaTable.setItems(FXCollections.observableArrayList(listReservaAp()));
		} catch (Exception e) {
			e.printStackTrace();
	}
    }
    
    private void limpaTela() {
		this.valor.setText(null);
		this.dataUtilizacao.setValue(null);
		this.bloco_set.setValue(null);
		this.unidade_set.setValue(null);
		this.espaco.setValue(null);
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarTableView();
		atualizaTabela();
	}
	
	  List<Reservas> listReservas = new ArrayList<Reservas>();
	    
	    private List<TableReservaAp> listReservaAp(){
	    	List<TableReservaAp> listReservaAp = new ArrayList<TableReservaAp>();
	    	
	    	try {
	    		this.listReservas =  reservaController.listar();
	    	}catch(Exception e) {
	    		
	    	}
	    	
	    	for(Reservas r: listReservas) {
	    		listReservaAp.add(new TableReservaAp(r ,r.getApartamento()));
	    	}
	    	return listReservaAp;
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
		
		ObservableList<TableReservaAp> list3 = FXCollections.observableArrayList(listReservaAp());
    	
		tableEspaco.setCellValueFactory(new PropertyValueFactory<>("espaco"));
		tableData.setCellValueFactory(new PropertyValueFactory<>("dataUtilizacao"));
		tableValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		tableBloco.setCellValueFactory(new PropertyValueFactory<>("bloco"));
		tableUnidade.setCellValueFactory(new PropertyValueFactory<>("numero"));
		
		reservaTable.setItems(list3);
	}


}
