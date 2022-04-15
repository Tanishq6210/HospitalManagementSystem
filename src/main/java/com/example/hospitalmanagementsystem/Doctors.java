package com.example.hospitalmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Doctors {
    private FXMLLoader root;

    private Stage stage;

    private Scene scene;

    @FXML
    private Button btn_back;

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
}
