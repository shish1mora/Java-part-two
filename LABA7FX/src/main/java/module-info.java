module com.example.laba7fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laba7fx to javafx.fxml;
    exports com.example.laba7fx;
}