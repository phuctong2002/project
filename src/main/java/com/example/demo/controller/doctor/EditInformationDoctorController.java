package com.example.demo.controller.doctor;

import com.example.demo.HelloApplication;
import com.example.demo.utils.AlertBox;
import com.example.demo.utils.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static com.example.demo.HelloApplication.*;

public class EditInformationDoctorController implements Initializable  {
    @FXML
    public TextField address;
    @FXML
    public Button btnChange;

    @FXML
    public DatePicker dob;

//    @FXML
//    public TextField docid;

    @FXML
    public TextField firstname;

    @FXML
    public ChoiceBox gender;

//    @FXML
//    public ComboBox<String> hospital;

    @FXML
    public TextField lastname;

    @FXML
    public TextField mail;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gender.getItems().addAll("Male", "Female");
//        String[] Address = {"Bach Khoa", "Bach Dang", "Bach Mai", "Cau Den", "Dong Mac", "Dong Nhan", "Dong Tam",
//                "Le Dai Hanh", "Minh Khai", "Nguyen Du", "Pham Dinh Ho", "Pho Hue", "Quynh Loi", "Quynh Mai", "Thanh Luong", "Thanh Nhan", "Truong Dinh", "Vinh Tuy"};
//        address.getItems().addAll(Address);
//        String[] Hospital = {
//                "Quynh Mai", "Bach Mai", "Minh Khai", "Quynh Loi", "Truong Dinh", "Dong Tam", "Le Dai Hanh",
//                "Nguyen Du", "Pham Dinh Ho", "Cau Den", "Pho Hue", "Bach Khoa", "Vinh Tuy", "Thanh Luong",
//                "Bach Dang", "Dong Mac", "Thanh Nhan", "Dong Nhan"
//        };
//        hospital.getItems().addAll( Hospital);
//        docid.setText(HelloApplication.id);
        firstname.setText(first_name);
        lastname.setText(last_name);
        mail.setText(email);
        address.setText( HelloApplication.address);
        if( HelloApplication.gender.equals("M") ){
            System.out.println("----------Nam nhe----------");
            gender.setValue("Male");
        }else{
            System.out.println("----------Nu nhe----------");
            gender.setValue("Female");
        }
        dob.setValue( LocalDate.parse( HelloApplication.dob));
    }

    @FXML
    public void cancel(ActionEvent event) throws IOException {
        HelloApplication.fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Doc/doctor.fxml"));
        HelloApplication.scene = new Scene(HelloApplication.fxmlLoader.load());
        HelloApplication.window.setTitle("Hello!");
        HelloApplication.window.setScene(HelloApplication.scene);
        HelloApplication.window.show();
    }

    @FXML
    public void change(ActionEvent event) {
        String First_name = firstname.getText();
        String Last_name = lastname.getText();
//        String id = docid.getText();
        String doc_mail = mail.getText();
        String gd;
        if( gender.getValue() == "Male") gd = "M";
        else gd = "F";
        String doc_dob = String.valueOf(dob.getValue());
        String Address = address.getText();
//        String Hospital = hospital.getValue();
//        String hos_id = null;
//        String query = "select hos_id from hospital where name = '" +   Hospital +"';" ;
        ResultSet hos = null;
//        try {
//            hos = DB.dbExecuteQuery(query);
//            if( hos.next()) {
//                hos_id = hos.getString( "hos_id");
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println( hos_id);
        String query = "update doctor set first_name='"+First_name+"', last_name='"+Last_name+"', mail='"+ doc_mail+"', dob = '" + doc_dob+"',gender='" + gd+"', address='"+Address+"' where doc_id='"+ HelloApplication.id+"';";
        try {
            int a =DB.dbExecuteUpdate(query);
            if( a== 0){
                AlertBox.displayAlert("Cap nhat thong tin thanh cong");
                btnChange.setDisable( true);
                // set het tat ca cac gia tri vao day nhe anh em
                first_name = First_name;
                HelloApplication.last_name = Last_name;
                HelloApplication.email = doc_mail;
                HelloApplication.dob = doc_dob;
                HelloApplication.gender = (String) gender.getValue();
                HelloApplication.address = Address;
                HelloApplication.name = first_name + " " + last_name;

                HelloApplication.fxmlLoader = new FXMLLoader( HelloApplication.class.getResource("Doc/doctor.fxml"));
                HelloApplication.scene = new Scene(HelloApplication.fxmlLoader.load());
                HelloApplication.window.setTitle("Doctor");
                HelloApplication.window.setScene(HelloApplication.scene);
                HelloApplication.window.show();
            }else{
                AlertBox.displayAlert("Cap nhat khong thanh cong");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
