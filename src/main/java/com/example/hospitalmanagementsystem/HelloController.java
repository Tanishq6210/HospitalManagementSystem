package com.example.hospitalmanagementsystem;

import com.example.hospitalmanagementsystem.database.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import java.io.IOException;

//I am blo the pp who loves bloi bloi
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
        String user = tf_username.getText();
        String pwd = tf_pwd.getText();

        if(user.isEmpty() || pwd.isEmpty()) {
            showMessage("Required Fields are empty", Alert.AlertType.ERROR);
        } else {
            if(DB.isUser(user, pwd)) {
                showMessage("User Logged in", Alert.AlertType.NONE);
                root = new FXMLLoader(getClass().getResource("home.fxml"));
                stage = (Stage) (btn_login.getScene().getWindow());
                try {
                    stage.setScene(new Scene(root.load()));
                } catch (IOException e) {
                    System.out.println(e);
                }
            } else {
                showMessage("Invalid Credentials", Alert.AlertType.NONE);
            }
        }
    }

    @FXML
    void onRegister(ActionEvent event) {
        if(tf_pwd.getText().length() < 6) {
            showMessage("Password should be of more than 6 characters!", Alert.AlertType.ERROR);
        } else {
            DB.register(tf_username.getText(), tf_pwd.getText());
            root = new FXMLLoader(getClass().getResource("home.fxml"));
            stage = (Stage) (btn_login.getScene().getWindow());
            try {
                stage.setScene(new Scene(root.load()));
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    @FXML
    void onExit(ActionEvent event) {
        System.exit(0);
    }

    private void showMessage(String content, Alert.AlertType type) {
        Alert alert = new Alert(type, content, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }
}