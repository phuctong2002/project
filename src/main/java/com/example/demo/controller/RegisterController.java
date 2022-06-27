package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    public ChoiceBox<String> genderChoiceBox;
    @FXML
    public ComboBox<String> addressComboBox;
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastName;
    @FXML
    public TextField identityNumber;
    @FXML
    public DatePicker dob;
    @FXML
    public TextField mail;
    @FXML
    public PasswordField password;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] gender = {"Male", "Female"};
        genderChoiceBox.getItems().addAll(gender);
        String[] address = {"Nguyen Du", "Le Dai Hanh", "Bui Thi Xuan", "Pho Hue",
                            "Ngo Thi Nham", "Pham Dinh Ho", "Dong Nhan", "Dong Mac",
                            "Bach Dang", "Thanh Luong", "Thanh Nhan", "Cau Den", "Bach Khoa",
                            "Quynh Loi", "Bach Mai", "Quynh Mai", "Vinh Tuy", "Minh Khai",
                            "Truong Dinh", "Dong Tam"};
        addressComboBox.getItems().addAll( address);
    }
    public void registerAction(){

    }
}
