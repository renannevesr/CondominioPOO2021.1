package br.upe.controllersJavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.NoResultException;

import br.upe.controller.ApartamentoController;
import br.upe.controller.MoradorController;
import br.upe.model.dao.PessoaDAO.JPAPessoaDAO;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Morador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MoradorViewController implements Initializable{
	MoradorController moradorController = new MoradorController();
	ApartamentoController apartamentoController = new ApartamentoController();
	JPAPessoaDAO dao = new JPAPessoaDAO();

	private ObservableList<TableMoradorAp> select;
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
    private ComboBox<?> button_servico;

    @FXML
    private ComboBox<?> button_unidade;
   
    @FXML
    private TableView<TableMoradorAp> moradorApTable;

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
    void switchToFuncionario(MouseEvent event) {

    }

    @FXML
    void switchToReserva(MouseEvent event) {

    }
    
    @FXML
    void salvarMorador(MouseEvent event) throws Exception {
    	if (this.select == null || this.select.isEmpty()) {
    		moradorApTable.getSelectionModel().clearSelection();
    		cadastrarMorador();
    	} else {
    		editarMorador(moradorApTable.getSelectionModel().getSelectedItem().getIdMorador());
    	}
    	
    	moradorApTable.getSelectionModel().clearSelection();
    }
    
    @FXML
    void EditarMorador(MouseEvent event){
    	this.select = moradorApTable.getSelectionModel().getSelectedItems();
    	this.cpf.setText(this.select.get(0).getCpf());
    	this.nome.setText(this.select.get(0).getNome());
    	this.bloco_set.setValue(this.select.get(0).getBloco());
    	this.unidade_set.setValue(this.select.get(0).getNumero());
    }    

    @FXML
    void ExcluirMorador(MouseEvent event) throws Exception {
    	if(Alerts.alertConfirmation("Excluir", "Deseja prosseguir com a operação?")) {
			excluirMorador();
		}
    	limpaTela();
		atualizaTabela();
    }
    
    private void excluirMorador(){
    	try {
    		moradorController.remover(moradorApTable.getSelectionModel().getSelectedItem().getIdMorador());
    		Alerts.alertSuccess("Morador deletado com sucesso!");
    	}catch(Exception e) {
    		Alerts.alertError("Não foi possível excluir esse morador!");
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
    
    @FXML
    void Select(ActionEvent event) {

    }
	private void limpaTela() {
		this.nome.setText(null);
		this.cpf.setText(null);
		this.bloco_set.setValue(null);
		this.unidade_set.setValue(null);
	}
    
	private void editarMorador(Long id) {
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
				Morador m = moradorController.buscarPorId(id);
				Apartamento ap = new Apartamento();
				m.setCpf(cpf);
				m.setNome(nome);
				ap = apartamentoController.buscarApartamento(bloco, numero).get(0);
				m.setApartamento(ap);
				moradorController.atualizar(m);
				Alerts.alertSuccess("Morador atualizado com sucesso!");
				limpaTela();
				atualizaTabela();
			}
			
			
		}catch(Exception e) {
			Alerts.alertError("Erro ao tentar atualizar esse Morador!\n" + (e.getMessage()));
		}
	}
    
    private void cadastrarMorador() throws IOException {
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
				Morador morador = new Morador();
				Apartamento ap = new Apartamento();
				ap = apartamentoController.buscarApartamento(bloco, numero).get(0);
				morador.setNome(nome);
				morador.setCpf(cpf);
				morador.setApartamento(ap);
				
				if(isCadastrado(cpf)){
						if(Alerts.alertConfirmation("Já existe um Morador cadastrado nesse CPF. Atribuir morador a novo apartamento?", null)) {
							morador = moradorController.buscarPorCpf(morador, cpf);
							morador.setApartamento(ap);
							moradorController.atualizar(morador);
							Alerts.alertSuccess("Apartamento atualizado com sucesso!");
						}else {
							limpaTela();
						}
				
					}else {
						moradorController.cadastrar(morador);
						Alerts.alertSuccess("Morador cadastrado com sucesso!");
						
					}
				}
				
				limpaTela();
				atualizaTabela();
					
		}
		catch (Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Morador!\n" + (e.getMessage()));
		}

	}
    
	private boolean isCadastrado(String cpf) {
		Morador m = new Morador();
		try {
			m = (Morador) dao.buscarCPF(m, cpf);
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
			this.moradorApTable.setItems(FXCollections.observableArrayList(listMoradorAp()));
		} catch (Exception e) {
			e.printStackTrace();
	}
    }
    
    private void buscarPorAp(int numero, Blocos bloco) {
		try {
			Apartamento ap = apartamentoController.buscarApartamento(bloco, numero).get(0);
			this.listMorador = moradorController.buscarPorAp(ap);
			System.out.println(listMorador);
		
			carregarTableView();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
    
    List<Morador> listMorador = new ArrayList<Morador>();
    
    private List<TableMoradorAp> listMoradorAp(){
    	List<TableMoradorAp> listMoradorAp = new ArrayList<TableMoradorAp>();
    	
    	try {
    		this.listMorador =  moradorController.listar();
    	}catch(Exception e) {
    		
    	}
    	
    	for(Morador m: listMorador) {
    		listMoradorAp.add(new TableMoradorAp(m ,m.getApartamento()));
    	}
    	return listMoradorAp;
    }
    
    
    public void carregarTableView(){

    	ObservableList<Integer> list1 = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    	ObservableList<Blocos> list2 = FXCollections.observableArrayList(Blocos.values());
    	ObservableList<Integer> list5 = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    	ObservableList<Blocos> list6 = FXCollections.observableArrayList(Blocos.A, Blocos.B, Blocos.C);
    	
    	num_AP.setItems(list1);
    	bloco_AP.setItems(list2);
    	bloco_set.setItems(list6);
    	unidade_set.setItems(list5);
    	    	
    	ObservableList<TableMoradorAp> list3 = FXCollections.observableArrayList(listMoradorAp());
    	
		tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableAcoes.setCellValueFactory(new PropertyValueFactory<>("bloco"));
		tableAcoes1.setCellValueFactory(new PropertyValueFactory<>("numero"));
		
		moradorApTable.setItems(list3);
  
    }

}
