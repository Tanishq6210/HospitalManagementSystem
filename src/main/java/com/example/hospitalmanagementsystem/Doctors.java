package com.example.hospitalmanagementsystem;

import com.example.hospitalmanagementsystem.database.DB;
import com.example.hospitalmanagementsystem.model.Doctor;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Doctors implements Initializable {
    private FXMLLoader root;

    private Stage stage;

    @FXML
    private TableColumn<Doctor, String> col_add;

    @FXML
    private TableColumn<Doctor, String> col_first_name;

    @FXML
    private TableColumn<Doctor, String> col_gender;

    @FXML
    private TableColumn<Doctor, Integer> col_id;

    @FXML
    private TableColumn<Doctor, String> col_last_name;

    @FXML
    private TableColumn<Doctor, String> col_phone;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_update;

    @FXML
    private TableView<Doctor> table_doctor;

    @FXML
    private TextField tf_search;

    @FXML
    void addDoctor(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("add_doctor.fxml"));
        stage = (Stage) (btn_back.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void updateDoctor(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("delete_doctor.fxml"));
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
        col_first_name.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        col_last_name.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_phone.setCellValueFactory(new PropertyValueFactory<>("phone_no"));
        col_add.setCellValueFactory(new PropertyValueFactory<>("address"));

        ObservableList items = DB.getDoctors();
        table_doctor.setItems(items);
    }

    public void onSearchedText(KeyEvent keyEvent) {
        System.out.println(tf_search.getText());
        table_doctor.getItems().clear();

        if(tf_search.getText().equals("")) {
            ObservableList items = DB.getDoctors();
            table_doctor.setItems(items);
        } else {
            ObservableList items = DB.searchInDoctor(tf_search.getText());
            table_doctor.setItems(items);
        }

    }
}
