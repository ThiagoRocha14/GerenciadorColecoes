/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.apache.commons.io.FilenameUtils;
import start.App;

/**
 *
 * @author aluno
 */
public class AddController {
    @FXML private ImageView imgView;
    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("index"); 
    }
    
    @FXML
    private void selecionarImagem() throws IOException {
        FileChooser fileChooser = new FileChooser();
        //FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        //FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        //FileChooser.ExtensionFilter extFilterJPEG = new FileChooser.ExtensionFilter("JPEG files (*.jpeg)", "*.JPEG");
        //fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG,extFilterJPEG);
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            Image image = new Image(file.toURI().toString());
            String type = FilenameUtils.getExtension(file.toURI().toString());
            System.out.println(file.toURI().toString());
            imgView.setImage(image);
            //ImageIO.write(image, type, new File("./fotos"));
        }
    }
   
}
