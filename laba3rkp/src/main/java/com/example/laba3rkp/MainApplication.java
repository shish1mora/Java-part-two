package com.example.laba3rkp;

import com.example.laba3rkp.utils.DBHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class MainApplication extends Application {
    public static Stage getMainStage(){
        return mainStage;
    }

    public static Connection getConnection(){
        return connection;
    }
    public static Connection connection;
    private static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {
        try {
            connection = DBHelper.getConnection();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("mainview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stage.setTitle("Table");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        if (connection != null){
            connection.close();
        }
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}