package com.example.projectovapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Button backButton;

    @FXML
    private void onLoginButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Vul alle velden in.");
            return;
        }

        if (validateLogin(username, password)) {
            statusLabel.setText("Inloggen succesvol!");
            openDashboard();
        } else {
            statusLabel.setText("Ongeldige inloggegevens.");
        }
    }

    private boolean validateLogin(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("project-OV-app/data/LocalOpslag.txt"))) {
            String line;
            String storedUsername = null;
            String storedPassword = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Verwijder onnodige spaties

                if (line.startsWith("Gebruikersnaam:")) {
                    storedUsername = line.split(":", 2)[1].trim(); // Haal waarde na de dubbele punt
                } else if (line.startsWith("Wachtwoord:")) {
                    storedPassword = line.split(":", 2)[1].trim(); // Haal waarde na de dubbele punt
                }

                // Als beide waarden gevonden zijn, vergelijk ze met input
                if (storedUsername != null && storedPassword != null) {
                    if (storedUsername.equals(username) && storedPassword.equals(password)) {
                        return true; // Inloggegevens kloppen
                    }
                    // Reset variabelen voor volgende gebruiker
                    storedUsername = null;
                    storedPassword = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Er is een fout opgetreden bij het lezen van de gegevens.");
        }
        return false; // Geen match gevonden
    }

    private void openDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projectovapp/route.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) loginButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Er is een fout opgetreden bij het openen van het dashboard.");
        }
    }

    @FXML
    private void onBackButtonClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/projectovapp/open.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) backButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}