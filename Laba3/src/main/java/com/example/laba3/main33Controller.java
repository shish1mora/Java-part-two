package com.example.laba3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class main33Controller {

    public TextField surName;
    public TextField name;
    public TextField age;
    public TextField grupp;
    public TextField siti;
    public TextField otchestvo;

    public void setStudent(Student student) {
        this.student = student;
        name.setText(student.getName());
        surName.setText(student.getSurname());
        age.setText(String.valueOf(student.getAge()));
        grupp.setText(student.getGrupp());
        siti.setText(student.getSiti());
        otchestvo.setText(student.getOtchestvo());
    }

    @FXML
    private Student student;
    @FXML
    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    @FXML
    void onAgeField(ActionEvent event) {

    }

    @FXML
    void onClose(ActionEvent event) {
        dialogStage.close();
    }

    @FXML
    void onNameField(ActionEvent event) {

    }

    @FXML
    void onOk(ActionEvent event) {
        student.setName(name.getText());
        student.setSurname(surName.getText());
        student.setAge(Integer.parseInt(age.getText()));
        student.setOtchestvo(otchestvo.getText());
        student.setSiti(siti.getText());
        student.setGrupp(grupp.getText());
        dialogStage.close();
    }

    @FXML
    void onSurNameField(ActionEvent event) {

    }

}
