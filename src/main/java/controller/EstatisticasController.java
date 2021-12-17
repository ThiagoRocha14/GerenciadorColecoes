package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import model.Colecao;
import model.Item;
import model.Status;
import model.dao.ColecaoDaoJDBC;
import model.dao.DaoFactory;
import model.dao.ItemDaoJDBC;
import start.App;

/**
 * FXML Controller class
 *
 * @author aluno
 */
public class EstatisticasController implements Initializable {
    
    @FXML private ChoiceBox selectColecao;
    @FXML private TableView<Item> tableEstatisticaItem;
        @FXML private TableColumn<Item,String> itemItem;
        @FXML private TableColumn<Item,String> statusItem;
        @FXML private TableColumn<Item,String> colecaoItem;
        
        
    @FXML private TableView<Item> tableEstatisticaStatus;
        @FXML private TableColumn<Status,String> statusStatus;
        @FXML private TableColumn<Status,Number> totalPorStatus;
        @FXML private TableColumn<Status,String> colecaoStatus;
    
    private List<Item> listaItemItem;
    private ObservableList<Item> observableListItemItem;
    
    private List<Item> listaItemStatus;
    private ObservableList<Item> observableListItemStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarItens();
        ColecaoDaoJDBC dao1;
        try {
            dao1 = DaoFactory.novoColecaoDao();
            List<Colecao> lista1 = dao1.listar();
            for (Colecao colecao : lista1){
                selectColecao.getItems().add(colecao.getDescricao());
            }
        } catch (Exception ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("index");
    }
    
    public void carregarItens() {        
        itemItem.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        statusItem.setCellValueFactory(new PropertyValueFactory<>("Status"));
        colecaoItem.setCellValueFactory(new PropertyValueFactory<>("Colecao"));
        
        totalPorStatus.setCellValueFactory(new PropertyValueFactory<>("TotalPorStatus"));
        statusStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        colecaoStatus.setCellValueFactory(new PropertyValueFactory<>("Colecao"));
        
        try {
            ItemDaoJDBC dao = DaoFactory.novoItemDao();
            listaItemItem = dao.listarFiltroItem();
            listaItemStatus = dao.listarFiltroStatus();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        observableListItemItem = FXCollections.observableArrayList(listaItemItem);
        tableEstatisticaItem.setItems(observableListItemItem);
        
        observableListItemStatus = FXCollections.observableArrayList(listaItemStatus);
        tableEstatisticaStatus.setItems(observableListItemStatus);
    }
    
    public void filtrarItens() {
        String colecao = null;
        try {
            colecao = selectColecao.getValue().toString();
        } catch (Exception e) {
            return;
        }        
        
        if(colecao == null) return;
        itemItem.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        statusItem.setCellValueFactory(new PropertyValueFactory<>("Status"));
        colecaoItem.setCellValueFactory(new PropertyValueFactory<>("Colecao"));
        
        totalPorStatus.setCellValueFactory(new PropertyValueFactory<>("TotalPorStatus"));
        statusStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        colecaoStatus.setCellValueFactory(new PropertyValueFactory<>("Colecao"));
        
        
        try {
            ItemDaoJDBC dao = DaoFactory.novoItemDao();
            listaItemItem = dao.listarFiltroItem(colecao);
            listaItemStatus = dao.listarFiltroStatus(colecao);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        observableListItemItem = FXCollections.observableArrayList(listaItemItem);
        tableEstatisticaItem.setItems(observableListItemItem);
        
        observableListItemStatus = FXCollections.observableArrayList(listaItemStatus);
        tableEstatisticaStatus.setItems(observableListItemStatus);
    }
    
}
