package com.example.projectovapp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    // Als je op de terugknop klikt ga je naar open.fxml, oftewel de hoofdpagina.
    // Met een try catch vangt het eventuele errors op en behandelt deze.
    private void onBackButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projectovapp/open.fxml"));
            Parent root = loader.load();

            // Set the new scene
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

            //Als er een error ontstaat kun je een aangepaste melding weergeven aan de gebruiker.
        } catch (IOException e) {
            e.printStackTrace();
            showErrorDialog("An error occurred while loading the page. Please try again.");
        }
    }

    // Dialog box initialiseren die later wordt gebruikt om errors weer te geven, mochten deze plaatsvinden.
    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
