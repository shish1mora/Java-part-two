package com.example.lab2;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
public class Main2Controller {
    public ImageView imagviwe;
    public Slider slid1;
    public Slider slid2;
    public Slider slid3;
    public Slider slid4;
    public Slider slid5;
    @FXML
    private Button btn_app;
    @FXML
    private Button btn_disk;
    @FXML
    private Button btn_exit;
    @FXML
    void onApp(ActionEvent event) {
        Image img = new Image(getClass().getResourceAsStream("logo.png"));
        imagviwe.setImage(img);
    }

    @FXML
    void onDisk(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Открытие изображения");
        FileChooser.ExtensionFilter filter1 = new FileChooser.ExtensionFilter("All image files", "*.png","*.jpg", "*.gif");
        FileChooser.ExtensionFilter filter2 = new FileChooser.ExtensionFilter("JPEG files", "*.jpg");
        FileChooser.ExtensionFilter filter3 = new FileChooser.ExtensionFilter("PNG image Files", "*.png");
        FileChooser.ExtensionFilter filter4 = new FileChooser.ExtensionFilter("GIF image Files", "*.gif");
        fileChooser.getExtensionFilters().addAll(filter1, filter2, filter3, filter4);
        File file = fileChooser.showOpenDialog(Main2Application.getMain2Stage());
        if (file != null) {
            Image img = new Image(file.toURI().toString());
            imagviwe.setImage(img);
        }
    }

    @FXML
    void onExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onClear(ActionEvent actionEvent) {
        imagviwe.setEffect(null);
        slid1.setValue(0);
        slid2.setValue(0);
        slid3.setValue(0);
        slid4.setValue(0);
        slid5.setValue(0);
    }
    public void onBlur(MouseEvent mouseEvent) {
        BoxBlur boxBlur = new BoxBlur();
        boxBlur.setWidth(10);
        boxBlur.setHeight(10);
        boxBlur.setIterations((int)slid1.getValue());
        imagviwe.setEffect(boxBlur);
    }
    public void onHue(MouseEvent mouseEvent) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setHue(slid2.getValue());
        imagviwe.setEffect(colorAdjust);
    }
    public void onSaturation(MouseEvent mouseEvent) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setSaturation(slid3.getValue());
        imagviwe.setEffect(colorAdjust);
    }
    public void onBrightness(MouseEvent mouseEvent) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(slid4.getValue());
        imagviwe.setEffect(colorAdjust);
    }
    public void onContrast(MouseEvent mouseEvent) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setContrast(slid5.getValue());
        imagviwe.setEffect(colorAdjust);
    }
}
