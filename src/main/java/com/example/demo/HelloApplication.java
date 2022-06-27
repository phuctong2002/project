package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    public static String name = "";
    public static String email = "";
    public static Stage window = null;
    public static Scene scene = null;
    public static FXMLLoader fxmlLoader = null;
    @Override
    public void start(Stage stage) throws IOException {
        HelloApplication.window = stage;
        HelloApplication.fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        HelloApplication.scene = new Scene(fxmlLoader.load());
//        HelloApplication.window.setMaximized( true);
        HelloApplication.window.setTitle("Hello!");
        HelloApplication.window.setScene(scene);
        HelloApplication.window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}