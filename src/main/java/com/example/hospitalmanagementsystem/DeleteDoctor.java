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
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeleteDoctor implements Initializable {

    private FXMLLoader root;

    private Stage stage;

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_get_doctor;

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

    @FXML    private TextField tf_phone;

    @FXML
    private ComboBox<Integer> cb_doctors;

    ObservableList<Integer> dlist = FXCollections.observableArrayList();

    @FXML
    void onBack(ActionEvent event) {
        root = new FXMLLoader(getClass().getResource("doctors.fxml"));
        stage = (Stage) (btn_back.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void onGetDoctor(ActionEvent event) {
        int id = cb_doctors.getValue();
        Doctor doctor = DB.getDoctor(id);
        tf_firstname.setText(doctor.getFirstName());
        tf_lastname.setText(doctor.getLastName());
        tf_address.setText(doctor.getAddress());
        tf_phone.setText(doctor.getPhone_no());

        if(doctor.getGender().equals("MALE")) rb_male.setSelected(true);
        else rb_female.setSelected(true);
    }
    

    public void deleteDoctor(ActionEvent actionEvent) {
        int id = cb_doctors.getValue();
        DB.deleteDoctor(id);
    }

    public void updateDoctor(ActionEvent actionEvent) {
        int id = cb_doctors.getValue();
        String fname = tf_firstname.getText();
        String lname = tf_lastname.getText();
        String phone = tf_phone.getText();
        String add = tf_address.getText();
        String gender;
        if(rb_female.isSelected()) gender = "FEMALE";
        else gender = "MALE";
        Doctor doctor = new Doctor(id, fname, lname, gender, phone, add);
        DB.updateDoctor(doctor);
        cb_doctors.getSelectionModel().select(0);
        tf_firstname.setText("");
        tf_lastname.setText("");
        tf_phone.setText("");
        tf_address.setText("");
        rb_male.setSelected(false);
        rb_female.setSelected(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int n = DB.getCountDoctor();

        ObservableList doctors = DB.getDoctors();
        for(int i=0; i<n; i++) {
            Doctor d = (Doctor) doctors.get(i);
            dlist.add(d.getId());
        }

        cb_doctors.setItems(dlist);
    }
}
