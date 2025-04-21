package com.cadastro.aplicativojavafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button bteditar;

    @FXML
    private Button btsalvar;

    @FXML
    private ToggleGroup grupo1;

    @FXML
    private RadioButton rdfeminino;

    @FXML
    private RadioButton rdmasculino;

    @FXML
    private TableColumn<?, ?> tcid;

    @FXML
    private TableColumn<?, ?> tcidade;

    @FXML
    private TableColumn<?, ?> tcnome;

    @FXML
    private TableColumn<?, ?> tcsexo;

    @FXML
    private TextField tfidade;

    @FXML
    private TextField tfnome;

    @FXML
    private TableView<?> tvtabela;

    @FXML
    void mostranome(ActionEvent event) {

        String name = tfnome.getText().toString();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Testando o sistema");

        alert.setHeaderText("Parabens! funcionou");

        alert.setContentText(name);
        alert.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
