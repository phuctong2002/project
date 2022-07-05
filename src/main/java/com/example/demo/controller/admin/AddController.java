package com.example.demo.controller.admin;

import com.example.demo.model.HealthCenter;
import com.example.demo.model.User;
import com.example.demo.utils.AlertBox;
import com.example.demo.utils.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    @FXML
    public ComboBox<String> hospitalAdd;
    @FXML
    public TextField quantityAdd;
    @FXML
    public TableView<HealthCenter> tbAdd;
    @FXML
    public TableColumn<HealthCenter, String> hopitalColumnAdd;
    @FXML
    public TableColumn<HealthCenter, Integer> quantityColumnAdd;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] hospital = {
                "Quynh Mai", "Bach Mai", "Minh Khai", "Quynh Loi", "Truong Dinh", "Dong Tam", "Le Dai Hanh",
                "Nguyen Du", "Pham Dinh Ho", "Cau Den", "Pho Hue", "Bach Khoa", "Vinh Tuy", "Thanh Luong",
                "Bach Dang", "Dong Mac", "Thanh Nhan", "Dong Nhan"
        };
        hospitalAdd.getItems().addAll(hospital);
        try{
            ObservableList<HealthCenter> hospitalList = FXCollections.observableArrayList();
            ResultSet rs = getDeclare();
            HealthCenter abc;
            while( rs.next()){
                abc = new HealthCenter();
                abc.setQuantity( rs.getInt("amount"));
                abc.setName( rs.getString("name") );
                hospitalList.add(abc);
            }
            hopitalColumnAdd.setCellValueFactory( new PropertyValueFactory<HealthCenter, String>("name"));
            quantityColumnAdd.setCellValueFactory( new PropertyValueFactory<HealthCenter,Integer>("quantity"));
            tbAdd.setItems(hospitalList);
        } catch ( SQLException e){
            throw new RuntimeException(e);
        }catch ( ClassNotFoundException e){
            throw new RuntimeException(e);
        }

    }
    private ResultSet getDeclare() throws SQLException, ClassNotFoundException{
        String queryStr = "select * from hospital;";
        ResultSet a = null;
        try{
            a = DB.dbExecuteQuery(queryStr);
        }catch (SQLException  e){
            System.out.println("Error in AddController : " + e.getMessage());

        }
        return a;
    }
    @FXML
    public void btnAdd(){
        if( hospitalAdd.getValue() == null || quantityAdd.getText() == ""){
            AlertBox.displayAlert("Dien day du thong tin");
        }else{

            try {
                String name = hospitalAdd.getValue();
                String id = "";
                ResultSet rs = DB.dbExecuteQuery("select * from hospital where name = '" + name + "';");
                if( rs.next()){
                    id = rs.getString("hos_id");
                }
                String queryStr = "update hospital set amount = (amount +" + quantityAdd.getText() + ") where hos_id = '" + id + "';";
                int a = DB.dbExecuteUpdate( queryStr);
                if( a != 0){
                    AlertBox.displayAlert("Them khong thanh cong");
                }else{
                    AlertBox.displayAlert("Them thanh cong");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try{
                ObservableList<HealthCenter> hospitalList = FXCollections.observableArrayList();
                ResultSet rs = getDeclare();
                HealthCenter abc;
                while( rs.next()){
                    abc = new HealthCenter();
                    abc.setQuantity( rs.getInt("amount"));
                    abc.setName( rs.getString("name") );
                    hospitalList.add(abc);
                }
                hopitalColumnAdd.setCellValueFactory( new PropertyValueFactory<HealthCenter, String>("name"));
                quantityColumnAdd.setCellValueFactory( new PropertyValueFactory<HealthCenter,Integer>("quantity"));
                tbAdd.setItems(hospitalList);
            } catch ( SQLException e){
                throw new RuntimeException(e);
            }catch ( ClassNotFoundException e){
                throw new RuntimeException(e);
            }

        }
    }
}
