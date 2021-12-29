package br.upe.controllersJavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import br.upe.controller.ApartamentoController;
import br.upe.controller.CondominoController;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Condomino;
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

public class CondominoViewController implements Initializable{
	
	public final String DELETE = "M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM19 4h-3.5l-1-1h-5l-1 1H5v2h14V4z";
	
//	@FXML 
//	private TableColumn<Condomino, Condomino> columnDelete;
	private ObservableList<Condomino> select;
	
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
    private TableView<Apartamento> apartamentoTable;

    @FXML
    private TableColumn<Condomino, String> tableCPF;

    @FXML
    private TableColumn<Condomino, String> tableContato;

    @FXML
    private TableColumn<Condomino, String> tableNome;
    
    @FXML
    private TableColumn<Apartamento, Blocos> tableAcoes;
    
//    @FXML
//    private TableColumn<Condomino, String> tableAcoes1;
    
    @FXML
    private Button btn_excluir;
    
    @FXML
    private TextField unidade;
    
    @FXML
    private TextField bloco;

    @FXML
    void Select(ActionEvent event) {}
   
	CondominoController condominoController = new CondominoController();
	
	@FXML 
	void salvarCondomino(MouseEvent event) throws IOException {
		System.out.println("Teste #01: "+condominoTable.getSelectionModel().getSelectedItem());
		System.out.println("Teste #02: "+this.select);
		
		if(this.select == null || this.select.isEmpty()) {
			cadastrarCondomino(null);
		}else {
			//cadastrarCondomino((Long) this.select.get(0).getId());
			cadastrarCondomino(condominoTable.getSelectionModel().getSelectedItem().getId());
		}
	}
	
	
	private void cadastrarCondomino(Long id) throws IOException {
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
				
				if (id == null) {
					condominoController.cadastrar(condomino, ap);
					
					Alerts.alertSuccess("Condomino cadastrado com sucesso!");
					
				}else {
					condomino.setId(id);
					condominoController.atualizar(condomino);
					Alerts.alertSuccess("Condomino atualizado com sucesso!");
				}
			}
		}
		catch(Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Condomino!");
		}
		
		limpaTela();
		atualizaTabela();
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
	void EditarCondomino(MouseEvent event) {
		this.select = condominoTable.getSelectionModel().getSelectedItems();
		this.cpf.setText(select.get(0).getCpf());
		this.nome.setText(select.get(0).getNome());
		this.contato.setText(select.get(0).getContato());
		this.bloco_AP.setValue(select.get(0).getApartamentos().get(0).getBloco());
		this.num_AP.setValue(select.get(0).getApartamentos().get(0).getNumero());
		this.bloco.setText(String.valueOf(select.get(0).getApartamentos().get(0).getBloco()));
		this.unidade.setText(String.valueOf(select.get(0).getApartamentos().get(0).getNumero()));
	}
	
	@FXML
	void ExcluirCondomino(MouseEvent event) {
		this.select = condominoTable.getSelectionModel().getSelectedItems();
		excluirCondomino();
		limpaTela();
		atualizaTabela();
	}
	
	private void limpaTela() {
		this.nome.setText(null);
		this.cpf.setText(null);
		this.contato.setText(null);
	}
	
	private void excluirCondomino() {
		try {
			condominoController.remover(this.select.get(0));
			Alerts.alertSuccess("Condomino deletado com sucesso!");
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
	
	private void tabelaPesquisa() {
		
	}
	
	@FXML 
	void PesquisaAp(MouseEvent event) {
		int numero = (int) this.num_AP.getSelectionModel().getSelectedItem(); 
		Blocos bloco = (Blocos) this.bloco_AP.getSelectionModel().getSelectedItem();
		buscarAp(numero, bloco);
	}
	
	private void buscarAp(int numero, Blocos bloco) {
		
		try {
			condominoController.buscarApartamento(bloco, numero);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	condominoTable.setRowFactory(new Callback<TableView<Condomino>, TableRow<Condomino>>() {  
//        @Override  
//        public TableRow<Condomino> call(TableView<Condomino> tableView2) {  
//            final TableRow<Condomino> row = new TableRow<>();  
//            row.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {  
//                @Override  
//                public void handle(MouseEvent event) {  
//                    final int index = row.getIndex();  
//                    if (index >= 0 && index < tableView.getItems().size() && tableView.getSelectionModel().isSelected(index)  ) {
//                        tableView.getSelectionModel().clearSelection();
//                        event.consume();  
//                    }  
//                }  
//            });  
//            return row;  
//        }  
//    });  

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		limpaTela();
		carregarTableView();
		
		condominoTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> selecionarItemTableViewCondomino(newValue));
		
	}
	
	public void carregarTableView() {
		ObservableList<Integer> list1 = FXCollections.observableArrayList(1, 2, 3);
		ObservableList<Blocos> list2 = FXCollections.observableArrayList(Blocos.values() );
			
		num_AP.setItems(list1);
		bloco_AP.setItems(list2);
		
		// Tabela
		try {
			ApartamentoController apartamentoController = new ApartamentoController();
			ObservableList<Condomino> list3 = FXCollections.observableArrayList(condominoController.listar());
			//ObservableList<Apartamento> list4 = FXCollections.observableArrayList(apartamentoController.listar());
			
			tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			tableCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			tableContato.setCellValueFactory(new PropertyValueFactory<>("contato"));
			
			//tableAcoes.setCellValueFactory(new PropertyValueFactory<>("bloco"));
			//System.out.println("Bloco: " + new PropertyValueFactory<>("bloco"));
			
			
			condominoTable.setItems(list3);
			//apartamentoTable.setItems(list4);		  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void selecionarItemTableViewCondomino(Condomino condomino) {
		System.out.println("Cliente selecionado no TableView: " + condomino.getNome());
	}
	
	
}
