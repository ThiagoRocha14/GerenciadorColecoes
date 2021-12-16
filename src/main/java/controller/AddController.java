/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.Colecao;
import model.Item;
import model.Status;
import model.dao.ColecaoDaoJDBC;
import model.dao.DaoFactory;
import model.dao.ItemDaoJDBC;
import model.dao.StatusDaoJDBC;
import start.App;

/**
 *
 * @author aluno
 */
public class AddController implements Initializable{
    @FXML private ImageView imgView;
    @FXML private ChoiceBox selectColecao;
    @FXML private ChoiceBox selectStatus;
    @FXML private TextField txtDescAdd;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("index"); 
    }
    
    @FXML
    private void selecionarImagem() throws IOException, Exception {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            System.out.println(file.toURI().toString());
            imgView.setImage(image);
        }
    }
    
    @FXML
    private void salvarItem() throws IOException {
        App.setRoot("index"); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        StatusDaoJDBC dao;
        ColecaoDaoJDBC dao1;
        try {
            dao = DaoFactory.novoStatusDao();
            dao1 = DaoFactory.novoColecaoDao();
        List<Status> lista = dao.listar();
        for (Status status : lista){
            selectStatus.getItems().add(status.getDescricao());
        }
        List<Colecao> lista1 = dao1.listar();
        for (Colecao colecao : lista1){
            selectColecao.getItems().add(colecao.getDescricao());
        }
        } catch (Exception ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void cadastrarItem(ActionEvent event) throws Exception {
        Item item = new Item();
        String path = imgView.getImage().getUrl();
        String colecaoDescricao = selectColecao.getValue().toString();
        String statusDescricao = selectStatus.getValue().toString();
        String descricaoItem = txtDescAdd.toString();
        item.setCaminhoFoto(path);
        item.setColecao(colecaoDescricao);
        item.setDescricao(descricaoItem);
        item.setStatus(statusDescricao);
        try {
            ItemDaoJDBC daoItem = DaoFactory.novoItemDao();
            daoItem.incluir(item);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
