package br.upe.controllersJavaFX;

import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;

import br.upe.controller.ApartamentoController;
import br.upe.controller.CondominoController;
import br.upe.controller.VisitanteController;
import br.upe.model.dao.PessoaDAO.JPAPessoaDAO;
import br.upe.model.entity.Apartamento;
import br.upe.model.entity.Blocos;
import br.upe.model.entity.Condomino;
import br.upe.model.entity.Visitante;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class VisitanteViewController {

	private ObservableList<Visitante> select;

	@FXML
	private ComboBox<?> bloco_AP;

	@FXML
	private ComboBox<?> bloco_set;

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
	private TextField cpf;

	@FXML
	private TableView<?> visitanteTable;

	@FXML
	private TextField nome;

	@FXML
	private ComboBox<?> num_AP;

	@FXML
	private TableColumn<?, ?> tableAcoes;

	@FXML
	private TableColumn<?, ?> tableAcoes1;

	@FXML
	private TableColumn<?, ?> tableCPF;

	@FXML
	private TableColumn<?, ?> tableNome;

	@FXML
	private ComboBox<?> unidade_set;

	@FXML
	void EditarVisitante(MouseEvent event) {

	}

	@FXML
	void ExcluirVisitante(MouseEvent event) {

	}

	@FXML
	void PesquisaAp(MouseEvent event) {

	}

	@FXML
	void Select(ActionEvent event) {

	}

	@FXML
	void salvarVisitante(MouseEvent event) throws IOException {

		if (this.select == null || this.select.isEmpty()) {
			visitanteTable.getSelectionModel().clearSelection();
			cadastrarVisitante(null);
		} else {
			Visitante v = new Visitante();
			v = (Visitante) visitanteTable.getSelectionModel().getSelectedItem();
			cadastrarVisitante(v.getId());
		}
	}

	CondominoController condominoController = new CondominoController();
	VisitanteController visitanteController = new VisitanteController();
	ApartamentoController apartamentoController = new ApartamentoController();
	JPAPessoaDAO dao = new JPAPessoaDAO();

	private void cadastrarVisitante(Long id) throws IOException {
		String nome = this.nome.getText();
		String cpf = this.cpf.getText();

		int numero = 0;
		if (this.unidade_set.getSelectionModel().getSelectedItem() != null)
			numero = (int) this.unidade_set.getSelectionModel().getSelectedItem();

		Blocos bloco = (Blocos) this.bloco_set.getSelectionModel().getSelectedItem();

		try {
			if (nome == null || cpf == null || bloco == null || numero == 0) {
				Alerts.alertError("Seu burro, sua anta, preencha tudo sua misera!");
			} else {
				Apartamento ap = new Apartamento();
				ap.setBloco(bloco);
				ap.setNumero(numero);

				Visitante visitante = new Visitante();
				visitante.setNome(nome);
				visitante.setCpf(cpf);

				// cadastrar
				if (id == null) {
					if (isCadastrado(visitante.getCpf())) {
						Visitante v = (Visitante) dao.buscarCPF(visitante, visitante.getCpf());
						// se o cpf ja esta cadastrado, lança um alert de confirmação
						if (Alerts.alertConfirmation(
								"Já existe um Condomino cadastrado nesse CPF. Utilizar informações existentes?",
								null)) {
							// se apertar sim, mantém as informações e apenas coloca aquele condomino em
							// outro Ap
							ap = condominoController.buscarApartamento(bloco, numero).get(0);
							v.setApartamento(ap);
							apartamentoController.atualizar(ap);
						} else {
							// se não, atualiza os dados do condomino e coloca em outro Ap
							v.setNome(nome);
							visitanteController.atualizar(v);
							Alerts.alertSuccess("Condomino atualizado com sucesso!");
							ap = condominoController.buscarApartamento(bloco, numero).get(0);
							v.setApartamento(ap);
							apartamentoController.atualizar(ap);
						}
					} else {
						// se nao existir o cpf, apenas cadastra um novo visitante
						visitanteController.cadastrar(visitante);
						Alerts.alertSuccess("Condomino cadastrado com sucesso!");
					}
				}

				// atualizar
//				else {
//
//					Visitante v = TableCondominoAp.toVisitante(visitanteTable.getSelectionModel().getSelectedItem());
//
//					// verifica se o bloco que tentou cadastrar é diferente do que chegou ao editar
//					if (bloco != v.getApartamentos().get(0).getBloco()
//							|| numero != c.getApartamentos().get(0).getNumero()) {
//						// se for diferente, vai verificar se existe alguem cadastrado
//						if (!isExistent(bloco, numero)) {
//							// se nao existir, vai jogar aquele condomino num ap novo
//							ap = condominoController.buscarApartamento(bloco, numero).get(0);
//							ap.setCondomino(c);
//							apartamentoController.atualizar(ap);
//							Alerts.alertSuccess("Cadastrado com sucesso!");
//						}
//					} else {
//						// se o bloco e o numero continua o mesmo, apenas atualiza o condomino
//						condomino.setId(id);
//						condominoController.atualizar(condomino);
//						Alerts.alertSuccess("Condomino atualizado com sucesso!");
//					}
//				}
//				limpaTela();
//				atualizaTabela();
			}
		}

		catch (Exception e) {
			Alerts.alertError("Erro ao tentar cadastrar esse Condomino!\n" + (e.getMessage()
					.compareTo("org.hibernate.exception.ConstraintViolationException: could not execute statement") == 0
							? "CPF já cadastrado"
							: e.getMessage()));
		}

	}

	private void limpaTela() {
		this.nome.setText(null);
		this.cpf.setText(null);
		this.bloco_set.setValue(null);
		this.unidade_set.setValue(null);
	}

	private void atualizaTabela() {
//		try {
//			List<TableCondominoAp> cap = new ArrayList<TableCondominoAp>();
//			List<Condomino> c = new ArrayList<Condomino>();
//			this.ap = apartamentoController.listar();
//			for (Apartamento i : ap) {
//				if (i.getCondomino() != null) {
//					c.add(i.getCondomino());
//					cap.add(new TableCondominoAp(i.getCondomino(), i));
//				}
//			}
//
//			visitanteTable.setItems(FXCollections.observableArrayList(cap));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
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

}
