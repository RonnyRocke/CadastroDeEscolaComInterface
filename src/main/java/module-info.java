module com.cadastro.aplicativojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;


    exports com.cadastro.aplicativojavafx.model to javafx.graphics;
    opens com.cadastro.aplicativojavafx.model to javafx.fxml;

    exports com.cadastro.aplicativojavafx.controller to javafx.graphics;
    opens com.cadastro.aplicativojavafx.controller to javafx.fxml;


}