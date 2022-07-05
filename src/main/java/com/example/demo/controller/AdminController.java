package com.example.demo.controller;

import com.example.demo.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    private Pane view;
    @FXML
    public Label nameAdmin;
    @FXML
    public BorderPane borderPaneAdmin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameAdmin.setText(HelloApplication.name);



        view = getPane( "admin/statistic.fxml");

        borderPaneAdmin.setCenter( view);
    }

    @FXML
    public void admin1(){
        view = getPane( "admin/statistic.fxml");

        borderPaneAdmin.setCenter( view);
    }
    @FXML
    public void admin2(){
        view = getPane( "admin/add.fxml");

        borderPaneAdmin.setCenter( view);
    }
    @FXML
    public void admin3(){

        view = getPane( "admin/listPatient.fxml");

        borderPaneAdmin.setCenter( view);


    }
    @FXML
    public void admin4() throws IOException {
        HelloApplication.fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        HelloApplication.scene = new Scene(HelloApplication.fxmlLoader.load());
//        HelloApplication.window.setMaximized( true);
        HelloApplication.window.setTitle("Hello!");
        HelloApplication.window.setScene(HelloApplication.scene);
        HelloApplication.window.show();

    }
    private Pane getPane(String name){
        Pane a = null;
        try{
            a = new FXMLLoader(HelloApplication.class.getResource( name)).load();
        } catch(Exception e){
            System.out.println("Error in getPane method admincontroler" + e.getMessage());
        }
        return a;
    }
}
