package com.example.hospitalmanagementsystem.model;

import java.sql.Date;

public class Appointment {
    int pat_id, doc_id;
    String pat_name, doc_name;
    Date date;

    public Appointment() {}
    public Appointment(int pat_id,String pat_name,  int doc_id, String doc_name, Date date) {
        this.pat_id = pat_id;
        this.doc_id = doc_id;
        this.pat_name = pat_name;
        this.doc_name = doc_name;
        this.date = date;
    }

    public void setPat_id(int pat_id) {
        this.pat_id = pat_id;
    }

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public void setPat_name(String pat_name) {
        this.pat_name = pat_name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public int getPat_id() {
        return pat_id;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public String getPat_name() {
        return pat_name;
    }

    public Date getDate() {
        return date;
    }
}

