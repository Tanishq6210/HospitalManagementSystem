package com.example.hospitalmanagementsystem;

import com.example.hospitalmanagementsystem.database.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class AddPatient {
    private FXMLLoader root;

    private Stage stage;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_update;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton rb_female;

    @FXML
    private RadioButton rb_male;

    @FXML
    private TextField tf_address;

    @FXML
    private TextField tf_firstname;

    @FXML
    private TextField tf_lastname;

    @FXML
    private TextField tf_phone;

    @FXML
    private TextField tf_id;

    @FXML
    void addPatient(ActionEvent event) {
        int id = Integer.parseInt(tf_id.getText());
        String fname = tf_firstname.getText();
        String lname = tf_lastname.getText();
        String phone = tf_phone.getText();
        String add = tf_address.getText();
        String gender;
        if(rb_female.isSelected()) gender = "FEMALE";
        else gender = "MALE";

        DB.insertPatient(id, fname, lname, gender, phone, add);
        tf_id.setText("");
        tf_firstname.setText("");
        tf_lastname.setText("");
        tf_phone.setText("");
        tf_address.setText("");
        rb_male.setSelected(false);
        rb_female.setSelected(false);
    }

    @FXML
    void deletePatient(ActionEvent event) {

    }

    @FXML
    void onBack(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("patients.fxml"));
        stage = (Stage) (btn_back.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void updatePatient(ActionEvent event) {

    }
}
