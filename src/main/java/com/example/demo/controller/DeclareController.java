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
        String queryStr = "insert into declaration ( pat_id, symptom_14_days, contact, contact_foreign, contact_symptom ) values"
                + "('"+ HelloApplication.id+ "'," + a1 + "," + a2 + "," + a3 + "," + a4 + ");" ;
        int a = DB.dbExecuteUpdate( queryStr);
        if( a != 0) AlertBox.displayAlert("Khong thanh cong");
        else{
            AlertBox.displayAlert("Gui ban ke khai thanh cong");
            submitBtn.setDisable( true);
        }


    }

    @FXML
    public void radio1Action(){
        if( radio1.isSelected())
            radio2.setSelected(false);
        else radio2.setSelected( true);
    }
    public void radio2Action(){
        if( radio2.isSelected())
            radio1.setSelected(false);
        else radio1.setSelected( true);

    }
    public void radio3Action(){
        if( radio3.isSelected())
            radio4.setSelected(false);
        else radio4.setSelected( true);

    }
    public void radio4Action(){
        if( radio4.isSelected())
            radio3.setSelected(false);
        else radio3.setSelected( true);
    }
    public void radio5Action(){
        if( radio5.isSelected())
            radio6.setSelected(false);
        else radio6.setSelected( true);
    }
    public void radio6Action(){
        if( radio6.isSelected())
            radio5.setSelected(false);
        else radio5.setSelected( true);
    }
    public void radio7Action(){
        if( radio7.isSelected())
            radio8.setSelected(false);
        else radio8.setSelected( true);
    }
    public void radio8Action(){
        if( radio8.isSelected())
            radio7.setSelected(false);
        else radio7.setSelected( true);
    }
}
