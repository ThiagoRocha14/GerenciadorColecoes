package controller;

import start.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Colecao;
import model.Status;
import model.dao.ColecaoDaoJDBC;
import model.dao.DaoFactory;
import model.dao.StatusDaoJDBC;

public class CadastrosController {
    @FXML private TextArea inputDescricaoStatus;
    @FXML private TextArea txtDescricaoColecao;
    @FXML private TextField txtTotal;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("index");
    }
    
    @FXML
    private void cadastrarStatus(ActionEvent event) throws Exception {
        Status status = new Status();
        String descricao = inputDescricaoStatus.getText();
        inputDescricaoStatus.setText("");
        
        if(!descricao.equals(""))
            status.setDescricao(descricao);
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setContentText("O campo descrição é obrigatório");
            alert.showAndWait();
            return;
        }
        
        try{
            StatusDaoJDBC dao = DaoFactory.novoStatusDao();
            dao.incluir(status);
        }catch (Exception EX){
            System.out.println(EX.getMessage());
        }
    }
    
    @FXML
    private void cadastrarColecao(ActionEvent event) {
        Colecao colecao = new Colecao();   
        String descricao = txtDescricaoColecao.getText();
        txtDescricaoColecao.setText("");
        Integer total = 0;
        if(!txtTotal.getText().equals(""))
            total = Integer.parseInt(txtTotal.getText());
        txtTotal.setText("");
        if(!descricao.equals(""))
            colecao.setDescricao(descricao);
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Aviso");
            alert.setContentText("O campo descrição é obrigatório");
            alert.showAndWait();
            return;
        }
        if(total != null)
            colecao.setTotalItensColecao(total);
        try{
            ColecaoDaoJDBC dao = DaoFactory.novoColecaoDao();
            dao.incluir(colecao);
        }catch (Exception EX){
            System.out.println(EX.getMessage());
        }
    }
    
}