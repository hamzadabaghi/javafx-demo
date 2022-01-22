package com.javafx.doctors_office.models;

import java.time.LocalDate;

public class Patient {

    private Long id_file;
    private String first_name;
    private String last_name;
    private String CIN;
    private LocalDate added_date;

    public Patient() {
    }

    public Patient(Long id_file, String first_name, String last_name, String CIN, LocalDate added_date) {
        this.id_file = id_file;
        this.first_name = first_name;
        this.last_name = last_name;
        this.CIN = CIN;
        this.added_date = added_date;
    }

    public Long getId_file() {
        return id_file;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCIN() {
        return CIN;
    }

    public LocalDate getAdded_date() {
        return added_date;
    }

    public void setId_file(Long id_file) {
        this.id_file = id_file;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public void setAdded_date(LocalDate added_date) {
        this.added_date = added_date;
    }
}
