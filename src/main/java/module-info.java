module com.javafx.doctors_office {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    opens com.javafx.doctors_office.controllers to javafx.fxml;
    exports com.javafx.doctors_office.application;
    exports com.javafx.doctors_office.controllers;
    exports com.javafx.doctors_office.dao;
}