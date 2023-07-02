

package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class loginController2 {

    @FXML
    private Button infosubmit;

    @FXML
    private Button backToS1;

    @FXML
    private TextField studentname;

    @FXML
    private TextField nameofuniversity;

    @FXML
    private TextField idnumber;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    void SceneShift(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginController.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    void userinfo(ActionEvent event) {

    }
    

}
