module application {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires mysql.connector.j;
    requires javafx.graphics;


    opens application to javafx.fxml;
    exports application;
}