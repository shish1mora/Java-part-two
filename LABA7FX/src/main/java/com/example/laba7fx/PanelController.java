package com.example.laba7fx;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.nio.file.*;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class PanelController {

    @FXML
    private ComboBox<String> DuskBox;

    @FXML
    private TableColumn<FileInfo, String> FileName;

    @FXML
    private TableColumn<FileInfo, String> TimeColumn;

    @FXML
    private TableColumn<FileInfo, String> TypeColumn;

    @FXML
    private TableColumn<FileInfo, Long> sizeColumn;

    @FXML
    private TableView<FileInfo> filesTable;

    @FXML
    private TextField pathField;



    @FXML
    void OnSelectDisk(ActionEvent event) {
        updateList(Paths.get(DuskBox.getSelectionModel().getSelectedItem()));
    }

    @FXML
    void onPathUp(ActionEvent event) {
            Path UpperPath = Paths.get(pathField.getText()).getParent();

            if(UpperPath != null){
                updateList(UpperPath);
            }
     }

    @FXML
    void initialize(){
        TypeColumn.setCellValueFactory(
                param -> new SimpleStringProperty(param.getValue().getType().getName()));

        FileName.setCellValueFactory(
                parem -> new SimpleStringProperty(parem.getValue().getFileName()));

        sizeColumn.setCellValueFactory(
                param -> new SimpleObjectProperty<>(param.getValue().getSize()));

        sizeColumn.setCellFactory(column -> new TableCell<>(){
            @Override
            protected void updateItem(Long size, boolean empty) {
                super.updateItem(size, empty);
                if(size == null || empty){
                    setText(null);
                }
                else {
                    String text = String.format("%,d byte",size);
                    if(size == -1){
                        text = "[DIR]";
                        setStyle("-fx-text-fill: orange");
                    }

                    setText(text);
                }
            }
        });

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.YY HH:mm");

        TimeColumn.setCellValueFactory(
                param -> new SimpleStringProperty(param.getValue().getLastModified().format(dateTimeFormatter))
        );

        filesTable.getSortOrder().addAll(TypeColumn,FileName);

        DuskBox.getItems().clear();
        for(Path p : FileSystems.getDefault().getRootDirectories()){
            DuskBox.getItems().add(p.toString());
        }

        DuskBox.getSelectionModel().select(0);



        updateList(Paths.get("."));

    }

    protected void updateList(Path path) {
        filesTable.getItems().clear();

        try {
            pathField.setText(
                    path.normalize().toAbsolutePath().toString()
            );

            filesTable.getItems().addAll(Files
                    .list(path)
                    .map(FileInfo::new)
                    .collect(Collectors.toList())
            );

            filesTable.sort();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING,"Не удалось обновить список файлов",ButtonType.OK);
            alert.showAndWait();
        }
    }


    public void onTable(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() == 2){
            Path path = Paths.get(pathField.getText())
                    .resolve(filesTable.getSelectionModel().getSelectedItem().getFileName());

            if(Files.isDirectory(path)){
                updateList(path);
            }
        }
    }


    public  String  getSelectedFileName(){
        if(!filesTable.isFocused()){
            return  null;
        }
        return filesTable.getSelectionModel().getSelectedItem().getFileName();
    }

    public  String getCurrentPath(){
        return pathField.getText();
    }
}
