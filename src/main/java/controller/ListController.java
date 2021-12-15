package controller;

import start.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class ListController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("index"); 
    }
}