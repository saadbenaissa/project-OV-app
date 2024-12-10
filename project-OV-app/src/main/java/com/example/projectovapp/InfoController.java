package com.example.projectovapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InfoController {

    @FXML
    private Label beginStationLabel;

    @FXML
    private Label endStationLabel;

    @FXML
    private Button backButton;  // Terug knop

    public void initialize() {
        beginStationLabel.setText("Amsterdam Centraal");
        endStationLabel.setText("Utrecht Centraal");
    }

    @FXML
    // Als je op de terugknop klikt ga je naar open.fxml

    private void onBackButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projectovapp/open.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            // Vangt fouten op om te voorkomen dat de applicatie crasht
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
