package com.example.produuuukt4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;

public class MainController {
    @FXML
    private TextArea taResultat;
    @FXML
    private TextField FigureNameID;
    @FXML
    private TextField TypeID;
    @FXML
    private TextField AreaID;
    @FXML
    private TextField PerimeterID;
    @FXML
    private Label welcomeText;

    private static String DB_URL = "jdbc:mysql://localhost:3306/geometric_figures";
    private static String USER = "root";
    private static String PASS = "";
    private static String SQL_SELECT = "SELECT * FROM figures";
    private static String SQL_ADD = "";



    public void ActionConnect(ActionEvent actionEvent) throws SQLException {
        taResultat.setText("");
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            String type = resultSet.getString("type");
            double area = resultSet.getDouble("area");
            double perimeter = resultSet.getDouble("perimeter");
            String text = " Название: " + name + " Вид: " + type + " Площадь: " + area + " Периметр: " + perimeter;
            taResultat.setText(taResultat.getText() + text + "\n");
        }
    }

    public void ActionDobavit(ActionEvent actionEvent) {
        String name = FigureNameID.getText();
        String type = TypeID.getText();
        double area = Double.parseDouble(AreaID.getText());
        double perimeter = Double.parseDouble(PerimeterID.getText());
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            String SQL_ADD = "INSERT INTO figures (name, type, area, perimeter) VALUES ('" + name + "', '" + type + "', " + area + ", " + perimeter + ")";
            statement.executeUpdate(SQL_ADD);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Добавление записи");
            alert.setHeaderText("Запись успешно добавлена в таблицу");
            alert.showAndWait();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ActionPoisk(ActionEvent actionEvent) {
        taResultat.setText("");
        String searchField;
        String searchValue;
        String searchQuery = null;
        if (FigureNameID.getText() != null && !FigureNameID.getText().isEmpty()) {
            searchField = "name";
            searchValue = FigureNameID.getText();
            searchQuery = "SELECT * FROM figures WHERE " + searchField + " = '" + searchValue + "'";
        } else if (TypeID.getText() != null && !TypeID.getText().isEmpty()) {
            searchField = "type";
            searchValue = TypeID.getText();
            searchQuery = "SELECT * FROM figures WHERE " + searchField + " = '" + searchValue + "'";
        } else if (AreaID.getText() != null && !AreaID.getText().isEmpty()) {
            searchField = "area";
            searchValue = AreaID.getText();
            searchQuery = "SELECT * FROM figures WHERE " + searchField + " = " + searchValue;
        } else if (PerimeterID.getText() != null && !PerimeterID.getText().isEmpty()) {
            searchField = "perimeter";
            searchValue = PerimeterID.getText();
            searchQuery = "SELECT * FROM figures WHERE " + searchField + " = " + searchValue;
        }
        if (searchQuery != null) {
            try {
                Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(searchQuery);
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String type = resultSet.getString("type");
                    double area = resultSet.getDouble("area");
                    double perimeter = resultSet.getDouble("perimeter");
                    String text =  " Название: " + name + " Вид: " + type + " Площадь: " + area + " Периметр: " + perimeter;
                    taResultat.setText(taResultat.getText() + text + "\n");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}