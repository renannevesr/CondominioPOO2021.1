package br.upe.controllersJavaFX;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.upe.controller.ApartamentoController;
import br.upe.controller.CondominoController;
import br.upe.model.dao.PessoaDAO.JPAPessoaDAO;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Condomino;
import br.upe.model.entity.TableCondominoAp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.NoResultException;
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

public class CondominoViewController implements Initializable {

	private ObservableList<TableCondominoAp> select;

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
	private TableView<TableCondominoAp> condominoTable;

	@FXML
	private TableColumn<Condomino, String> tableCPF;

	@FXML
	private TableColumn<Condomino, String> tableContato;

	@FXML
	private TableColumn<Condomino, String> tableNome;

	@FXML
	private TableColumn<Apartamento, Blocos> tableAcoes;

	@FXML
	private TableColumn<Condomino, String> tableAcoes1;

	@FXML
	private Button btn_excluir;

	@FXML
	private ComboBox<Blocos> bloco_set;

	@FXML
	private ComboBox<Integer> unidade_set;

	@FXML
	void Select(ActionEvent event) {
	}

	CondominoController condominoController = new CondominoController();
	ApartamentoController apartamentoController = new ApartamentoController();
	JPAPessoaDAO dao = new JPAPessoaDAO();

	@FXML
	void salvarCondomino(MouseEvent event) throws IOException {

		if (this.select == null || this.select.isEmpty()) {
			condominoTable.getSelectionModel().clearSelection();
			cadastrarCondomino(null);
		} else {
			cadastrarCondomino(condominoTable.getSelectionModel().getSelectedItem().getIdCond());
		}
		condominoTable.getSelectionModel().clearSelection();
	}

	private void cadastrarCondomino(Long id) throws IOException {
		String nome = this.nome.getText();
		String cpf = this.cpf.getText();
		String contato = this.contato.getText();

		int numero = 0;
		if (this.unidade_set.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.unidade_set.getSelectionModel().getSelectedItem();

		Blocos bloco = (Blocos) this.bloco_set.getSelectionModel().getSelectedItem();

		try {
			if (nome.equals("") || cpf.equals("") || contato.equals("") || bloco == null || numero == 0) {
				Alerts.alertError("Seu burro, sua anta, preencha tudo sua misera!");
			} else {
				Apartamento ap = new Apartamento();
				ap.setBloco(bloco);
				ap.setNumero(numero);

				Condomino condomino = new Condomino();
				condomino.setNome(nome);
				condomino.setCpf(cpf);
				condomino.setContato(contato);

				// cadastrar
				if (id == null) {
					// verifica se ja existe um condomino naquele apartamento
					if (isExistent(bloco, numero)) {
					} else {
						// se nao existir, verifica se o cpf já está cadastrado
						if (isCadastrado(condomino.getCpf())) {
							// caso exista o cpf, significa atualizar o Ap com esse condomino existente
							ap = condominoController.buscarApartamento(bloco, numero).get(0);
							ap.setCondomino(condomino);
							apartamentoController.atualizar(ap);
						} else {
							// se nao existir o cpf, apenas cadastra um novo condomino
							condominoController.cadastrar(condomino, ap);
							Alerts.alertSuccess("Condomino cadastrado com sucesso!");
						}
					}
				}

				// atualizar
				else {

					Condomino c = TableCondominoAp.toCondomino(condominoTable.getSelectionModel().getSelectedItem());

					if (bloco != c.getApartamentos().get(0).getBloco()
							&& numero != c.getApartamentos().get(0).getNumero()) {
						if (isExistent(bloco, numero)) {
						}
					}
					condomino.setId(id);
					condominoController.atualizar(condomino);
					Alerts.alertSuccess("Condomino atualizado com sucesso!");
				}
				limpaTela();
				atualizaTabela();
			}
		}

		catch (Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Condomino!\n" + (e.getMessage()
					.compareTo("org.hibernate.exception.ConstraintViolationException: could not execute statement") == 0
							? "CPF já cadastrado"
							: e.getMessage()));
		}

	}

	private boolean isCadastrado(String cpf) {
		Condomino c = new Condomino();
		try {
			c = (Condomino) dao.buscarCPF(c, cpf);
			return true;
		} catch (Exception e) {
			if (e instanceof NoResultException) {
			}
		}
		return false;
	}

	private boolean isExistent(Blocos b, int n) {
		List<Apartamento> aux = null;
		try {
			aux = apartamentoController.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 0; i < aux.size(); i++) {
			if (aux.get(i).getBloco() == b && aux.get(i).getNumero() == n && aux.get(i).getCondomino() != null) {
				Alerts.alertError("Já há um condomino cadastrado neste apartamento!"
						+ "\nSe deseja alterar alguma coisa exclua e salve de novo!");
				return true;
			}
		}
		return false;
	}

	@FXML
	private void listarCondominos() {
		try {
			condominoController.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@FXML
	void EditarCondomino(MouseEvent event) {
		this.select = condominoTable.getSelectionModel().getSelectedItems();
		Condomino c = TableCondominoAp.toCondomino(condominoTable.getSelectionModel().getSelectedItem());
		this.cpf.setText(c.getCpf());
		this.nome.setText(c.getNome());
		this.contato.setText(c.getContato());
		this.bloco_set.setValue(c.getApartamentos().get(0).getBloco());
		this.unidade_set.setValue(c.getApartamentos().get(0).getNumero());
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
		this.bloco_set.setValue(null);
		this.unidade_set.setValue(null);
	}

	private void excluirCondomino() {
		try {
			condominoController.remover(TableCondominoAp.toCondomino(this.select.get(0)));
			Alerts.alertSuccess("Condomino deletado com sucesso!");
		} catch (Exception e) {
			Alerts.alertError("Não foi possível excluir esse condomino!");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void atualizaTabela() {
		try {
			List<TableCondominoAp> cap = new ArrayList<TableCondominoAp>();
			List<Condomino> c = new ArrayList<Condomino>();
			this.ap = apartamentoController.listar();
			for (Apartamento i : ap) {
				if (i.getCondomino() != null) {
					c.add(i.getCondomino());
					cap.add(new TableCondominoAp(i.getCondomino(), i));
				}
			}

			condominoTable.setItems(FXCollections.observableArrayList(cap));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void PesquisaAp(MouseEvent event) {
		int numero = 0;
		if (this.num_AP.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.num_AP.getSelectionModel().getSelectedItem();

		Blocos bloco = (Blocos) this.bloco_AP.getSelectionModel().getSelectedItem();
		buscarAp(numero, bloco);
	}

	public List<Apartamento> ap = new ArrayList<Apartamento>();

	private void buscarAp(int numero, Blocos bloco) {

		try {

			System.out.println(condominoController.buscarApartamento(bloco, numero));
			this.ap = condominoController.buscarApartamento(bloco, numero);
			carregarTableView();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		limpaTela();
		carregarTableView();

		condominoTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarItemTableViewCondomino(newValue));

	}

	public void carregarTableView() {
		ObservableList<Integer> list1 = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		ObservableList<Blocos> list2 = FXCollections.observableArrayList(Blocos.values());

		num_AP.setItems(list1);
		bloco_AP.setItems(list2);
		bloco_set.setItems(list2);
		unidade_set.setItems(list1);

		// Tabela
		try {
			List<Condomino> c = new ArrayList<Condomino>();
			List<TableCondominoAp> cap = new ArrayList<TableCondominoAp>();

			for (Apartamento i : ap) {
				if (i.getCondomino() != null) {
					c.add(i.getCondomino());
					cap.add(new TableCondominoAp(i.getCondomino(), i));
				}
			}
			ObservableList<TableCondominoAp> list3 = FXCollections.observableArrayList(cap);

			tableNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			tableCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			tableContato.setCellValueFactory(new PropertyValueFactory<>("contato"));
			tableAcoes.setCellValueFactory(new PropertyValueFactory<>("bloco"));
			tableAcoes1.setCellValueFactory(new PropertyValueFactory<>("numero"));

			condominoTable.setItems(list3);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void selecionarItemTableViewCondomino(TableCondominoAp newValue) {
		System.out.println("Cliente selecionado no TableView: " + newValue.getNome());
	}

}