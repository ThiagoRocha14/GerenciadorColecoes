package controller;

import start.App;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.image.Image;
import model.Item;

public class ListController {

    @FXML private TableColumn<Item,Image> colunaImagem;
    @FXML private TableColumn<Item,String> colunaDescricao;
    @FXML private TableColumn<Item,String> colunaStatus;
    @FXML private TableColumn<Item,String> colunaColecao;
    @FXML private TableColumn<Item,Date> colunaDataAquisicao;
    
    private List<Item> listaItem;
    private ObservableList<Item> observableListItem;
    
    @FXML
    private void switchToPrimary() throws IOException {
        
        App.setRoot("index"); 
    }
    @FXML
    private void switchToAdd() throws IOException {
        App.setRoot("add");
    }
    
}