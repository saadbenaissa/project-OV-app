package com.example.projectovapp;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PlannerController {

    @FXML
    private ComboBox<String> beginComboBox;

    @FXML
    private ComboBox<String> endComboBox;

    @FXML
    private Label testText;

    @FXML
    public void initialize() {
        // Voeg items toe aan de beginComboBox
        beginComboBox.setItems(FXCollections.observableArrayList(
                "Rotterdam", "Zoetermeer", "Utrecht Centraal", "Groningen Centraal", "Maastricht Centraal"
        ));

        // Voeg items toe aan de endComboBox
        endComboBox.setItems(FXCollections.observableArrayList(
                "Den Haag", "Dordrecht", "Amersfoort Centraal", "Leeuwarden Centraal", "Breda Centraal"
        ));
    }

    @FXML
    private void onRouteInfoButtonClick() {
        // Haal geselecteerde waarden op
        String start = beginComboBox.getValue();
        String end = endComboBox.getValue();

        // Toon route-informatie in het label
        if (start != null && end != null) {
            testText.setText("Route van " + start + " naar " + end);
        } else {
            testText.setText("Selecteer een begin- en eindpunt.");
        }
    }
}