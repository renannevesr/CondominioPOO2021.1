package br.upe.controllersJavaFX;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import br.upe.App;
import br.upe.controller.FuncionarioController;
import br.upe.model.entity.FuncaoFuncionario;
import br.upe.model.entity.Funcionario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FuncionarioViewController implements Initializable{
	
	FuncionarioController funcionarioController = new FuncionarioController();
		private ObservableList<Funcionario> select;
	
	 	@FXML
	    private Button btn_excluir;

	    @FXML
	    private ComboBox<?> button_funcionario;

	    @FXML
	    private ComboBox<?> button_reserva;

	    @FXML
	    private ComboBox<String> button_servico;

	    @FXML
	    private ComboBox<String> button_unidade;

	    @FXML
	    private CheckBox checkAcesso;

	    @FXML
	    private TextField cpf;

	    @FXML
	    private TextField ctps;

	    @FXML
	    private DatePicker dataAdm;

	    @FXML
	    private TableView<Funcionario> funcionarioTable;

	    @FXML
	    private TextField nome;
	    
	    @FXML
	    private ComboBox<FuncaoFuncionario> funcaoFuncionario;

	    @FXML
	    private PasswordField senha;

	    @FXML
	    private PasswordField senhaConfirm;

	    @FXML
	    private TableColumn<Funcionario, String> tableCPF;

	    @FXML
	    private TableColumn<Funcionario, String> tableCTPS;

	    @FXML
	    private TableColumn<Funcionario, LocalDate> tableData;

	    @FXML
	    private TableColumn<Funcionario, FuncaoFuncionario> tableFuncao;

	    @FXML
	    private TableColumn<Funcionario, String> tableNome;
	    
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
	    void EditarFuncionario(MouseEvent event) {
	    	this.select = funcionarioTable.getSelectionModel().getSelectedItems();
	    	this.nome.setText(this.select.get(0).getNome());
	    	this.cpf.setText(this.select.get(0).getCpf());
	    	this.ctps.setText(this.select.get(0).getCarteiraTrabalho());
	    	this.dataAdm.setValue(this.select.get(0).getDataAdmissao());
	    	this.funcaoFuncionario.setValue(this.select.get(0).getFuncao());

	    }

	    @FXML
	    void ExcluirFuncionario(MouseEvent event) {

			if(Alerts.alertConfirmation("Excluir", "Deseja prosseguir com a operação?")) {
				excluirFuncionario();
			}
	    	funcionarioTable.getSelectionModel().clearSelection();
			limpaTela();
			atualizaTabela();
	    }

	    @FXML
	    void salvarFuncionario(MouseEvent event) throws IOException {
	    	if (this.select == null || this.select.isEmpty()) {
	    		cadastrarFuncionario();
	    	}else {
	    		editarFuncionario(funcionarioTable.getSelectionModel().getSelectedItem().getId());
	    	}
	    	
	    	funcionarioTable.getSelectionModel().clearSelection();

	    }

		
	private void cadastrarFuncionario() throws IOException {
		String nome = this.nome.getText();
		String cpf = this.cpf.getText();
		String password = this.senha.getText();
		String passwordConfirm = this.senhaConfirm.getText();
		String carteiraTrabalhoString = this.ctps.getText();
		LocalDate dataAdmissao = this.dataAdm.getValue();
		FuncaoFuncionario funcao = (FuncaoFuncionario) this.funcaoFuncionario.getSelectionModel().getSelectedItem();
		
		try {		
			Funcionario funcionario;
			
			if (nome == null || cpf == null || carteiraTrabalhoString == null || dataAdmissao == null) {
				Alerts.alertError("Seu burro, sua anta, preencha tudo sua misera!");
			}else {
			
				
				if(isUser()) {
					if(!password.equals(passwordConfirm)){
						throw new Exception("As senhas digitadas não conferem.");
					}
					funcionario = new Funcionario(null, nome, cpf, dataAdmissao, carteiraTrabalhoString, funcao, password);
					
				}else {
					funcionario = new Funcionario(null, nome, cpf, dataAdmissao, carteiraTrabalhoString, funcao);
				} 
				
				funcionarioController.cadastrar(funcionario);
				Alerts.alertSuccess("Funcionario cadastrado com sucesso!");
				limpaTela();
				atualizaTabela();
			}
			
		}catch(Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Funcionario!\n" + (e.getMessage()));
		}
	}
	
	private void editarFuncionario(Long id) {
		
		try {
			Funcionario funcionario = funcionarioController.buscarPorId(id);
			funcionario.setId(id);
			funcionario.setCpf(this.cpf.getText());
			funcionario.setCarteiraTrabalho(this.ctps.getText());
			funcionario.setDataAdmissao(this.dataAdm.getValue());
			funcionario.setNome(this.nome.getText());
			funcionario.setSenha(funcionario.getSenha());
			funcionario.setFuncao((FuncaoFuncionario) this.funcaoFuncionario.getSelectionModel().getSelectedItem());
			funcionarioController.atualizar(funcionario);
			Alerts.alertSuccess("Funcionario atualizado com sucesso!");
			limpaTela();
			atualizaTabela();
		}catch(Exception e) {
			Alerts.alertError("Erro ao tentar atualizar esse Funcionario!" + (e.getMessage()));
		}
	}
	
    private void excluirFuncionario() {
		try {
			funcionarioController.remover(funcionarioTable.getSelectionModel().getSelectedItem().getId());
			Alerts.alertSuccess("Funcionario deletado com sucesso!");
		} catch (Exception e) {
			Alerts.alertError("Não foi possível excluir esse funcionario!");
			e.printStackTrace();
		}
	}
	
	private boolean isUser() {
		if (checkAcesso.selectedProperty().getValue() == true) {
			return true;
		}
		
		return false;
	}
	
    @FXML
    void checkAcesso(MouseEvent event) {
    	if (checkAcesso.selectedProperty().getValue() == true) {
			this.senha.setDisable(false);
			this.senhaConfirm.setDisable(false);
		}else {
			this.senha.setDisable(true);
			this.senhaConfirm.setDisable(true);
		}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.senha.setDisable(true);
		this.senhaConfirm.setDisable(true);
		limpaTela();
		carregarTableView();
		atualizaTabela();
		ObservableList<FuncaoFuncionario> list = FXCollections.observableArrayList(FuncaoFuncionario.values());
		funcaoFuncionario.setItems(list);
	}
	
	 private void atualizaTabela() {
	    	try {
				this.funcionarioTable.setItems(FXCollections.observableArrayList(funcionarioController.listar()));
			} catch (Exception e) {
				e.printStackTrace();
		}
	    }
	 
	 private void limpaTela() {
		 this.nome.setText(null);
		 this.cpf.setText(null);
		 this.ctps.setText(null);
		 this.dataAdm.setValue(null);
		 this.funcaoFuncionario.setValue(null);
		 this.senha.setText(null);
		 this.senhaConfirm.setText(null);
	 }
	
	public void carregarTableView() {
		
		ObservableList<String> listUni = FXCollections.observableArrayList("Condômino", "Morador", "Visitante",
				"Veículo");

		ObservableList<String> listServico = FXCollections.observableArrayList("Serviço geral", "Serviço de produto");

		button_unidade.setItems(listUni);
		button_servico.setItems(listServico);
		
			tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			tableCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			tableCTPS.setCellValueFactory(new PropertyValueFactory<>("carteiraTrabalho"));
			tableData.setCellValueFactory(new PropertyValueFactory<>("dataAdmissao"));
			tableFuncao.setCellValueFactory(new PropertyValueFactory<>("funcao"));

	}


}
