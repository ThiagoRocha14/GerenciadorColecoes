module com.mycompany.gerenciadorcolecoes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.gerenciadorcolecoes to javafx.fxml;
    exports com.mycompany.gerenciadorcolecoes;
}
