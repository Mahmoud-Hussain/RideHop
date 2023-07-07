package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class dashboardcontroller {

    @FXML
    private Text selectplace;

    @FXML
    private Button home;

    @FXML
    private Button work;

    @FXML
    private TextField whereto;

    @FXML
    private Button search;

    @FXML
    private Button signout;

    @FXML
    void signout(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginController.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

}
