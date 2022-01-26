package com.javafx.doctors_office.dao;

import java.sql.ResultSet;
import java.time.LocalDate;

public interface Service {

    ResultSet getPatients() throws Exception;

    void savePatient(String firstname, String lastname, String cin, LocalDate added_date);

    void updatePatient(String firstName, String lastName, String cin, LocalDate addedDate);

    void deletePatient(String cin);

    int patientsCount();


}
