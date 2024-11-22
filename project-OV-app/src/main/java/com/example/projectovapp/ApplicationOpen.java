package com.example.projectovapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplicationOpen extends Application {

    public static Scene scene1, scene2, scene3;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationOpen.class.getResource("open.fxml"));
        scene1 = new Scene(fxmlLoader.load(), 320, 240);
        scene2 = new Scene(fxmlLoader.load(ApplicationOpen.class.getResource("route.fxml")), 320, 240);
        scene3 = new Scene(fxmlLoader.load(ApplicationOpen.class.getResource("routeinfo.fxml")), 320, 240);


        stage.setTitle("Hello!");
        stage.setScene(scene1);
        stage.show();
    }

    public static void ChangeScene(Stage stage){
        stage.setScene(scene2);
    }

    public static void ChangeScene2(Stage stage){
        stage.setScene(scene3);
    }

    public static void main(String[] args) {
        launch();
    }
}