package com.example.demo.controller;

import com.example.demo.HelloApplication;
import com.example.demo.utils.DB;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Handler;

public class LoginController {
    @FXML
    public TextField loginTextField;
    @FXML
    public PasswordField loginPasswordField;
    @FXML
    public void loginAction() throws SQLException, ClassNotFoundException {
        System.out.println( loginTextField.getText() + " : " + loginPasswordField.getText() );
        ResultSet user = null;
        try{
            String queryStr = "select * from patient where mail = '" + loginTextField.getText() + "';";

            user = DB.dbExecuteQuery( queryStr);
            if ( user.next()){
                String a;
                String b;
                a = user.getString( "mail");
                b = user.getString( "password");
                if( a.equals( loginTextField.getText())  && b.equals( loginPasswordField.getText()) ){
                    System.out.println("Login successfully");
                    HelloApplication.email = user.getString("mail");
                    HelloApplication.name = user.getString("first_name") + " " + user.getString("last_name");
                    HelloApplication.fxmlLoader = new FXMLLoader( HelloApplication.class.getResource("UserPage.fxml"));
                    HelloApplication.scene = new Scene(HelloApplication.fxmlLoader.load(), 800, 600);

                    HelloApplication.window.setTitle("Hello!");
                    HelloApplication.window.setScene(HelloApplication.scene);
                    HelloApplication.window.show();
                }else{
                    System.out.println("Login Failed");
                }
                System.out.println("AAAAA");
            }
        }catch (SQLException | IOException e){
            System.out.println("Error in loginController : " + e.getMessage());
        }finally{
            System.out.println("finally");

        }


    }
    @FXML
    public void registerAction()  throws SQLException, ClassNotFoundException{
        try{
            HelloApplication.fxmlLoader = new FXMLLoader( HelloApplication.class.getResource("register.fxml"));
            HelloApplication.scene = new Scene(HelloApplication.fxmlLoader.load());
            HelloApplication.window.setScene(HelloApplication.scene);
            HelloApplication.window.show();


        } catch (  IOException e ){
            System.out.println("Error in registerAction method in logincontroller");
        }
    }
}
