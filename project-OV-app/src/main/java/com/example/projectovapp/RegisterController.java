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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

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

    private ResourceBundle bundle;

    @FXML
    public void initialize() {
        bundle = LanguageManager.getBundle();
    }

    // Registratie
    @FXML
    private void onRegistrationButtonClick() {
        String fullname = fullnameField.getText();
        String mail     = mailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (fullname.isEmpty() || mail.isEmpty() || username.isEmpty() || password.isEmpty()) {
            statusLabel.setText(bundle.getString("status.empty_fields"));
        } else {
            statusLabel.setText(bundle.getString("registration.status.success"));
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
            statusLabel.setText(bundle.getString("error.save_userdata"));
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
