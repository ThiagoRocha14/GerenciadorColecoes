package controller;

import start.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastrosController {
    @FXML private TextArea inputDescricaoStatus;
    @FXML private TextArea txtDescricaoColecao;
    @FXML private TextField txtTotal;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("index");
    }
    
    @FXML
    private void cadastrarStatus(ActionEvent event) {

    String descricao = inputDescricaoStatus.getText();
    inputDescricaoStatus.setText("");
    System.out.println(descricao);
    }
    
    @FXML
    private void cadastrarColecao(ActionEvent event) {
        
    String descricao = txtDescricaoColecao.getText();
    txtDescricaoColecao.setText("");
    Integer total = Integer.parseInt(txtTotal.getText());
    txtTotal.setText("");
    System.out.println(descricao+"Total: "+total);
    }
    
}