package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.utils.DB;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserPageController implements Initializable {
    private Pane view;
    @FXML
    public Label name;
    @FXML
    public BorderPane content;


    // certification









    @Override
    public void initialize( URL url, ResourceBundle rb){
        name.setText( HelloApplication.name);
//        nameCertification.setText(HelloApplication.name);
        //dobCertification.setText( HelloApplication.dob);
        //idCertification.setText(HelloApplication.id);

        view = getPane("certification2.fxml");
        content.setCenter( view);
    }

    @FXML
    public void logoutBtn() throws IOException {
        HelloApplication.fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        HelloApplication.scene = new Scene(HelloApplication.fxmlLoader.load());
//        HelloApplication.window.setMaximized( true);
        HelloApplication.window.setTitle("Hello!");
        HelloApplication.window.setScene(HelloApplication.scene);
        HelloApplication.window.show();
    }

    @FXML
    public void handle1(){
        view = getPane("certification2.fxml");
        content.setCenter( view);
    }

    @FXML
    public void handle2(){
        view = getPane("declare.fxml");
        content.setCenter( view);
    }
    @FXML
    public void handle3(){
        view = getPane("registerInject.fxml");
        content.setCenter( view);
    }
    @FXML
    public void handle4(){
        // dk tiem chung nhe
    }
    @FXML
    public void handle5(){
        view = getPane("infor.fxml");
        content.setCenter( view);
    }

    private Pane getPane(String name){
        Pane a = null;
        try{
            a = new FXMLLoader(HelloApplication.class.getResource( name)).load();
        } catch(Exception e){
            System.out.println("Error in getPane method userpagecontroler" + e.getMessage());
        }
        return a;
    }
}
