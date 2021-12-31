package br.upe.controllersJavaFX;

import java.io.IOException;

import br.upe.controller.FuncionarioController;
import br.upe.model.entity.FuncaoFuncionario;
import br.upe.model.entity.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FuncionarioViewController {
	
	 @FXML
	    private Button btn_excluir;

	    @FXML
	    private ComboBox<?> button_funcionario;

	    @FXML
	    private ComboBox<?> button_reserva;

	    @FXML
	    private ComboBox<?> button_servico;

	    @FXML
	    private ComboBox<?> button_unidade;

	    @FXML
	    private CheckBox checkAcesso;

	    @FXML
	    private TextField cpf;

	    @FXML
	    private TextField ctps;

	    @FXML
	    private DatePicker dataAdm;

	    @FXML
	    private TableView<?> funcionarioTable;

	    @FXML
	    private TextField nome;
	    
	    @FXML
	    private ComboBox<?> funcaoFuncionario;

	    @FXML
	    private TextField senha;

	    @FXML
	    private TextField senhaConfirm;

	    @FXML
	    private TableColumn<?, ?> tableCPF;

	    @FXML
	    private TableColumn<?, ?> tableCTPS;

	    @FXML
	    private TableColumn<?, ?> tableData;

	    @FXML
	    private TableColumn<?, ?> tableFuncao;

	    @FXML
	    private TableColumn<?, ?> tableNome;

	    @FXML
	    void EditarFuncionario(MouseEvent event) {

	    }

	    @FXML
	    void ExcluirFuncionario(MouseEvent event) {

	    }

	    @FXML
	    void Pesquisar(MouseEvent event) {

	    }

	    @FXML
	    void Select(ActionEvent event) {

	    }

	    @FXML
	    void salvarFuncionario(MouseEvent event) throws IOException {
	    	cadastrarFuncionario();

	    }

	FuncionarioController funcionarioController = new FuncionarioController();
	
	private void cadastrarFuncionario() throws IOException {
		String nome = this.nome.getText();
		String cpf = this.cpf.getText();
		String password = this.senha.getText();
		String carteiraTrabalhoString = this.ctps.getText();
		//Date dataAdmissao = this.data.getValue();
		FuncaoFuncionario funcao = (FuncaoFuncionario) this.funcaoFuncionario.getSelectionModel().getSelectedItem();
		
		try {
			Funcionario funcionario = new Funcionario();
			funcionario.setNome(nome);
			funcionario.setCpf(cpf);
			funcionario.setFuncao(funcao);
			funcionario.setCarteiraTrabalho(carteiraTrabalhoString);
			
			if(isUser()) {
				funcionario.setSenha(password);
			}
				funcionarioController.cadastrar(funcionario);
				Alerts.alertSuccess("Funcionario cadastrado com sucesso!");
		
		}catch(Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Funcionario!");
		}
	}



	
	@FXML
	private void excluir(Funcionario Funcionario) {
		try {
			funcionarioController.remover(Funcionario);
		}catch(Exception e) {
			Alerts.alertError("Não foi possível excluir esse Funcionario!");
		}
	}
	
	@FXML
	private boolean isUser() {
		if (checkAcesso.selectedProperty().getValue() == true) {
			return true;
		}else {
			return false;
		}
	}

}
