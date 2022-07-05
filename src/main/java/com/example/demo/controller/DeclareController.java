package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.utils.AlertBox;
import com.example.demo.utils.DB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DeclareController implements Initializable {
    @FXML
    public RadioButton radio1;
    @FXML
    public RadioButton radio2;
    @FXML
    public RadioButton radio3;
    @FXML
    public RadioButton radio4;
    @FXML
    public RadioButton radio5;
    @FXML
    public RadioButton radio6;
    @FXML
    public RadioButton radio7;
    @FXML
    public RadioButton radio8;
    @FXML
    public Button submitBtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radio8.setSelected( true );
        radio6.setSelected( true );
        radio4.setSelected( true );
        radio2.setSelected( true );
    }
    @FXML
    public void handleSubmit() throws SQLException, ClassNotFoundException {
        int a1 = 1, a2 = 1, a3 = 1, a4 = 1;
        if( radio2.isSelected()) a1 = 0;
        if( radio6.isSelected()) a3 = 0;
        if( radio4.isSelected()) a2 = 0;
        if( radio8.isSelected()) a4 = 0;
        // thuc hien select vao database
        System.out.println("******Thuc hien insert vao database*****");
        String queryStr = "insert into declaration ( pat_id, systoms_14_days, contact, contact_foreign, contact_sysptom ) values"
                + "('"+ HelloApplication.id+ "'," + a1 + "," + a2 + "," + a3 + "," + a4 + ");" ;
        int a = DB.dbExecuteUpdate( queryStr);
        if( a != 0) AlertBox.displayAlert("Khong thanh cong");
        else{
            AlertBox.displayAlert("Gui ban ke khai thanh cong");
            submitBtn.setDisable( true);
        }


    }



}
