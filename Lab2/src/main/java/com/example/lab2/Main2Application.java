package com.example.lab2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class Main2Application extends Application {

    static Stage getMain2Stage(){
        return main2Stage;
    }

    private static Stage main2Stage;

    @Override
    public void start(Stage stage) throws IOException {
        main2Stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main2Application.class.getResource("main2-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Приложение для настройки изображение !");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}