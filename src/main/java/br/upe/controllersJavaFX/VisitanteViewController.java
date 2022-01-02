package br.upe.controllersJavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.NoResultException;

import br.upe.App;
import br.upe.controller.ApartamentoController;
import br.upe.controller.VisitanteController;
import br.upe.model.dao.PessoaDAO.JPAPessoaDAO;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Visitante;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VisitanteViewController implements Initializable{
	VisitanteController visitanteController = new VisitanteController();
	ApartamentoController apartamentoController = new ApartamentoController();
	JPAPessoaDAO dao = new JPAPessoaDAO();

	private ObservableList<Visitante> select;

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
	private TextField cpf;

	@FXML
	private TableView<Visitante> visitanteTable;

	@FXML
	private TextField nome;

	@FXML
	private ComboBox<Integer> num_AP;

	@FXML
	private TableColumn<?, ?> tableAcoes;

	@FXML
	private TableColumn<?, ?> tableAcoes1;

	@FXML
	private TableColumn<?, ?> tableCPF;

	@FXML
	private TableColumn<?, ?> tableNome;

	@FXML
	private ComboBox<Integer> unidade_set;
	
    @FXML
    void switchToReserva(MouseEvent event) {

    }

	@FXML
	void EditarVisitante(MouseEvent event) {

	}

	@FXML
	void ExcluirVisitante(MouseEvent event) {

	}

	@FXML
	void PesquisaAp(MouseEvent event) {

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

	@FXML
	void salvarVisitante(MouseEvent event) throws IOException {

		if (this.select == null || this.select.isEmpty()) {
			visitanteTable.getSelectionModel().clearSelection();
			cadastrarVisitante(null);
		} else {
			Visitante v = new Visitante();
			v = (Visitante) visitanteTable.getSelectionModel().getSelectedItem();
			cadastrarVisitante(v.getId());
		}
	}
	

	private void cadastrarVisitante(Long id) throws IOException {
		String nome = this.nome.getText();
		String cpf = this.cpf.getText();

		int numero = 0;
		if (this.unidade_set.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.unidade_set.getSelectionModel().getSelectedItem();

		Blocos bloco = (Blocos) this.bloco_set.getSelectionModel().getSelectedItem();

		try {
			if (nome == null || cpf == null || bloco == null || numero == 0) {
				Alerts.alertError("Seu burro, sua anta, preencha tudo sua misera!");
			} else {
				Visitante visitante = new Visitante();
				Apartamento ap = new Apartamento();
				ap = apartamentoController.buscarApartamento(bloco, numero).get(0);
				visitante.setNome(nome);
				visitante.setCpf(cpf);
				visitante.setApartamento(ap);
				
				// cadastrar
				if(id == null) {
					if(isCadastrado(visitante.getCpf())) {
						if(Alerts.alertConfirmation("Já existe um Visitante cadastrado nesse CPF. Atribuir visita a outro apartamento?", null)) {
							visitanteController.atualizar(visitante);
						}else {
							limpaTela();
						}
				
					}
					visitanteController.cadastrar(visitante);
					Alerts.alertSuccess("Visitante cadastrado com sucesso!");
				}else {
					
					
				}
				
				limpaTela();
				atualizaTabela();
			}
		}

		catch (Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Visitante!\n" + (e.getMessage()
					.compareTo("org.hibernate.exception.ConstraintViolationException: could not execute statement") == 0
							? "CPF já cadastrado"
							: e.getMessage()));
		}

	}

	private void limpaTela() {
		this.nome.setText(null);
		this.cpf.setText(null);
		this.bloco_set.setValue(null);
		this.unidade_set.setValue(null);
	}

	  @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	limpaTela();
			carregarTableView();
			atualizaTabela();
		}
	    
	    private void atualizaTabela() {
	    	try {
				this.visitanteTable.setItems(FXCollections.observableArrayList(visitanteController.listar()));
			} catch (Exception e) {
				e.printStackTrace();
		}
	    }

	private boolean isCadastrado(String cpf) {
		Visitante v = new Visitante();
		try {
			v = (Visitante) dao.buscarCPF(v, cpf);
			return true;
		} catch (Exception e) {
			if (e instanceof NoResultException) {
			}
		}
		return false;
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
    	
    	
    	try {
    		List<Visitante> v = new ArrayList<Visitante>();
			
			ObservableList<Visitante> list3 = FXCollections.observableArrayList(v);

			tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			tableCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			/*tableAcoes.setCellValueFactory(new PropertyValueFactory<>("bloco"));
			tableAcoes1.setCellValueFactory(new PropertyValueFactory<>("numero"));*/
    		
    		visitanteTable.setItems(list3);
    	}catch(Exception e) {
    		
    	}
    }


}
