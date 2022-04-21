package com.example.hospitalmanagementsystem;

import com.example.hospitalmanagementsystem.database.DB;
import com.example.hospitalmanagementsystem.model.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeletePatient implements Initializable {
    private FXMLLoader root;

    private Stage stage;

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
    private ComboBox<Integer> cb_patients;

    ObservableList<Integer> plist = FXCollections.observableArrayList();

    @FXML
    void getPatient(ActionEvent event) {
        int id = cb_patients.getValue();
        Patient patient = DB.getPatient(id);
        tf_firstname.setText(patient.getFirstName());
        tf_lastname.setText(patient.getLastName());
        tf_address.setText(patient.getAddress());
        tf_phone.setText(patient.getPhone_no());

        if(patient.getGender().equals("MALE")) rb_male.setSelected(true);
        else rb_female.setSelected(true);
    }

    @FXML
    void deletePatient(ActionEvent event) {
        int id = cb_patients.getValue();
        DB.deletePatient(id);
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
        int id = cb_patients.getValue();
        String fname = tf_firstname.getText();
        String lname = tf_lastname.getText();
        String phone = tf_phone.getText();
        String add = tf_address.getText();
        String gender;
        if(rb_female.isSelected()) gender = "FEMALE";
        else gender = "MALE";
        Patient patient = new Patient(id, fname, lname, gender, phone, add);
        DB.updatePatient(patient);
        cb_patients.getSelectionModel().select(0);
        tf_firstname.setText("");
        tf_lastname.setText("");
        tf_phone.setText("");
        tf_address.setText("");
        rb_male.setSelected(false);
        rb_female.setSelected(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int n = DB.getCountPatient();


        ObservableList patients = DB.getPatients();
        for(int i=0; i<n; i++) {
            Patient p = (Patient)patients.get(i);
            plist.add(p.getId());
        }

        cb_patients.setItems(plist);
    }
}
