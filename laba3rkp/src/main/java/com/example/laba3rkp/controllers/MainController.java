package com.example.laba3rkp.controllers;

import com.example.laba3rkp.MainApplication;
import com.example.laba3rkp.dao.Dao;
import com.example.laba3rkp.dao.StudentDao;
import com.example.laba3rkp.domains.Student;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    private TableColumn<Student, Integer> ageColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableView<Student> studentsTable;

    @FXML
    private TableColumn<Student, String> surnameColumn;
    protected ObservableList<Student> students = FXCollections.observableArrayList();
    @FXML
    private Label lbResult;
    @FXML
    private TableColumn<Student, String> groupColumn;
    @FXML
    private TableColumn<Student, String> patronymColumn;

    @FXML
    private TableColumn<Student, String> sityColumn;

    private Dao dao;

    public MainController(){
        dao = new StudentDao();
    }

    @FXML
    void initialize(){
        //students.add(new Student("Миша", "Иванов", "Иванович",20,  "Муром", "ПИн-121"));
        //students.add(new Student("Ярик", "Кокурин", "Дмитриевич",10,  "Муром", "ПИн-121"));
        students.addAll(dao.findAll());
        surnameColumn.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getSurname()));
        nameColumn.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getName()));
        ageColumn.setCellValueFactory(s-> new SimpleObjectProperty<>(s.getValue().getAge()));
        patronymColumn.setCellValueFactory(s-> new SimpleStringProperty(s.getValue().getPatronym()));
        sityColumn.setCellValueFactory(s-> new SimpleStringProperty(s.getValue().getSity()));
        groupColumn.setCellValueFactory(s-> new SimpleStringProperty(s.getValue().getGroup()));

        studentsTable.setItems(students);

        studentsTable.getSortOrder().add(surnameColumn);
        studentsTable.getSortOrder().add(nameColumn);
        studentsTable.getSortOrder().add(ageColumn);

        studentsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observableValue, Student student, Student t1) {
                if (t1 != null){
                    showStudent(t1);
                }
            }


        });
    }

    private void showStudent(Student student) {

        int index = studentsTable.getSelectionModel().getSelectedIndex();
        lbResult.setText(student.toString()+index);
    }


    @FXML
    void onAdd(ActionEvent event) throws IOException {
        Student student = new Student();
            showDialog(student);
            students.add(student);
            dao.save(student);
            studentsTable.getSortOrder().add(surnameColumn);
            studentsTable.getSortOrder().add(nameColumn);
            studentsTable.getSortOrder().add(ageColumn);


    }
    private void showDialog(Student student) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("newstudent-view.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage addStage = new Stage();
            addStage.setTitle("Информация о студенте");
            addStage.setScene(scene);
            addStage.initModality(Modality.APPLICATION_MODAL);
            addStage.initOwner(MainApplication.getMainStage());
            NewStudentController controller = loader.getController();
            controller.setStudent(student);
            controller.setAddStage(addStage);

            addStage.showAndWait();




    }
    @FXML
    void onDelete(ActionEvent event) {

        Student student = studentsTable.getSelectionModel().getSelectedItem();
        studentsTable.getItems().remove(studentsTable.getSelectionModel().getSelectedIndex());
        dao.delete(student);

        lbResult.setText("Строка " + " удалена!");
        studentsTable.sort();
    }

    @FXML
    void onEdit(ActionEvent event) {
        Student student = studentsTable.getSelectionModel().getSelectedItem();
        if(student!=null){
            try {
                showDialog(student);
            } catch (IOException e) {
                lbResult.setText("Ошибка загрузки!");
            }
        }
        studentsTable.sort();
    }

    @FXML
    void onExit(ActionEvent event) {
        Platform.exit();
    }

}
