package com.javafx.doctors_office.controllers;

import com.javafx.doctors_office.dao.ConnectionMysql;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {


    @FXML
    public Button closeButton;
    @FXML
    public Button signInLabel;
    @FXML
    public PasswordField passwordLabel;
    @FXML
    public TextField usernameLabel;
    @FXML
    public Label errorsLabel;
    private Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;


    public LoginController() {
        connection = ConnectionMysql.connectionToDB();
    }


    @FXML
    public void handleSignInButton(MouseEvent event) {

        if (event.getSource() == signInLabel) {

            if (logIn().equals("Success")) {
                try {

                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.close();
                    URL url = Paths.get("src/main/resources/fxml/Home.fxml").toUri().toURL();
                    Scene scene = new Scene(FXMLLoader.load(url));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
        }
    }

    private String logIn() {
        String status = "Success";
        String username = usernameLabel.getText();
        String password = passwordLabel.getText();
        if (username.isEmpty() || password.isEmpty()) {
            setErrorsLabel(Color.TOMATO, "Credentials should not be empty");
            status = "Error";
        } else {
            String sql = "SELECT * FROM admins WHERE username = ? AND password = ?";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    setErrorsLabel(Color.TOMATO, "Enter Correct Email or Password");
                    status = "Error";
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
        return status;
    }

    @FXML
    public void handleCloseButton(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    private void setErrorsLabel(Color color, String text) {
        errorsLabel.setTextFill(color);
        errorsLabel.setText(text);
    }

}
