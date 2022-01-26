package com.javafx.doctors_office.controllers;

import com.javafx.doctors_office.dao.Service;
import com.javafx.doctors_office.dao.ServiceImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.time.LocalDate;


public class HomeController {

    @FXML
    private Button deleteButton;
    @FXML
    private TextField cinDeleteField;
    @FXML
    private Label numberOfPatients;
    @FXML
    TableView tableData;
    boolean flag = false;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField cinField;
    @FXML
    private DatePicker addedDateField;
    @FXML
    private Button saveButton;
    @FXML
    private TextField firstNameUpdateField;
    @FXML
    private TextField lastNameUpdateField;
    @FXML
    private TextField cinUpdateField;
    @FXML
    private DatePicker addedDateUpdateField;
    @FXML
    private Button updateButton;
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
    private final Service service;
    private ObservableList<ObservableList> data;


    public HomeController() {
        service = new ServiceImpl();
    }


    @FXML
    public void handleNavigation(ActionEvent actionEvent) {
        if (actionEvent.getSource() == updatePatientsButton) {
            panelUpdatePatients.setStyle("-fx-background-color : #02030A");
            panelUpdatePatients.toFront();
            handlePatientsCount();
        }
        if (actionEvent.getSource() == showPatientsButton) {
            panelShowPatients.setStyle("-fx-background-color : #02030A");

            if (!flag) {
                fetchColumnList();
                fetchRowList();
                handlePatientsCount();
            }
            flag = true;
            panelShowPatients.toFront();
        }
        if (actionEvent.getSource() == addPatientsButton) {
            panelAddPatients.setStyle("-fx-background-color : #02030A");
            panelAddPatients.toFront();
        }
        if (actionEvent.getSource() == signOutButton) {
            System.out.println("Sign out");
        }
        if (actionEvent.getSource() == saveButton) {
            LocalDate date = addedDateField.getValue();
            service.savePatient(firstNameField.getText(), lastNameField.getText(), cinField.getText(), date);
            firstNameField.clear();
            lastNameField.clear();
            cinField.clear();
            addedDateField.getEditor().clear();
            fetchRowList();
            handlePatientsCount();

        }
        if (actionEvent.getSource() == updateButton) {

            LocalDate date = addedDateUpdateField.getValue();
            service.updatePatient(firstNameUpdateField.getText(), lastNameUpdateField.getText(), cinUpdateField.getText(), date);
            firstNameUpdateField.clear();
            lastNameUpdateField.clear();
            cinUpdateField.clear();
            addedDateUpdateField.getEditor().clear();
            fetchRowList();
            handlePatientsCount();

        }
    }

    private void fetchColumnList() {
        try {
            ResultSet rs = service.getPatients();
            for (int i = 1; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1).toUpperCase());
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });
                tableData.getColumns().removeAll(col);
                tableData.getColumns().addAll(col);
            }
        } catch (Exception e) {
        }
    }

    private void fetchRowList() {
        data = FXCollections.observableArrayList();
        try {
            ResultSet rs = service.getPatients();
            while (rs.next()) {
                ObservableList row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
                    row.add(rs.getString(i));
                data.add(row);
            }
            tableData.setItems(data);
        } catch (Exception e) {
        }
    }

    public void handleCloseButton(ActionEvent actionEvent) {
        Stage stage = (Stage) signOutButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handlePatientsCount() {
        int count = service.patientsCount();
        numberOfPatients.setText(count + "");
    }

    @FXML
    public void handleDeleteButton(ActionEvent actionEvent) {
        if (actionEvent.getSource() == deleteButton) {
            String cin = cinDeleteField.getText();
            service.deletePatient(cin);
            cinDeleteField.clear();
            fetchRowList();
            handlePatientsCount();
        }
    }
}
