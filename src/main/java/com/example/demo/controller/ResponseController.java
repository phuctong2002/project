package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.utils.AlertBox;
import com.example.demo.utils.DB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ResponseController implements Initializable {
    @FXML
    public TextField nameResponse;
    @FXML
    public ComboBox<String> injectResponse;
    @FXML
    public CheckBox noResponse;
    @FXML
    public CheckBox yesResponse;
    @FXML
    public Button btnResponse;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameResponse.setText(HelloApplication.name);
        String[] inject = new String[100];
        String queryStr = "select * from injection where pat_id = '" + HelloApplication.id + "' order by inj_time;";
        ResultSet resultSet = null;
        try {
            resultSet = DB.dbExecuteQuery(queryStr);
            int a = 1;
            while( resultSet.next() ) {
                String nameVaccine = resultSet.getString("name");
                String order = String.valueOf(a);
                String dt = resultSet.getString("inj_time");
                inject[a-1] = "Mui : " + order + " loai vaccine " + nameVaccine + " tiem ngay " + dt;
                System.out.println( "Mui : " + order + " loai vaccine " + nameVaccine + " tiem ngay " + dt);
                ++a;
            }
            injectResponse.getItems().addAll(inject);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        noResponse.setSelected(true);
        injectResponse.setValue( inject[0]);

//            injectResponse.getItems().addAll( inject);
    }
    @FXML
    public  void submitResponse(){
        System.out.println("Viet ham vao day nhe");
        String response = "";
        String dt = injectResponse.getValue().substring( injectResponse.getValue().length() - 10);
        if( noResponse.isSelected()){
            response = "Normal";
        }else response = "side-effect";
        try {
            int a = DB.dbExecuteUpdate("update injection set response='" + response + "' where pat_id ='" + HelloApplication.id + "' and inj_time ='"+ dt +"';");
            if( a == 0){
                AlertBox.displayAlert("Gui thanh cong");
                btnResponse.setDisable(true);
            }else{
                AlertBox.displayAlert("Khong thanh cong");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    public void yesResponseAction(){
        noResponse.setSelected( false);
    }
    @FXML
    public void noResponseAction(){
        yesResponse.setSelected(false);
    }
}
