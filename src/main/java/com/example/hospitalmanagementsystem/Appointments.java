package com.example.hospitalmanagementsystem;

import com.example.hospitalmanagementsystem.database.DB;
import com.example.hospitalmanagementsystem.model.Appointment;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class Appointments implements Initializable {
    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    @FXML
    private Button btn_back;

    @FXML
    private TableView<Appointment> table_appointment;

    @FXML
    private TableColumn<Appointment, Date> col_date;

    @FXML
    private TableColumn<Appointment, Integer> col_doc_id;

    @FXML
    private TableColumn<Appointment, String> col_doc_name;

    @FXML
    private TableColumn<Appointment, Integer> col_pat_id;

    @FXML
    private TableColumn<Appointment, String> col_pat_name;

    @FXML
    private TextField tf_search_text;

    @FXML
    void bookAppointment(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("add_appointment.fxml"));
        stage = (Stage) (btn_back.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void onBack(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("home.fxml"));
        stage = (Stage) (btn_back.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        col_pat_id.setCellValueFactory(new PropertyValueFactory<>("pat_id"));
        col_pat_name.setCellValueFactory(new PropertyValueFactory<>("pat_name"));
        col_doc_id.setCellValueFactory(new PropertyValueFactory<>("doc_id"));
        col_doc_name.setCellValueFactory(new PropertyValueFactory<>("doc_name"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        ObservableList items = DB.getAppointments();
        table_appointment.setItems(items);
    }

    public void searchAppointment(KeyEvent keyEvent) {
        table_appointment.getItems().clear();
        if(tf_search_text.getText().isBlank()) {
            ObservableList items = DB.getAppointments();
            table_appointment.setItems(items);
        } else {
            ObservableList<Appointment> items = DB.searchInAppointment(tf_search_text.getText());
            table_appointment.setItems(items);
        }
    }
}
