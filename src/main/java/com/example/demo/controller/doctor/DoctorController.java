package com.example.demo.controller.doctor;

import com.example.demo.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class DoctorController {
    private AnchorPane view;
    private Pane view2;
    @FXML
    public BorderPane borderPane;
    @FXML
    public void dangxuat(ActionEvent event) throws IOException {
        HelloApplication.fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        HelloApplication.scene = new Scene(HelloApplication.fxmlLoader.load());
        HelloApplication.window.setTitle("Hello!");
        HelloApplication.window.setScene(HelloApplication.scene);
        HelloApplication.window.show();
    }
    @FXML
    public void lichtiem(ActionEvent event)  {
        view = getPane("Doc/view_schedule.fxml");
        borderPane.setCenter( view);
    }
    @FXML
    public void nhapthongtintiemchung(ActionEvent event) {
        view = getPane("Doc/import_vaccination_inf.fxml");
        borderPane.setCenter( view);
    }
    @FXML
    public void thongtinbs(ActionEvent event){
        view2 = getPane2("Doc/edit_information_doctor.fxml");
        borderPane.setCenter( view2);
    }
    @FXML
    public void change_passw(ActionEvent event) {
        view = getPane("Doc/change_pass_doc.fxml");
        borderPane.setCenter( view);
    }
    private AnchorPane getPane(String name){
        AnchorPane a = null;
        try{
            a = new FXMLLoader(HelloApplication.class.getResource( name)).load();
        } catch(Exception e){
            System.out.println("Error in getPane method userpagecontroler" + e.getMessage());
        }
        return a;
    }
    private Pane getPane2(String name){
        Pane a = null;
        try{
            a = new FXMLLoader(HelloApplication.class.getResource( name)).load();
        } catch(Exception e){
            System.out.println("Error in getPane method userpagecontroler" + e.getMessage());
        }
        return a;
    }
}
