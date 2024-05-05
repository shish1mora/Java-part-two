package com.example.laba3rkp.controllers;

import com.example.laba3rkp.domains.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewStudentController {

    @FXML
    private TextField ageField;

    @FXML
    private TextField groupField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField patronymField;

    @FXML
    private TextField sityField;

    @FXML
    private TextField surnameField;
    private Student student;
    private Stage addStage;

    public void setAddStage(Stage addStage) {
        this.addStage = addStage;
    }

    public void setStudent(Student student) {
        this.student = student;
        surnameField.setText(student.getSurname());
        nameField.setText(student.getName());
        patronymField.setText(student.getPatronym());
        ageField.setText(String.valueOf(student.getAge()));
        sityField.setText(student.getSity());
        groupField.setText(student.getGroup());

    }


    @FXML
    void onCancelClick(ActionEvent event) {
        addStage.close();
    }

    @FXML
    void onSaveClick(ActionEvent event) {
        if (Integer.parseInt(ageField.getText())>0){
            student.setSurname(surnameField.getText());
            student.setName(nameField.getText());
            student.setPatronym(patronymField.getText());
            student.setAge(Integer.parseInt(ageField.getText()));
            student.setSity(sityField.getText());
            student.setGroup(groupField.getText());
            addStage.close();
        }
        else {
            showAlert();
        }

    }
    private void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Введите корректный возраст!");
        alert.setContentText(null);

        alert.showAndWait();
    }

}
