package com.example.laba3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main3Application extends Application {
    private static Stage mainStage;
    public static Stage getMainStage(){
        return mainStage;
    }
    @Override
    public void start(Stage stage) throws IOException {
        this.mainStage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(main3Application.class.getResource("main3-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Laba3");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}