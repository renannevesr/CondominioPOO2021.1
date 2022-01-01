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

	private ObservableList<Morador> select;
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
    private TableView<Morador> moradorTable;

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
    void salvarMorador(MouseEvent event) throws IOException {
    	if (this.select == null || this.select.isEmpty()) {
    		moradorTable.getSelectionModel().clearSelection();
    		cadastrarMorador(null);
    	} else {
    		Morador m = new Morador();
    		m = (Morador) moradorTable.getSelectionModel().getSelectedItem();
    		cadastrarMorador(m.getId());
    	}
    	
    }
    
    @FXML
    void EditarMorador(MouseEvent event) {
    	this.select = moradorTable.getSelectionModel().getSelectedItems();
    	this.cpf.setText(this.select.get(0).getCpf());
    	this.nome.setText(this.select.get(0).getNome());
    	/*this.bloco_set.setValue(.getApartamentos().get(0).getBloco());
    	this.unidade_set.setValue(c.getApartamentos().get(0).getNumero());*/
    }
    

    @FXML
    void ExcluirMorador(MouseEvent event) {

    }

    @FXML
    void PesquisaAp(MouseEvent event) {

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
    
    
    private void cadastrarMorador(Long id) throws IOException {
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
				
				if(id == null) {
					if(isCadastrado(morador.getCpf())) {
						if(Alerts.alertConfirmation("Já existe um Morador cadastrado nesse CPF. Atribuir morador a novo apartamento?", null)) {
							moradorController.atualizar(morador);
						}else {
							limpaTela();
						}
				
					}
					moradorController.cadastrar(morador);
					Alerts.alertSuccess("Morador cadastrado com sucesso!");
				}else {
					moradorController.atualizar(morador);
					Alerts.alertSuccess("Morador atualizado com sucesso!");
					
				}
				
				limpaTela();
				atualizaTabela();
				
			}
				
		}

		catch (Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Morador!\n" + (e.getMessage()
					.compareTo("org.hibernate.exception.ConstraintViolationException: could not execute statement") == 0
							? "CPF já cadastrado"
							: e.getMessage()));
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
			this.moradorTable.setItems(FXCollections.observableArrayList(moradorController.listar()));
		} catch (Exception e) {
			e.printStackTrace();
	}
    }
    
    
    public void carregarTableView() {
    	List<Morador> listMorador = new ArrayList<Morador>();
   
    	try {
			listMorador = moradorController.listar();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	ObservableList<Integer> list1 = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    	ObservableList<Blocos> list2 = FXCollections.observableArrayList(Blocos.values());
    	ObservableList<Integer> list5 = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    	ObservableList<Blocos> list6 = FXCollections.observableArrayList(Blocos.A, Blocos.B, Blocos.C);
    	
    	num_AP.setItems(list1);
    	bloco_AP.setItems(list2);
    	bloco_set.setItems(list6);
    	unidade_set.setItems(list5);
    	
    	Blocos b = null;
    	int num = 0;
    	
    	for(Morador m: listMorador) {
    		b= m.getApartamento().getBloco();
    		num = m.getApartamento().getNumero();
    		System.out.println("Blocos : " + b);
    		System.out.println("Numero : " + num);
    	}
    	
    	try {
    		List<Morador> m = new ArrayList<Morador>();
			
			ObservableList<Morador> list3 = FXCollections.observableArrayList(m);

			tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			tableCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			/*tableAcoes.setCellValueFactory(new PropertyValueFactory<>("bloco"));
			tableAcoes1.setCellValueFactory(new PropertyValueFactory<>("numero"));*/
    		
    		moradorTable.setItems(list3);
    	}catch(Exception e) {
    		
    	}
    }

}
