package br.upe.controllersJavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.BiConsumer;

import br.upe.controller.CondominoController;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Condomino;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;
import javafx.util.Callback;

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
    private TableColumn<Condomino, String> tableCPF;

    @FXML
    private TableColumn<Condomino, String> tableContato;

    @FXML
    private TableColumn<Condomino, String> tableNome;
    
    @FXML
    private TableColumn<Condomino, Condomino> tableAcoes;
    
    @FXML
    private Button btn_excluir;

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
	void ExcluirCondomino(MouseEvent event) {
		this.select = condominoTable.getSelectionModel().getSelectedItems();
		excluirCondomino();
		atualizaTabela();
	}
	
	private void excluirCondomino() {
		try {
			System.out.println("Objeto: " + this.select.get(0));
			condominoController.remover(this.select.get(0));
			Alerts.alertSuccess("Condomino deletado com sucesso!");
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
			
			// BOTÕES COM ÍCONES EM SVG
			  // configura a coluna para editar e deleter uma pessoa
//				initButtons(tableAcoes, 15, DELETE, (Condomino condomino, ActionEvent event) -> {
				  //excluirCondomino();
					
			    // Aqui vai toda a lógica para editar a pessoa
			 // }
				//);
			  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 /*public static <Condomino> void initButtons(TableColumn<Condomino, Condomino> tableColumn, int size, String svgIcon, BiConsumer<Condomino, ActionEvent> buttonAction) {
		    final int COLUMN_ICON_SPACE = 20; // espaço extra que terá dentro da célula da tabela
		    tableColumn.setMinWidth(size + COLUMN_ICON_SPACE);
		    tableColumn.setMaxWidth(size + COLUMN_ICON_SPACE);
		    tableColumn.setStyle("-fx-alignment: CENTER"); // centraliza os botões

		    Callback<TableColumn<Condomino, Condomino>, TableCell<Condomino, Condomino>> cellFactory = new Callback<TableColumn<Condomino, Condomino>, TableCell<Condomino, Condomino>>() {
		      @Override
		      public TableCell<Condomino, Condomino> call(final TableColumn<Condomino, Condomino> param) {
		        final TableCell<Condomino, Condomino> cell = new TableCell<Condomino, Condomino>() {
		          // chama o método auxiliar para criar um botão com o ícone svg dentro
		          private final Button btn = createIconButton(svgIcon, size);

		          // inseri o botão dentro da célula
		          @Override
		          public void updateItem(Condomino item, boolean empty) {
		            super.updateItem(item, empty);
		            if (empty) {
		              setGraphic(null);
		            } else {
		              setGraphic(btn);
		            }
		          }

		        {
		          // define o que irá acontecer quando o botão for clicado
		          btn.setOnAction((ActionEvent event) -> {
		        
		            Condomino data = getTableView().getItems().get(getIndex());
		            CondominoController cCondominoController = new CondominoController();
		            System.out.println("\nDados selecionados pelo icone: " + data);
		            try {
		            	  cCondominoController.remover((br.upe.model.entity.Condomino) data);
		            }catch(Exception e) {
		            	
		            }
		          });
		        }
		      };
		      return cell;
		      }
		    };
		    tableColumn.setCellFactory(cellFactory);
		  }
		  

		  // Cria um botão com o ícone svg dentro
		  public static Button createIconButton(String svgAbsolutePath, int size) {
		    SVGPath path = new SVGPath();
		    path.setContent(svgAbsolutePath);
		    Bounds bounds = path.getBoundsInLocal();

		    // scale to size size x size (max)
		    double scaleFactor = size / Math.max(bounds.getWidth(), bounds.getHeight());
		    path.setScaleX(scaleFactor);
		    path.setScaleY(scaleFactor);

		    Button button = new Button();
		    button.setPickOnBounds(true); // Garente que o botão terá o fundo transparente
		    button.setGraphic(path); // inseri o ícone gerado pelo svg no botão
		    button.setAlignment(Pos.CENTER);
		    button.getStyleClass().add("icon-button"); // classe criada para não ter o fundo cinza
		    // necessários para o ícone ficar contido dentro do botão
		    button.setMaxWidth(size);
		    button.setMaxHeight(size);
		    button.setMinWidth(size);
		    button.setMinHeight(size);
		    button.setPrefWidth(size);
		    button.setPrefHeight(size);
		    return button;
		  }*/
		  
	
}
