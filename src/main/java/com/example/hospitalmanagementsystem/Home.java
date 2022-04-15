package com.example.hospitalmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {
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

    private Scene scene;

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

}
