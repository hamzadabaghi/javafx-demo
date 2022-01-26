package com.javafx.doctors_office.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.nio.file.Paths;

public class Home extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // create the root element
        URL url = Paths.get("src/main/resources/fxml/Login.fxml").toUri().toURL();
        Parent root = FXMLLoader.load(url);

        // delete borders
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setMaximized(false);

        // Create a scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        // Show the window
        primaryStage.show();
        primaryStage.centerOnScreen();

    }
}
