package com.example.bookb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;


public class Details extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setResizable(false);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Details.fxml")));
        Scene scene = new Scene(root);
        stage.setTitle("Book Details");
        stage.setScene(scene);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
