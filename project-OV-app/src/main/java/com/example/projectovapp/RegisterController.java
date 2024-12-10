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

public class RegisterController {

    @FXML
    private TextField mailField;

    @FXML
    private TextField fullnameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label statusLabel; // tekst boven aan (bijv. registratie gelukt)

    @FXML
    private Button registerButton; //registreer knop

    @FXML
    private Button backButton;  // Terug knop

    // Registratie
    @FXML
    private void onRegistrationButtonClick() {
        String fullname = fullnameField.getText();
        String mail     = mailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (fullname.isEmpty() || mail.isEmpty() || username.isEmpty() || password.isEmpty()) {
            statusLabel.setText("Vul alle velden in.");
        } else {
            statusLabel.setText("Registratie succesvol!");
            saveRegistrationData(fullname, mail, username, password);
        }
    }

    // Methode die de gebruikersnaam en het wachtwoord opslaat in LocalOpslag.txt
    private void saveRegistrationData(String fullname, String mail, String username, String password) {
        File file = new File("data/LocalOpslag.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

            writer.newLine();
            writer.write("Volledige naam: " + fullname);
            writer.newLine();
            writer.write("E-mail: " + mail);
            writer.newLine();
            writer.write("Gebruikersnaam: " + username);
            writer.newLine();
            writer.write("Wachtwoord: " + password);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
            statusLabel.setText("Er is een fout opgetreden bij het opslaan van de gegevens.");
        }
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
