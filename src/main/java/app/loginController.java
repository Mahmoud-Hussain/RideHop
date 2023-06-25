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

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


public class loginController extends loginController2 {

    @FXML
    private PasswordField Passwordfield;

    @FXML
    private TextField idfield;

    @FXML
    private Button loginbutton;

    @FXML
    private Button signupbutton;

    @FXML
    private Text signuptext;

    @FXML
    private Text userid;

    boolean grantAccess = false;




    @FXML
    void signupaction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginController2.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }


    @FXML
    void Log_in_panel(ActionEvent event) throws IOException {
        String username = idfield.getText();
        String password = Passwordfield.getText();

        File scan = new File("C:\\Users\\Mushfiq Maher\\Desktop\\RideHop-Mahmoud-s-Branch\\src\\main\\resources\\Files\\DATABASE.txt");
        Scanner scaning = new Scanner(scan);



        while (scaning.hasNextLine()) {

            if (scaning.nextLine().equals(username)) ;

            {
                if (scaning.nextLine().equals(password)) ;

                {

                    grantAccess=true;


                    scaning.close();
                    break;

                }
            }
        }


        if (grantAccess==true) {
            Parent parent1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml")));
            Scene scene3 = new Scene(parent1);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene3);
            window.show();
        }
        else {
            Parent parent2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Failed.fxml")));
            Scene scene4 = new Scene(parent2);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene4);
            window.show();
        }


    }
}
