package com.cadastro.aplicativojavafx.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.file.Paths;

public class Principal extends Application {

    public void start(Stage stage) throws Exception {
        // Caminho do FXML
        String fxmlPath = "src/main/resources/com/cadastro/aplicativojavafx.telas/estudante.fxml";

        // Carregando o FXML via URI convertido em URL
        FXMLLoader fxmlLoader = new FXMLLoader(Paths.get(fxmlPath).toUri().toURL());
        Parent root = fxmlLoader.load();

        // Criando a cena
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Cadastro De Estudantes");
        stage.setScene(scene);
        stage.show();
    }
}
