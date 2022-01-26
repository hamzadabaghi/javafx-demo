package com.javafx.doctors_office.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {
    Connection conn = null;

    public static Connection connectionToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/doctors_office", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("connection To database failed : " + ex.getMessage());
            return null;
        }
    }

}
