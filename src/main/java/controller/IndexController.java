package controller;

import start.App;
import java.io.IOException;
import javafx.fxml.FXML;

public class IndexController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("cadastros");
    }
    @FXML
    private void switchToThird() throws IOException {
        App.setRoot("list");
    }
    @FXML
    private void switchToEstatistica() throws IOException {
        App.setRoot("estatisticas");
    }
}
