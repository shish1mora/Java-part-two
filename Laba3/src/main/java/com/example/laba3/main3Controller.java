package com.example.laba3;

import javafx.application.Platform;
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

public class main3Controller {
    @FXML
    public TableColumn <Student, String>otchestvoColumn;
    @FXML
    public TableColumn <Student, String>sitiColumn;
    @FXML
    public TableColumn<Student, String> GruppColumn;
    @FXML
    private TableColumn<Student, Integer> ageColumn;

    @FXML
    private Label id_label1;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> surnameColumn;

    @FXML
    private ObservableList<Student> students =
            FXCollections.observableArrayList();

    @FXML
    protected void initialize() {
        students.add(new Student("Денис", "Карпов", 12, "Валерьевич", "Муром", "Пин-121"));
        students.add(new Student("Ермилов", "Мизаил", 15,"Михайлович", "Муром", "Пин-121"));
        students.add(new Student("Тер-Погосян", "Джиурян", 34,"Медин оглы", "Муром", "Пин-121"));
        surnameColumn.setCellValueFactory(item-> item.getValue().nameProperty());
        nameColumn.setCellValueFactory(item-> item.getValue(). surnameProperty());
        ageColumn.setCellValueFactory(item-> item.getValue().ageProperty().asObject());
        otchestvoColumn.setCellValueFactory(item-> item.getValue(). otchestvoProperty());
        sitiColumn.setCellValueFactory(item-> item.getValue(). sitiProperty());
        GruppColumn.setCellValueFactory(item-> item.getValue(). gruppProperty());

        studentTable.setItems(students);
        studentTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observableValue, Student student, Student t1) {
                if (t1 != null) {
                    id_label1.setText(t1.toString());
                }
            }
        });
    }

    private void showDialog(Student student) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("main33-view.fxml"));
        Parent root = loader.load();
        Stage addStage = new Stage();
         addStage.setTitle("Информация о студенту");
        addStage.initModality(Modality.APPLICATION_MODAL);
        addStage.initOwner(main3Application.getMainStage());
        Scene scene = new Scene(root);
        addStage.setScene(scene);
        main33Controller controller = loader.getController();
        controller.setDialogStage(addStage);
        controller.setStudent(student);
                addStage.showAndWait();
    }

    @FXML
    void onDelete(ActionEvent event) {
        int selectedIndex = studentTable.getSelectionModel().getSelectedIndex();
        studentTable.getItems().remove(selectedIndex);
        id_label1.setText("Строка удалена");
    }

    @FXML
    void onExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void onRedakt(ActionEvent event) {
        Student   Student = studentTable.getSelectionModel().getSelectedItem();
        if(  Student != null){
            try {
                showDialog( Student);
            } catch (IOException e){
                id_label1.setText("Ошибка загрузка");
            }

        }
    }

    public void onDabavit(ActionEvent actionEvent) {
        Student student = new Student();
        try {
            showDialog(student);
        } catch (IOException e) {
            id_label1.setText("Ошибка загрузки");
        }
        students.add(student);
    }
}
