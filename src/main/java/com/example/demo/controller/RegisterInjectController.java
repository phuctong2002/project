package com.example.demo.controller;

import com.example.demo.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterInjectController implements Initializable {
    @FXML
    public TextField nameRegister;
    @FXML
    public TextField idRegister;
    @FXML
    public ComboBox<String> hospitalRegister;
    @FXML
    public DatePicker timeRegister;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameRegister.setText( HelloApplication.name);
        idRegister.setText(HelloApplication.id);
        String[] hospital = {
                "Quynh Mai", "Bach Mai", "Minh Khai", "Quynh Loi", "Truong Dinh", "Dong Tam", "Le Dai Hanh",
                "Nguyen Du", "Pham Dinh Ho", "Cau Den", "Pho Hue", "Bach Khoa", "Vinh Tuy", "Thanh Luong",
                "Bach Dang", "Dong Mac", "Thanh Nhan", "Dong Nhan"
        };
        hospitalRegister.getItems().addAll( hospital);
    }

    public void submitRegister(){

    }
}
