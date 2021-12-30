package br.upe.controllersJavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MoradorViewController {

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
    private TableView<?> moradorTable;

    @FXML
    private TextField cpf;

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
    void EditarMorador(MouseEvent event) {

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

    @FXML
    void salvarMorador(MouseEvent event) {

    }

}
