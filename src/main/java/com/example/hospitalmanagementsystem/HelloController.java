package com.example.hospitalmanagementsystem;

import com.example.hospitalmanagementsystem.database.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Button btn_login;

    @FXML
    private Button btn_register;

    @FXML
    private TextField tf_pwd;

    @FXML
    private TextField tf_username;

    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    @FXML
    void onLogin(ActionEvent event) {

    }

    @FXML
    void onRegister(ActionEvent event) {
        DB.register();
        root = new FXMLLoader(getClass().getResource("home.fxml"));
        stage = (Stage) (btn_login.getScene().getWindow());
        try {
            stage.setScene(new Scene(root.load()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void onExit(ActionEvent event) {
        System.exit(0);
    }
}