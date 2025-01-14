package com.example.projectovapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
import java.util.ResourceBundle;

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

    private ResourceBundle bundle;

    @FXML
    public void initialize() {
        bundle = LanguageManager.getBundle();
    }

    @FXML
    private void onLoginButtonClick(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText(bundle.getString("status.empty_fields"));
            return;
        }

        if (validateLogin(username, password)) {
            statusLabel.setText(bundle.getString("login.status.success"));
            openDashboard(event);
        } else {
            statusLabel.setText(bundle.getString("login.status.invalid"));
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
            statusLabel.setText(bundle.getString("error.file_not_found"));
        }
        return false; // Geen match gevonden
    }

    private void openDashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(ApplicationOpen.class.getResource("route.fxml"));
            loader.setResources(LanguageManager.getBundle());
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText(bundle.getString("error.scene_load"));
        }
    }

    @FXML
    private void onBackButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(ApplicationOpen.class.getResource("open.fxml"));
            loader.setResources(LanguageManager.getBundle());
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1280, 720));
            stage.show();

            // Vangt fouten op om te voorkomen dat de applicatie crasht
        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText(bundle.getString("error.scene_back"));
        }
    }
}