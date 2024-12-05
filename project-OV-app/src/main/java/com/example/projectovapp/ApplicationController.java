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
    public void onRoutePlannerButtonClick(ActionEvent event) throws IOException
    {
        testText.setText("Welcome to JavaFX Application!");
        ApplicationOpen.ChangeScene((Stage)testText.getScene().getWindow());
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("route.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("route planner");
        stage.show();

         */
    }

    //route.fxml
    @FXML
    public void onRouteInfoButtonClick(ActionEvent event) throws IOException
    {
        testText.setText("Welcome to JavaFX Application!");
        ApplicationOpen.ChangeScene2((Stage)testText.getScene().getWindow());
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("routeinfo.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Route Informatie");
        stage.show();

         */
    }
}