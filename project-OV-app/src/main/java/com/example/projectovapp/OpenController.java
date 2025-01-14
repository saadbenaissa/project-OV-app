package com.example.projectovapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import java.util.Locale;

import java.io.IOException;

public class OpenController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private VBox rootPane;

    @FXML
    private Label testText;

    //open.fxml
    @FXML
    public void onRoutePlannerButtonClick(ActionEvent event) throws IOException {
        ApplicationOpen.ChangeScene((Stage) testText.getScene().getWindow());
    }

    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        // Verander naar de registratiepagina
        ApplicationOpen.ChangeToLoginPage((Stage)testText.getScene().getWindow());
    }

    @FXML
    public void onRegisterButtonClick(ActionEvent event) throws IOException {
        // Verander naar de registratiepagina
        ApplicationOpen.ChangeToRegistrationPage((Stage)testText.getScene().getWindow());
    }

    @FXML
    private void handleDutchButtonClick() throws IOException {
        ApplicationOpen.changeLanguage(Locale.of("nl"),(Stage)rootPane.getScene().getWindow());
    }

    @FXML
    private void handleEnglishButtonClick() throws IOException {
        ApplicationOpen.changeLanguage(Locale.of("en"),(Stage)rootPane.getScene().getWindow());
    }
}