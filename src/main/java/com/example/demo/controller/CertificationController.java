package com.example.demo.controller;

import com.example.demo.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CertificationController implements Initializable {
    @FXML
    public Label numberInjection;
    @FXML
    public Label nameCertification;
    @FXML
    public Label dobCertification;
    @FXML
    public Label idCertification;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        nameCertification.setText( HelloApplication.name);
        idCertification.setText( HelloApplication.id);
        numberInjection.setText( "DA TIEM " + HelloApplication.num + " MUI VAC XIN");
        dobCertification.setText(HelloApplication.dob);
    }

}
