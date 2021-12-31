package br.upe.controllersJavaFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class VeiculoViewController {

    @FXML
    private TableView<?> VeiculoTable;

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
    private TextField cor;

    @FXML
    private TextField modelo;

    @FXML
    private ComboBox<?> num_AP;

    @FXML
    private TextField placa;

    @FXML
    private TableColumn<?, ?> tableBloco;

    @FXML
    private TableColumn<?, ?> tableCor;

    @FXML
    private TableColumn<?, ?> tableModelo;

    @FXML
    private TableColumn<?, ?> tablePlaca;

    @FXML
    private TableColumn<?, ?> tableUnidade;

    @FXML
    private ComboBox<?> unidade_set;

    @FXML
    void EditarVeiculo(MouseEvent event) {

    }

    @FXML
    void ExcluirVeiculo(MouseEvent event) {

    }

    @FXML
    void PesquisaAp(MouseEvent event) {

    }

    @FXML
    void Select(ActionEvent event) {

    }

    @FXML
    void salvarVeiculo(MouseEvent event) {

    }

}
