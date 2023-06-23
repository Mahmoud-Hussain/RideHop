module ProjectPart {
    requires javafx.controls;
    requires javafx.fxml;


    opens ProjectPart to javafx.fxml;
    exports ProjectPart ;

}