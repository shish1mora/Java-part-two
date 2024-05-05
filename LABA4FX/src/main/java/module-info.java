module com.example.laba4fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires  java.sql;


    opens com.example.laba4fx to javafx.fxml;
    exports com.example.laba4fx;
}