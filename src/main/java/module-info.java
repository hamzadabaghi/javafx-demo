module com.javafx.doctors_office {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.javafx.doctors_office.controllers to javafx.fxml;
    exports com.javafx.doctors_office.application;
    exports com.javafx.doctors_office.controllers;
    exports com.javafx.doctors_office.dao;
    exports com.javafx.doctors_office.models;


}