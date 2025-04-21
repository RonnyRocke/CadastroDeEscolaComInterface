package com.cadastro.aplicativojavafx.controller;

import com.cadastro.aplicativojavafx.dao.EstudanteDao;
import com.cadastro.aplicativojavafx.model.Estudante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
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
    private TableView<Estudante> tvtabela;

    Estudante estudante = new Estudante();
    EstudanteDao estudanteDao = new EstudanteDao();


    private List<Estudante> todosEstudantes;
    private ObservableList<Estudante>estudanteObservableList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prepararListaTabela();
    }

    @FXML
    void salvar(ActionEvent event) {

        if (validador()) {

            estudante.setNome(tfnome.getText().toString());
            estudante.setIdade(Integer.valueOf(tfidade.getText().toString()));

            if (rdmasculino.isSelected()) {
                estudante.setSexo("Masculino");
            }

            if (rdfeminino.isSelected()) {
                estudante.setSexo("Feminino");

            }

            estudanteDao.inserir(estudante);
            prepararListaTabela();
            limpar();

            System.out.println("Estudante Salvo com sucesso!");

        }
    }

    void prepararListaTabela(){

        tcid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcsexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        tcidade.setCellValueFactory(new PropertyValueFactory<>("idade"));

        todosEstudantes = estudanteDao.buscarTodos();

        estudanteObservableList = FXCollections.observableList(todosEstudantes);

        tvtabela.setItems(estudanteObservableList);


    }

    void limpar(){
        tfnome.setText("");
        tfidade.setText("");

    }

    public boolean validador(){

        StringBuffer mensagem = new StringBuffer();

        if(tfnome.getText().equals("")){
            mensagem.append("O campo nome é obrigatório!!\n");
        }
        if(tfidade.getText().equals("")){
            mensagem.append("O campo idade é obrigatório!\n");
        }

        if(mensagem.length()>0){

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("ERRO");
            alert.setContentText(mensagem.toString());
            alert.show();

            return false;

        }
        else {
            return true;
        }
        }
}
