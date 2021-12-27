package br.upe.controllersJavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.controller.CondominoController;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Condomino;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CondominoViewController implements Initializable{
	
    @FXML
    private ComboBox<Blocos> bloco_AP;
    
    @FXML
    private ComboBox<Integer> num_AP;

    @FXML
    private ComboBox<?> button_funcionario;

    @FXML
    private ComboBox<?> button_reserva;

    @FXML
    private ComboBox<?> button_servico;

    @FXML
    private ComboBox<?> button_unidade;

    @FXML
    private TextField contato;

    @FXML
    private TextField cpf;

    @FXML
    private TextField nome;

    @FXML
    private TableView<Condomino> condominoTable;

    @FXML
    private TableColumn<Condomino, String> tableCPF;

    @FXML
    private TableColumn<Condomino, String> tableContato;

    @FXML
    private TableColumn<Condomino, String> tableNome;
    
    @FXML
    private TableColumn<Data, Void> tableAcoes;

    @FXML
    void Select(ActionEvent event) {}
   
	CondominoController condominoController = new CondominoController();
	
	@FXML
	private void cadastrarCondomino() throws IOException {
		String nome = this.nome.getText();
		String cpf = this.cpf.getText();
		String contato = this.contato.getText();
		
		int numero = 0;
		if(this.num_AP.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.num_AP.getSelectionModel().getSelectedItem(); 
		
		Blocos bloco = (Blocos) this.bloco_AP.getSelectionModel().getSelectedItem();
		
		try {
			if(nome.equals("") || 
			   cpf.equals("") || 
			   contato.equals("") || 
			   bloco.equals("") ||
			   numero == 0 ) 
			{
				Alerts.alertError("Seu burro, sua anta, preencha tudo sua misera!");
			}
			else {
				Apartamento ap = new Apartamento();
				ap.setBloco(bloco);
				ap.setNumero(numero);
				
				Condomino condomino = new Condomino();
				condomino.setNome(nome);
				condomino.setCpf(cpf);
				condomino.setContato(contato);
				condominoController.cadastrar(condomino, ap);
				
				Alerts.alertSuccess("Condomino cadastrado com sucesso!");
				
				atualizaTabela();
			}
		}
		catch(Exception e) {
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
	private void atualizarCondomino(Condomino condomino) {
		try {
			condominoController.atualizar(condomino);
		}catch (Exception e) {
			Alerts.alertError("Erro ao tentar atualizar esse condomino!");
		}
	}
	
	@FXML
	private void excluirCondomino(Condomino condomino) {
		try {
			condominoController.remover(condomino);
			atualizaTabela();
		}catch(Exception e) {
			Alerts.alertError("Não foi possível excluir esse condomino!");
		}
	}
	
	private void atualizaTabela() {
        try {
            condominoTable.setItems(FXCollections.observableArrayList(condominoController.listar()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<Integer> list1 = FXCollections.observableArrayList(1, 2);
		ObservableList<Blocos> list2 = FXCollections.observableArrayList(Blocos.values() );
		
		num_AP.setItems(list1);
		bloco_AP.setItems(list2);
		
		// Tabela
		try {
			ObservableList<Condomino> list3 = FXCollections.observableArrayList(condominoController.listar());
			
			tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			tableCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			tableContato.setCellValueFactory(new PropertyValueFactory<>("contato"));
			
			condominoTable.setItems(list3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
