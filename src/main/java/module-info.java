module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens app to javafx.fxml, java.sql, mysql.connector.j;
    exports app;
}