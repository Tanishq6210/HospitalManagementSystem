package com.example.hospitalmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class AddAppointment {
    private FXMLLoader root;

    private Stage stage;

    @FXML
    private Button btn_back;

    @FXML
    private ComboBox<?> cb_doctor;

    @FXML
    private ComboBox<?> cb_patient;

    @FXML
    private DatePicker dp_date;

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

    }
}
