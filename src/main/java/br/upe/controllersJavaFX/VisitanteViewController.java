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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VisitanteViewController implements Initializable{
	VisitanteController visitanteController = new VisitanteController();
	ApartamentoController apartamentoController = new ApartamentoController();
	JPAPessoaDAO dao = new JPAPessoaDAO();

	private ObservableList<TableVisitanteAp> select;
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
    private TableView<TableVisitanteAp> visitanteApTable;

    @FXML
    private TextField cpf;

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
    private ImageView user;
    
    @FXML
    void logout(MouseEvent event) throws IOException {
    	if (Alerts.alertConfirmation("Desejar sair do sistema?", null)) {
    		switchScreen("login");
    	}
    }
    
    @FXML
	void switchToReserva(MouseEvent event) throws IOException {
		switchScreen("administrativo_reservas");
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
    void salvarVisitante(MouseEvent event) throws Exception {
    	Music.playMusic("./mp3/movimento_de_pessoas_suspeitas.mp3");
    	if (this.select == null || this.select.isEmpty()) {
    		visitanteApTable.getSelectionModel().clearSelection();
    		cadastrarVisitante();
    	} else {
    		editarVisitante(visitanteApTable.getSelectionModel().getSelectedItem().getIdVisitante());
    	}
    	
    	visitanteApTable.getSelectionModel().clearSelection();
    }
    
    @FXML
    void EditarVisitante(MouseEvent event){
    	this.select = visitanteApTable.getSelectionModel().getSelectedItems();
    	this.cpf.setText(this.select.get(0).getCpf());
    	this.nome.setText(this.select.get(0).getNome());
    	this.bloco_set.setValue(this.select.get(0).getBloco());
    	this.unidade_set.setValue(this.select.get(0).getNumero());
    }    

    @FXML
    void ExcluirVisitante(MouseEvent event) throws Exception {
    	if(Alerts.alertConfirmation("Excluir", "Deseja prosseguir com a operação?")) {
			excluirVisitante();
		}
    	limpaTela();
		atualizaTabela();
    }
    
    private void excluirVisitante(){
    	try {
    		visitanteController.remover(visitanteApTable.getSelectionModel().getSelectedItem().getIdVisitante());
    		Alerts.alertSuccess("Visitante deletado com sucesso!");
    	}catch(Exception e) {
    		Alerts.alertError("Não foi possível excluir esse visitante!");
    	}
    	
    }

    @FXML
    void PesquisaAp(MouseEvent event) {
    	int numero = 0;
		if (this.num_AP.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.num_AP.getSelectionModel().getSelectedItem();
		
		Blocos bloco = (Blocos) this.bloco_AP.getSelectionModel().getSelectedItem();
		buscarPorAp(numero, bloco);
    }
    
	private void limpaTela() {
		this.nome.setText(null);
		this.cpf.setText(null);
		this.bloco_set.setValue(null);
		this.unidade_set.setValue(null);
	}
    
	private void editarVisitante(Long id) {
		String nome = this.nome.getText();
		String cpf = this.cpf.getText();

		int numero = 0;
		if (this.unidade_set.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.unidade_set.getSelectionModel().getSelectedItem();

		Blocos bloco = (Blocos) this.bloco_set.getSelectionModel().getSelectedItem();
		
		try {
			if (nome == null || cpf == null || bloco == null || numero == 0) {
				Alerts.alertError("Seu burro, sua anta, preencha tudo sua misera!");
			}else {
				Visitante m = visitanteController.buscarPorId(id);
				Apartamento ap = new Apartamento();
				m.setCpf(cpf);
				m.setNome(nome);
				ap = apartamentoController.buscarApartamento(bloco, numero).get(0);
				m.setApartamento(ap);
				visitanteController.atualizar(m);
				Alerts.alertSuccess("Visitante atualizado com sucesso!");
				limpaTela();
				atualizaTabela();
			}
			
			
		}catch(Exception e) {
			Alerts.alertError("Erro ao tentar atualizar esse Visitante!\n" + (e.getMessage()));
		}
	}
    
    private void cadastrarVisitante() throws IOException {
		String nome = this.nome.getText();
		String cpf = this.cpf.getText();

		int numero = 0;
		if (this.unidade_set.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.unidade_set.getSelectionModel().getSelectedItem();

		Blocos bloco = (Blocos) this.bloco_set.getSelectionModel().getSelectedItem();
		
		try {
			if (nome == null || cpf == null || bloco == null || numero == 0) {
				Alerts.alertError("Seu burro, sua anta, preencha tudo sua misera!");
			} 
			else {
				Visitante visitante = new Visitante();
				Apartamento ap = new Apartamento();
				ap = apartamentoController.buscarApartamento(bloco, numero).get(0);
				visitante.setNome(nome);
				visitante.setCpf(cpf);
				visitante.setApartamento(ap);
				
				if(isCadastrado(cpf)){
						if(Alerts.alertConfirmation("Já existe um Visitante cadastrado nesse CPF. Atribuir visitante a novo apartamento?", null)) {
							visitante = visitanteController.buscarPorCpf(visitante, cpf);
							visitante.setApartamento(ap);
							visitanteController.atualizar(visitante);
							Alerts.alertSuccess("Apartamento atualizado com sucesso!");
						}else {
							limpaTela();
						}
				
					}else {
						visitanteController.cadastrar(visitante);
						Alerts.alertSuccess("Visitante cadastrado com sucesso!");
						
					}
				}
				
				limpaTela();
				atualizaTabela();
					
		}
		catch (Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Visitante!\n" + (e.getMessage()));
		}

	}
    
	private boolean isCadastrado(String cpf) {
		Visitante m = new Visitante();
		try {
			m = (Visitante) dao.buscarCPF(m, cpf);
			return true;
		} catch (Exception e) {
			if (e instanceof NoResultException) {
			}
		}
		return false;
	}
	
    @Override
	public void initialize(URL location, ResourceBundle resources) {
    	limpaTela();
		carregarTableView();
		atualizaTabela();
	}
    
    private void atualizaTabela() {
    	try {
			this.visitanteApTable.setItems(FXCollections.observableArrayList(listVisitanteAp()));
		} catch (Exception e) {
			e.printStackTrace();
	}
    }
    
    private void buscarPorAp(int numero, Blocos bloco) {
		try {
			Apartamento ap = apartamentoController.buscarApartamento(bloco, numero).get(0);
			this.listVisitante = visitanteController.buscarPorAp(ap);
			System.out.println(listVisitante);
		
			carregarTableView();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
    
    List<Visitante> listVisitante = new ArrayList<Visitante>();
    
    private List<TableVisitanteAp> listVisitanteAp(){
    	List<TableVisitanteAp> listVisitanteAp = new ArrayList<TableVisitanteAp>();
    	
    	try {
    		this.listVisitante =  visitanteController.listar();
    	}catch(Exception e) {
    		
    	}
    	
    	for(Visitante m: listVisitante) {
    		listVisitanteAp.add(new TableVisitanteAp(m ,m.getApartamento()));
    	}
    	return listVisitanteAp;
    }
    
    
    public void carregarTableView(){
    	
    	ObservableList<String> listUni = FXCollections.observableArrayList("Condômino", "Morador", "Visitante", "Veículo");

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
    	    	
    	ObservableList<TableVisitanteAp> list3 = FXCollections.observableArrayList(listVisitanteAp());
    	
		tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableAcoes.setCellValueFactory(new PropertyValueFactory<>("bloco"));
		tableAcoes1.setCellValueFactory(new PropertyValueFactory<>("numero"));
		
		visitanteApTable.setItems(list3);
  
    }

}
