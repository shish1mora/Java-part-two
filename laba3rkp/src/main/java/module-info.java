module com.example.laba3rkp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.laba3rkp to javafx.fxml;
    exports com.example.laba3rkp;
    exports com.example.laba3rkp.controllers;
    opens com.example.laba3rkp.controllers to javafx.fxml;
    exports com.example.laba3rkp.domains;
    opens com.example.laba3rkp.domains to javafx.fxml;
}