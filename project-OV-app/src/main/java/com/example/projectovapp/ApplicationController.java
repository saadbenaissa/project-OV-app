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

    private Label welcomeText;

    @FXML
    public void onRoutePlannerButtonClick(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("route.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("route planner");
        stage.show();
    }
}