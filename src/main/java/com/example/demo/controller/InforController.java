package com.example.demo.controller;

import com.example.demo.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class InforController implements Initializable {



    @FXML
    public TextField nameInfor;
    @FXML
    public TextField idInfor;
    @FXML
    public TextField mailInfor;
    @FXML
    public PasswordField passInfor;
    @FXML
    public ChoiceBox genderInfor;
    @FXML
    public DatePicker dobInfor;
    @FXML
    public ComboBox<String> addressInfor;
    @FXML
    public ComboBox<String> hospitalInfor;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        genderInfor.getItems().addAll("Male", "Female");
        String[] address = {"Bach Khoa", "Bach Dang", "Bach Mai", "Cau Den", "Dong Mac", "Dong Nhan", "Dong Tam",
                "Le Dai Hanh", "Minh Khai", "Nguyen Du", "Pham Dinh Ho", "Pho Hue", "Quynh Loi", "Quynh Mai", "Thanh Luong", "Thanh Nhan", "Truong Dinh", "Vinh Tuy"};
        String[] hospital = {
                "Quynh Mai", "Bach Mai", "Minh Khai", "Quynh Loi", "Truong Dinh", "Dong Tam", "Le Dai Hanh",
                "Nguyen Du", "Pham Dinh Ho", "Cau Den", "Pho Hue", "Bach Khoa", "Vinh Tuy", "Thanh Luong",
                "Bach Dang", "Dong Mac", "Thanh Nhan", "Dong Nhan"
        };
        hospitalInfor.getItems().addAll(hospital);
        addressInfor.getItems().addAll( address);
        nameInfor.setText( HelloApplication.name);
        idInfor.setText( HelloApplication.id);
        mailInfor.setText( HelloApplication.email);
        passInfor.setText( HelloApplication.pass);

    }
    @FXML
    public void submitInfor(){
        System.out.println("******Database trong class InforController******");
    }


}
