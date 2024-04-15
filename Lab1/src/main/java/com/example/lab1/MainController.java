package com.example.lab1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {

    public TextField enter_A;
    public Slider slider_1;
    public TextField enter_B;
    public Slider slider_2;
    public TextField enter_C;
    public Slider slider_3;
    public Button btn_Opredelit;
    public Button btn_clear;
    public Button btn_exit;
    public Label vivod;

    @FXML
    public void onExit(ActionEvent actionEvent) {
        Platform.exit();
    }
    @FXML
    public void onClick(ActionEvent actionEvent)
    {
            double a = Double.parseDouble(enter_A.getText());
            double b = Double.parseDouble(enter_B.getText());
            double c = Double.parseDouble(enter_C.getText());
        vivod.setText(Triangle.isTriangle(a, b, c));
    }

    @FXML
    public void onClear(ActionEvent actionEvent) {
        enter_A.clear();
        enter_B.clear();
        enter_C.clear();
        slider_1.setValue(0);
        slider_2.setValue(0);
        slider_3.setValue(0);
        vivod.setText("");
    }


    public void onSlider_3(MouseEvent mouseEvent) {
        slider_3.setValue((int)slider_3.getValue());
        enter_C.setText(Double.toString((slider_3.getValue())));
    }

    public void onSlider_2(MouseEvent mouseEvent) {
        slider_2.setValue((int)slider_2.getValue());
        enter_B.setText(Double.toString((slider_2.getValue())));
    }

    public void onSlider_1(MouseEvent mouseEvent) {
        slider_1.setValue((int)slider_1.getValue());
        enter_A.setText(Double.toString((slider_1.getValue())));
    }
}