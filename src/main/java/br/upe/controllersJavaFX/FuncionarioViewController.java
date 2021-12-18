package br.upe.controllersJavaFX;

import java.io.IOException;

import br.upe.controller.FuncionarioController;
import br.upe.model.entity.FuncaoFuncionario;
import br.upe.model.entity.Funcionario;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class FuncionarioViewController {
	
	@FXML
	private TextField nome;
	
	@FXML
	private TextField cpf;
	
	@FXML
	private TextField CTPS;
	
	@FXML
	private TextField password;
	
	@FXML
	private ChoiceBox<FuncaoFuncionario> funcaoFuncionario;
	
	@FXML 
	private RadioButton checkUser;
	
	/*@FXML
	private DatePicker data;*/

	FuncionarioController funcionarioController = new FuncionarioController();
	
	@FXML
	private void cadastrarFuncionario() throws IOException {
		String nome = this.nome.getText();
		String cpf = this.cpf.getText();
		String senha = this.password.getText();
		String carteiraTrabalhoString = this.CTPS.getText();
		//Date dataAdmissao = this.data.getValue();
		FuncaoFuncionario funcao = this.funcaoFuncionario.getSelectionModel().getSelectedItem();
		
		try {
			Funcionario funcionario = new Funcionario();
			funcionario.setNome(nome);
			funcionario.setCpf(cpf);
			funcionario.setFuncao(funcao);
			funcionario.setCarteiraTrabalho(carteiraTrabalhoString);
			
			if(isUser()) {
				funcionario.setSenha(senha);
			}
				funcionarioController.cadastrar(funcionario);
				Alerts.alertSuccess("Funcionario cadastrado com sucesso!");
		
		}catch(Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Funcionario!");
		}
	}

	@FXML
	private void listarFuncionarios(){
		try {
			funcionarioController.listar();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	@FXML
	private void atualizar(Funcionario funcionario) {
		try {
			funcionarioController.atualizar(funcionario);
		}catch (Exception e) {
			Alerts.alertError("Erro ao tentar atualizar esse Funcionario!");
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
		if (checkUser.selectedProperty().getValue() == true) {
			return true;
		}else {
			return false;
		}
	}

}
