package br.upe.controllersJavaFX;

import java.io.IOException;

import br.upe.controller.CondominoController;
import br.upe.model.entity.Condomino;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class CondominoViewController {
	
	@FXML
	private TextField nome;
	
	@FXML
	private TextField cpf;
	
	@FXML
	private TextField contato;

	CondominoController condominoController = new CondominoController();
	
	@FXML
	private void cadastrarCondomino() throws IOException {
		String nome = this.nome.getText();
		String cpf = this.cpf.getText();
		String contato = this.contato.getText();
		
		try {
			Condomino condomino = new Condomino();
			condomino.setNome(nome);
			condomino.setCpf(cpf);
			condomino.setContato(contato);
			condominoController.cadastrar(condomino);
			Alerts.alertSuccess("Condomino cadastrado com sucesso!");
			
		}catch(Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Condomino!");
		}
	}

	@FXML
	private void listarCondominos(){
		try {
			condominoController.listar();
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	@FXML
	private void atualizar(Condomino condomino) {
		try {
			condominoController.atualizar(condomino);
		}catch (Exception e) {
			Alerts.alertError("Erro ao tentar atualizar esse condomino!");
		}
	}
	
	@FXML
	private void excluir(Condomino condomino) {
		try {
			condominoController.remover(condomino);
		}catch(Exception e) {
			Alerts.alertError("Não foi possível excluir esse condomino!");
		}
	}

}