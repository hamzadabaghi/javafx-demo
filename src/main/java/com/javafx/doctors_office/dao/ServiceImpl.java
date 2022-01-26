package com.javafx.doctors_office.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;


public class ServiceImpl implements Service {

    String request;
    ResultSet resultSet;
    Connection connection;
    PreparedStatement preparedStatement;
    Statement statement;

    public ServiceImpl() {
        connection = ConnectionMysql.connectionToDB();
    }

    @Override
    public ResultSet getPatients() throws Exception {

        request = "SELECT * from patients ";
        return connection.createStatement().executeQuery(request);
    }

    @Override
    public void savePatient(String firstName, String lastName, String cin, LocalDate addedDate) {
        try {


            String statement = "INSERT INTO patients(first_name,last_name,cin,added_date) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, cin);
            preparedStatement.setString(4, addedDate.toString());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void updatePatient(String firstName, String lastName, String cin, LocalDate addedDate) {

        try {
            String st = "UPDATE patients SET first_name = ? , last_name = ? , added_date = ? WHERE cin = ? ";
            preparedStatement = connection.prepareStatement(st);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, addedDate.toString());
            preparedStatement.setString(4, cin);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    @Override
    public void deletePatient(String cinToDelete) {
        try {
            request = "DELETE FROM patients WHERE cin = ?";
            preparedStatement = connection.prepareStatement(request);
            preparedStatement.setString(1, cinToDelete);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public int patientsCount() {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM patients");
            resultSet.next();
            return resultSet.getInt("rowcount");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }
}
