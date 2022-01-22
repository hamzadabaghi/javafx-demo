package com.javafx.doctors_office.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class HomeController {


    @FXML
    private TextField searchField;
    @FXML
    private Button signOutButton;
    @FXML
    private Pane panelUpdatePatients;
    @FXML
    private Button updatePatientsButton;
    @FXML
    private Pane panelAddPatients;
    @FXML
    private Button addPatientsButton;
    @FXML
    private Pane panelShowPatients;
    @FXML
    private Button showPatientsButton;
    @FXML
    private VBox patientsRows = null;

    public HomeController() {
    }


    @FXML
    public void handleNavigation(ActionEvent actionEvent) {
        if (actionEvent.getSource() == updatePatientsButton) {
            panelUpdatePatients.setStyle("-fx-background-color : #02030A");
            panelUpdatePatients.toFront();
        }
        if (actionEvent.getSource() == showPatientsButton) {
            panelShowPatients.setStyle("-fx-background-color : #02030A");
            panelShowPatients.toFront();
        }
        if (actionEvent.getSource() == addPatientsButton) {
            panelAddPatients.setStyle("-fx-background-color : #02030A");
            panelAddPatients.toFront();
        }
        if (actionEvent.getSource() == signOutButton) {
            System.out.println("Sign out");
        }
    }

}
