package com.example.projectovapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationOpen extends Application {

    public static Scene scene1, scene2, scene3, registrationScene;


    @Override
    public void start(Stage stage) throws IOException {
        // Laad 'open.fxml'
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationOpen.class.getResource("open.fxml"));
        scene1 = new Scene(fxmlLoader.load());

        // Laad 'route.fxml'
        FXMLLoader loader2 = new FXMLLoader(ApplicationOpen.class.getResource("route.fxml"));
        scene2 = new Scene(loader2.load(), 1920, 1080);

        // Laad 'routeinfo.fxml'
        FXMLLoader loader3 = new FXMLLoader(ApplicationOpen.class.getResource("routeinfo.fxml"));
        scene3 = new Scene(loader3.load(), 320, 240);

        // Laad 'registration.fxml' voor de registratiepagina
        FXMLLoader registrationLoader = new FXMLLoader(ApplicationOpen.class.getResource("registration.fxml"));
        registrationScene = new Scene(registrationLoader.load(), 600, 400);

        stage.setTitle("OVerzichtelijk");
        stage.setScene(scene1);
        stage.show();
        stage.setFullScreen(true);
    }

    public static void ChangeScene(Stage stage){
        stage.setScene(scene2);
        stage.setFullScreen(true);
    }

    public static void ChangeScene2(Stage stage){
        stage.setScene(scene3);
        stage.setFullScreen(true);
    }

    public static void ChangeToRegistrationPage(Stage stage) {
        stage.setScene(registrationScene);
        stage.setFullScreen(false);
    }
    public static void main(String[] args) {
        launch();
    }
}