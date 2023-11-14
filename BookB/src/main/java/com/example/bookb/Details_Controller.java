package com.example.bookb;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Details_Controller implements Initializable {

    @FXML
    private Label BBauthor;
    @FXML
    private Label BBtitle;
    @FXML
    private ImageView photo;
    @FXML
    private Label infoAuthor;
    @FXML
    private Label infoTitle;
    @FXML
    private Button returnMenu;


        @FXML
        void returnstoMenu(ActionEvent event) throws IOException{
            Parent  tableViewParent =   FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainMenu.fxml")));
            Scene   tableViewScene  =   new Scene(tableViewParent);

            Stage   window  =   (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


