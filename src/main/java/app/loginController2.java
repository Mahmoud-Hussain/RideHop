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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;


public class loginController2 {

    @FXML
    private PasswordField Passwordfield2;

    @FXML
    private PasswordField Passwordfieldmatch;

    @FXML
    private TextField idfield2;

    @FXML
    private Button sec_submit;

     protected String ID;
     protected String PASS;


    @FXML
    void sign_up_pass(ActionEvent event) {



    }

    @FXML
    void signup_confirm_pass(ActionEvent event) {

    }

    @FXML
    void signup_user_id(ActionEvent event) {



    }

    @FXML
    void sign_up_submit(ActionEvent event) throws IOException {
        ID =idfield2.getText();
        System.out.println(ID);

        PASS = Passwordfield2.getText();
        System.out.println(PASS);

        FileWriter fw =new FileWriter("C:\\Users\\Mushfiq Maher\\Desktop\\RideHop-Mahmoud-s-Branch\\src\\main\\resources\\Files\\DATABASE.txt");
        PrintWriter out =new PrintWriter(fw);

        out.println(ID);
        out.println(PASS);
        out.flush();
        out.close();


        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginController.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();




    }

}
