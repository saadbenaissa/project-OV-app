package com.example.projectovapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InfoController {

    public ImageView routeImage;
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
    private void onBackButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(ApplicationOpen.class.getResource("route.fxml"));
            loader.setResources(LanguageManager.getBundle());
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();

            // Vangt fouten op om te voorkomen dat de applicatie crasht
        } catch (IOException e) {
            e.printStackTrace();
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
