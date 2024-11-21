package com.example.projectovapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ApplicationController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welkom bij OVerzichtelijk!");
    }
}