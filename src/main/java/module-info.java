/**
 *
 */
module com.example.hospitalmanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.hospitalmanagementsystem to javafx.fxml;
    exports com.example.hospitalmanagementsystem;
    exports com.example.hospitalmanagementsystem.model;
    opens com.example.hospitalmanagementsystem.model to javafx.fxml;
}