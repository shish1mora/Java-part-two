package com.example.laba4fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;

public class MainController {


    public TextArea taResult;


    private  static   String DB_URL = "jdbc:postgresql://127.0.0.1:5432/JAVAFX";

    private  static String USER = "postgres";
    private  static String PASS = "123456";
    private  static String SQL_SELECT = "SELECT * FROM  StoreProducts ";
    private  static  String SQL_ADD = "";
    public TextField ProductNameID;
    public TextField PriceID;
    public TextField QuantityID;
    public TextField CategoryID;


    @FXML

    public void Actiontest(ActionEvent actionEvent) throws SQLException {
        taResult.setText("");
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT);
        while (resultSet.next()){
            String name = resultSet.getString("ProductName");
            int price = resultSet.getInt("Price");
            int quantity = resultSet.getInt("Quantity");
            String  category = resultSet.getString("Category");
            Shop student = new Shop(name,price,quantity);
            String text = " Имя " + name + " Цена " + price + " Количество продукта в наличии " + quantity + " Категория " + category;
            taResult.setText(taResult.getText()+ text + "\n");
        }
    }

    public void ActionAdd(ActionEvent actionEvent) {
        String name = ProductNameID.getText();
        int price = Integer.parseInt(PriceID.getText());
        int quantity = Integer.parseInt(QuantityID.getText());
        String category = CategoryID.getText();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String SQL_ADD = "INSERT INTO StoreProducts (ProductName, Price, Quantity, Category) VALUES ('" + name + "', " + price + ", " + quantity + ", '" + category + "')";
            statement.executeUpdate(SQL_ADD);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Добавление записи");
            alert.setHeaderText("Запись успешно добалена в таблицу");
                    alert.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ActionSearch(ActionEvent actionEvent) {
        taResult.setText("");

        String searchField;
        String searchValue;
        String searchQuery = null;

        if (ProductNameID.getText() != null && !ProductNameID.getText().isEmpty()) {
            searchField = "ProductName";
            searchValue = ProductNameID.getText();
            searchQuery = "SELECT  *  FROM StoreProducts WHERE " + searchField + " = '" + searchValue + "'";
        } else if (PriceID.getText() != null && !PriceID.getText().isEmpty()) {
            searchField = "Price";
            searchValue = PriceID.getText();
            searchQuery = "SELECT  *  FROM StoreProducts WHERE " + searchField + " = " + searchValue;
        } else if (QuantityID.getText() != null && !QuantityID.getText().isEmpty()) {
            searchField = "Quantity";
            searchValue = QuantityID.getText();
            searchQuery = "SELECT  *  FROM StoreProducts WHERE " + searchField + " = " + searchValue;
        } else if (CategoryID.getText() != null && !CategoryID.getText().isEmpty()) {
            searchField = "Category";
            searchValue = CategoryID.getText();
            searchQuery = "SELECT  *  FROM StoreProducts WHERE " + searchField + " = '" + searchValue + "'";
        }

        if (searchQuery != null) {
            try {
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(searchQuery);

                while (resultSet.next()) {
                    String name = resultSet.getString("ProductName");
                    int price = resultSet.getInt("Price");
                    int quantity = resultSet.getInt("Quantity");
                    String category = resultSet.getString("Category");

                    taResult.setText(taResult.getText() + " Имя " + name + " Цена " + price + " Количество продукта в наличии " + quantity + " Категория " + category + "\n");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}