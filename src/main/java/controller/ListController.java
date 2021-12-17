package controller;

import start.App;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import model.Item;
import model.dao.DaoFactory;
import model.dao.ItemDaoJDBC;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.image.ImageView;

public class ListController implements Initializable {

    @FXML private TableView<Item> tabelaItens;    
    @FXML private TableColumn<Item,Image> colunaImagem;
    @FXML private TableColumn<Item,String> colunaDescricao;
    @FXML private TableColumn<Item,String> colunaStatus;
    @FXML private TableColumn<Item,String> colunaColecao;
    @FXML private TableColumn<Item,LocalDate> colunaDataAquisicao;
    
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
    
    @FXML
    private void btnExcluir() throws IOException, Exception {
        Item itemselecionado = tabelaItens.selectionModelProperty().getValue().getSelectedItem();
        ItemDaoJDBC dao = DaoFactory.novoItemDao();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Aviso");
        alert.setContentText("Deseja excluir o item selecionado?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
           String mensagem = "";
           try {
               dao.excluir(itemselecionado);
           }catch(Exception E){
               mensagem = "Ocorreu um erro "+ E.getMessage();
               Alert alertErro = new Alert(Alert.AlertType.INFORMATION);
               alertErro.setTitle("Erro");
               alertErro.setContentText(mensagem);
               alertErro.showAndWait();
           }   
        }
        carregarItens();
    }
    
    @FXML
    private void btnEditar() throws IOException, Exception {
        Item itemselecionado = tabelaItens.selectionModelProperty().getValue().getSelectedItem();
        AddController.setItemSelecionado(itemselecionado);
        App.setRoot("add");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarItens();
    }
    
    public void carregarItens() {
        
        //Ele tá pegando a quantidade certa dos itens, o problema tá sendo na hora de exibir
        //Você pode testar que a quantidade de itens que você colocar vai aparecer na tabela clicável, mas não visível
        //A gente pode usar uma propriedade Callback tbm, tem sobre no StackOverflow
        
        colunaImagem.setCellValueFactory(new PropertyValueFactory<>("Foto"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));
        colunaStatus.setCellValueFactory(new PropertyValueFactory<>("Status"));
        colunaColecao.setCellValueFactory(new PropertyValueFactory<>("Colecao"));
        colunaDataAquisicao.setCellValueFactory(new PropertyValueFactory<>("DataAquisicao"));
        colunaDataAquisicao.setCellFactory(col -> new TableCell<Item, LocalDate>() {
            @Override
            protected void updateItem(LocalDate item, boolean empty) {

                super.updateItem(item, empty);
                if (empty)
                    setText(null);
                else
                    setText(String.format(item.format(formatter)));
            }
        });
        try {
            ItemDaoJDBC dao = DaoFactory.novoItemDao();
            listaItem = dao.listar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        observableListItem = FXCollections.observableArrayList(listaItem);
        tabelaItens.setItems(observableListItem);
    }
    
}