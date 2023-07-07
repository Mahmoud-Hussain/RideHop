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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class loginController {

    @FXML
    private PasswordField Passworduser;

    @FXML
    private TextField idnumberuser;

    @FXML
    private Button loginbutton;

    @FXML
    private Button signupbutton;

    @FXML
    private Text signuptext;

    @FXML
    private Text userid;

    @FXML
    void signupaction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginController2.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    void toDashboard(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboardcontroller.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    void userlogin(ActionEvent event) throws IOException {
        if(Integer.parseInt(idnumberuser.getText())==301){
            System.out.println("id matched");
            if(Objects.equals(Passworduser.getText(), "mahmoud")){
                System.out.println("password matched");
                toDashboard(event);
            }
        }
        else System.out.println("not matched");
    }
}
