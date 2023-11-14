package com.example.bookb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Profile extends Application {


    @Override
    public void start(Stage profileStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainMenu.class.getResource("Profile.fxml"));
        profileStage.setResizable(false);
        Scene      scene      = new Scene(fxmlLoader.load(), 1280, 698);
        profileStage.setTitle("Profile");
        profileStage.setScene(scene);
        profileStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
