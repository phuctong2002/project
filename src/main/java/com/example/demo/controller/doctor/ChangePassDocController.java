package com.example.demo.controller.doctor;

import com.example.demo.HelloApplication;
import com.example.demo.utils.AlertBox;
import com.example.demo.utils.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static com.example.demo.HelloApplication.first_name;
import static com.example.demo.HelloApplication.last_name;

public class ChangePassDocController {
    @FXML
    public PasswordField confirmnewpass;

    @FXML
    public Button btnChange;

    @FXML
    public PasswordField newpass;

    @FXML
    public PasswordField oldpass;

    @FXML
    public void CancelChange(ActionEvent event) throws IOException {
        HelloApplication.fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Doc/doctor.fxml"));
        HelloApplication.scene = new Scene(HelloApplication.fxmlLoader.load());
        HelloApplication.window.setTitle("Doctor");
        HelloApplication.window.setScene(HelloApplication.scene);
        HelloApplication.window.show();
    }

    @FXML
    public void ChangePass(ActionEvent event) throws SQLException, ClassNotFoundException {
        String NewPass = newpass.getText();
        String OldPass = oldpass.getText();
        String ConfirmPass = confirmnewpass.getText();
        if (Objects.equals(NewPass, ConfirmPass)) {
            String query = "update doctor set password ='" + NewPass + "' where doc_id='" + HelloApplication.id + "';";
            try {
                int a = DB.dbExecuteUpdate(query);
                if (a == 0) {
                    AlertBox.displayAlert("Cap nhat thong tin thanh cong");
                    btnChange.setDisable(true);
                    HelloApplication.fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Doc/doctor.fxml"));
                    HelloApplication.scene = new Scene(HelloApplication.fxmlLoader.load());
                    HelloApplication.window.setTitle("Doctor");
                    HelloApplication.window.setScene(HelloApplication.scene);
                    HelloApplication.window.show();
                } else {
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
        else {
            AlertBox.displayAlert("jsand");
        }
    }


}
