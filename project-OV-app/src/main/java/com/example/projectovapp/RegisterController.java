package com.example.projectovapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class RegisterController {

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    private Button registerButton;

    // Methode die wordt aangeroepen bij het klikken op de registratieknop
    @FXML
    private void onRegistrationButtonClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Voeg je registratie logica hier toe
        if (username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Vul alle velden in.");
        } else {
            statusLabel.setText("Registratie succesvol!");
            // Verwerk de gegevens (bijvoorbeeld opslaan in een database)
        }
    }
}
