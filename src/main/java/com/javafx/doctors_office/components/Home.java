package com.javafx.doctors_office.components;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Home extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        // stage = Fenetre
        primaryStage.setTitle(" Doctor's office ");

        /* root : element parent : en general des gestionnaires de positionnement : Layout Managers
           scene : l'interieur d'un stage
        */

        StackPane root = new StackPane();
        root.getChildren().add(new Label("Hello world"));
        Scene scene = new Scene(root,600,400);



        
        
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();

    }
}
