package com.mycompany.gerenciadorcolecoes;

import java.io.IOException;
import javafx.fxml.FXML;

public class CadastrosController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("index");
    }
    
}