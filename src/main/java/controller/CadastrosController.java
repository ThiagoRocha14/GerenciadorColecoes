package controller;

import start.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
        status.setDescricao(descricao);
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
        Integer total = Integer.parseInt(txtTotal.getText());
        txtTotal.setText("");
        colecao.setDescricao(descricao);
        colecao.setTotalItensColecao(total);
        try{
        ColecaoDaoJDBC dao = DaoFactory.novoColecaoDao();
        dao.incluir(colecao);
        }catch (Exception EX){
            System.out.println(EX.getMessage());
        }
    }
    
}