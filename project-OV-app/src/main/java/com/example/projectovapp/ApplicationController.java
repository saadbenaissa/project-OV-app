package com.example.projectovapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;


import java.io.IOException;

public class ApplicationController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label testText;

    //open.fxml
    @FXML
    public void onRoutePlannerButtonClick(ActionEvent event) throws IOException {
        testText.setText("Welcome to JavaFX Application!");
        ApplicationOpen.ChangeScene((Stage) testText.getScene().getWindow());
    }

    //route.fxml
    @FXML
    public void onRouteInfoButtonClick(ActionEvent event) throws IOException {
        testText.setText("Welcome to JavaFX Application!");
        ApplicationOpen.ChangeScene2((Stage) testText.getScene().getWindow());
    }

    // Login knop
    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        // Verander naar de registratiepagina
        ApplicationOpen.ChangeToLoginPage((Stage)testText.getScene().getWindow());
    }

    // Registatie knop
    @FXML
    public void onRegisterButtonClick(ActionEvent event) throws IOException {
        // Verander naar de registratiepagina
        ApplicationOpen.ChangeToRegistrationPage((Stage)testText.getScene().getWindow());
    }

//    @FXML
//    private Label beginStationLabel;

//    @FXML
//    private Label endStationLabel;

//    public void initialize() {
//        beginStationLabel.setText("Amsterdam Centraal");
//        endStationLabel.setText("Utrecht Centraal");
//    }
}