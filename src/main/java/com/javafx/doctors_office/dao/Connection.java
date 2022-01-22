package com.javafx.doctors_office.dao;

import com.javafx.doctors_office.models.Admin;
import com.javafx.doctors_office.models.Patient;

import java.util.List;

public interface Connection {

    List<Patient> getPatients();

    List<Admin> getAdmins();

    Patient getPatient(String CIN);

    Patient savePatient(Patient p);

    Patient updatePatient(Patient p);

    Patient deletePatient(Patient p);


}
