package com.example.hospitalmanagementsystem;

import com.example.hospitalmanagementsystem.database.DB;
import com.example.hospitalmanagementsystem.model.Doctor;
import com.example.hospitalmanagementsystem.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddAppointment implements Initializable {
    private FXMLLoader root;

    private Stage stage;

    @FXML
    private Button btn_back;

    @FXML
    private ComboBox<Integer> cb_doctor;

    @FXML
    private ComboBox<Integer> cb_patient;

    @FXML
    private DatePicker dp_date;

    ObservableList<Integer> plist = FXCollections.observableArrayList();
    ObservableList<Integer> dlist = FXCollections.observableArrayList();

    @FXML
    void onBack(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("appointments.fxml"));
        stage = (Stage) (btn_back.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void onBookAppointment(ActionEvent event) {

        int pat_id = cb_patient.getValue();
        int doc_id = cb_doctor.getValue();
        Date date = Date.valueOf(dp_date.getValue());
        DB.bookAppointment(pat_id, doc_id, date);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int n = DB.getCountPatient();
        ObservableList patients = DB.getPatients();
        for(int i=0; i<n; i++) {
            Patient p = (Patient)patients.get(i);
            plist.add(p.getId());
        }

        cb_patient.setItems(plist);

        n = DB.getCountDoctor();

        ObservableList doctors = DB.getDoctors();
        for(int i=0; i<n; i++) {
            Doctor d = (Doctor) doctors.get(i);
            dlist.add(d.getId());
        }

        cb_doctor.setItems(dlist);
    }
}
