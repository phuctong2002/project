package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.utils.DB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HistoryRegisterController implements Initializable {

    @FXML
    public Pane mainContainer;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        ResultSet register = null;
        String query = "select * from injection_registration_form where pat_id='"+ HelloApplication.id + "' order by injection_time;";
        try {
            register = DB.dbExecuteQuery(query);
            while( register.next()){
                Pane a = getPage( register.getString("injection_time"));
                mainContainer.getChildren().add(a);
//                mainContainer.setMargin( a, new Insets( 0,0,10,0));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private Pane getPage(String dateRegister){
        Pane a = new Pane();
        Pane b = new Pane();
        Pane c = new Pane();
        a.getChildren().addAll(b, c);
//        thanh phan cua b truoc nhe
        Label timeRegister = new Label(dateRegister);
        b.getChildren().add( timeRegister);
        timeRegister.setPrefSize(140, 130);
        b.setPrefSize(150, 150);
        timeRegister.setTranslateX(10);
        timeRegister.setTranslateY(10);
        timeRegister.setStyle("-fx-background-radius: 12; -fx-background-color: rgb(134, 143, 218);");
        timeRegister.setFont( new Font(24));
        timeRegister.setAlignment(Pos.CENTER);
        b.setTranslateX(0);
        b.setTranslateY(0);
        // set c nhe anh em
        c.setTranslateX(150);
        c.setTranslateY(0);
        c.setPrefSize(350, 150);
        // ba label nhe
        Label name = new Label(HelloApplication.name);
        name.setPadding( new Insets(0, 0, 0, 30));
        name.setFont(new Font(16));
        Label dob = new Label(HelloApplication.dob);
        dob.setPadding( new Insets(0, 0, 0, 30));
        dob.setFont(new Font(16));
        Label ss = new Label("Dang ki thanh cong");
        ss.setPadding( new Insets(0, 0, 0, 30));
        ss.setFont(new Font(16));
        name.setPrefSize(305, 50);
        dob.setPrefSize(305, 50);
        ss.setPrefSize(305, 50);
        c.getChildren().addAll( name, dob, ss);
        name.setTranslateX(0);
        name.setTranslateY(0);
        dob.setTranslateX(0);
        dob.setTranslateY(50);
        ss.setTranslateX(0);
        ss.setTranslateY(100);
        a.setStyle("-fx-background-radius: 12; -fx-background-color: #fff;");
//        Pane.setMargin( a, new Insets(0,0,0,10));
        VBox.setMargin(a, new Insets(0,0,10,0));
        return a;

//        a.setPrefSize( 500, 150);
//        Label b1 = new Label( HelloApplication.name);
//        Label b2 = new Label( dateRegister);
//        Label b3 = new Label("Dang ky thanh cong");
//        a.getChildren().addAll( b1, b2, b3);
//        b1.setTranslateX(0);
//        b1.setTranslateY(0);
//        b2.setTranslateX(0);
//        b2.setTranslateY(50);
//        b3.setTranslateX(0);
//        b3.setTranslateY(100);
    }
}
