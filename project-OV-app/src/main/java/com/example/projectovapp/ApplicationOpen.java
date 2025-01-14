package com.example.projectovapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Locale;

import java.io.IOException;

public class ApplicationOpen extends Application {

    public static Scene scene1, scene2, scene3, loginScene, registrationScene;

    public static Scene loadScene(String fxmlPath, double width, double height) throws IOException {
        FXMLLoader loader = new FXMLLoader(ApplicationOpen.class.getResource(fxmlPath));
        loader.setResources(LanguageManager.getBundle());
        return new Scene(loader.load(), width, height);
    }

    @Override
    public void start(Stage stage) throws IOException {
        LanguageManager.setLocale(Locale.of("nl"));

        scene1 = loadScene("open.fxml", 1280, 720);
        scene2 = loadScene("route.fxml", 1280, 720);
        scene3 = loadScene("routeinfo.fxml", 1280, 720);
        loginScene = loadScene("login.fxml", 1280, 720);
        registrationScene = loadScene("registration.fxml", 1280, 720);

        stage.setTitle("OVerzichtelijk");
        stage.setScene(scene1);
        stage.show();
    }

    private static void reloadScene(Scene scene, String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(ApplicationOpen.class.getResource(fxmlPath));
        loader.setResources(LanguageManager.getBundle());
        scene.setRoot(loader.load());
    }

    public static void changeLanguage(Locale locale, Stage stage) throws IOException {
        LanguageManager.setLocale(locale);

        reloadScene(scene1, "open.fxml");
        reloadScene(scene2, "route.fxml");
        reloadScene(scene3, "routeinfo.fxml");
        reloadScene(loginScene, "login.fxml");
        reloadScene(registrationScene, "registration.fxml");

        stage.setScene(scene1);
        stage.setTitle("OVerzichtelijk");
        stage.show();
    }

    public static void ChangeScene(Stage stage){
        stage.setScene(scene2);
    }

    public static void ChangeScene2(Stage stage){
        stage.setScene(scene3);
    }

    public static void ChangeToLoginPage(Stage stage) {
        stage.setScene(loginScene);
    }

    public static void ChangeToRegistrationPage(Stage stage) {
        stage.setScene(registrationScene);
    }
    public static void main(String[] args) {
        launch();
    }
}