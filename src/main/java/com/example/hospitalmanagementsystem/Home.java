package com.example.hospitalmanagementsystem;

import com.example.hospitalmanagementsystem.database.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private Button btn_appoint;

    @FXML
    private Button btn_doctors;

    @FXML
    private Button btn_patients;

    @FXML
    private Button btn_logout;

    private FXMLLoader root;

    private Stage stage;

    @FXML
    private Label label_count_apt;

    @FXML
    private Label label_count_doctor;

    @FXML
    private Label label_count_patient;

    @FXML
    void displayAppointments(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("appointments.fxml"));
        stage = (Stage) (btn_patients.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void displayDoctors(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("doctors.fxml"));
        stage = (Stage) (btn_logout.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void displayPatients(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("patients.fxml"));
        stage = (Stage) (btn_logout.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void onLogout(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        stage = (Stage) (btn_logout.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label_count_patient.setText(String.valueOf(DB.getCountPatient()));
        label_count_doctor.setText(String.valueOf(DB.getCountDoctor()));
        label_count_apt.setText(String.valueOf(DB.getCountAppointment()));
    }
}
