package com.example.demo.utils;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void displayAlert(String me){
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Alert");
        stage.setWidth( 300);
        stage.setHeight(150);
        Label label = new Label();
        label.setText( me);
        label.setStyle("-fx-padding: 10 10 10 10;");
        Button btnClose = new Button("Close");
        btnClose.setOnAction( e -> stage.close());
        VBox layout = new VBox();
        layout.getChildren().addAll( label, btnClose);
        layout.setAlignment( Pos.CENTER );
        Scene scene = new Scene( layout);
        stage.setScene( scene);
        stage.showAndWait();

    }

}
