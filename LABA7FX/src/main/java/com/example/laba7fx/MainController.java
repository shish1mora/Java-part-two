package com.example.laba7fx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainController {

    public PanelController leftPanelController,rightPanelController;



    @FXML
    void onCoPy(ActionEvent event) {
            if(leftPanelController.getSelectedFileName()==null && rightPanelController == null){
                Alert alert = new Alert(Alert.AlertType.ERROR,"Не выбран файл", ButtonType.OK);
                alert.showAndWait();
                return;
            }
            PanelController src = null,dst = null;

            if(leftPanelController.getSelectedFileName() != null){
                src = leftPanelController;
                dst = rightPanelController;
            }
            else {
                src = rightPanelController;
                dst=leftPanelController;
            }

            Path srcPath = Paths.get(src.getCurrentPath(),src.getSelectedFileName());
            Path dstPath = Paths.get(dst.getCurrentPath()).resolve(srcPath.getFileName());

        try {
            Files.copy(srcPath,dstPath);
            src.updateList(Paths.get(src.getCurrentPath()));
            dst.updateList(Paths.get(dst.getCurrentPath()));

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Ошибка копирования файла", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void onDelete(ActionEvent event) {
        if(leftPanelController.getSelectedFileName()==null && rightPanelController == null){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Не выбран файл", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        PanelController src = null,dst = null;

        if(leftPanelController.getSelectedFileName() != null){
            src = leftPanelController;
            dst = rightPanelController;
        }
        else {
            src = rightPanelController;
            dst=leftPanelController;
        }

        Path srcPath = Paths.get(src.getCurrentPath(),src.getSelectedFileName());
        Path dstPath = Paths.get(dst.getCurrentPath()).resolve(srcPath.getFileName());

        try {
            Files.delete(srcPath);
            src.updateList(Paths.get(src.getCurrentPath()));
            dst.updateList(Paths.get(dst.getCurrentPath()));

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Ошибка копирования файла", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void onExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onMove(ActionEvent event) {
        if(leftPanelController.getSelectedFileName()==null && rightPanelController == null){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Не выбран файл", ButtonType.OK);
            alert.showAndWait();
            return;
        }
        PanelController src = null,dst = null;

        if(leftPanelController.getSelectedFileName() != null){
            src = leftPanelController;
            dst = rightPanelController;
        }
        else {
            src = rightPanelController;
            dst=leftPanelController;
        }

        Path srcPath = Paths.get(src.getCurrentPath(),src.getSelectedFileName());
        Path dstPath = Paths.get(dst.getCurrentPath()).resolve(srcPath.getFileName());

        try {
            Files.move(srcPath,dstPath);
            src.updateList(Paths.get(src.getCurrentPath()));
            dst.updateList(Paths.get(dst.getCurrentPath()));

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Ошибка копирования файла", ButtonType.OK);
            alert.showAndWait();
        }
    }

}
