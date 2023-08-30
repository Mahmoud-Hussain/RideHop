package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class About_us implements Initializable {

    @FXML
    private Button back_about_us;
    @FXML
    public WebView web_aboutus;
    private WebEngine we1;
    @FXML
    void back_about_us(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.centerOnScreen();
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        we1 = web_aboutus.getEngine();
        web_About_load();
    }
    public void web_About_load(){
        we1.load("https://sites.google.com/bscse.uiu.ac.bd/ridehop/home");
    }
}
