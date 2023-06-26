package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;


public class loginController2 {

    protected String ID;
    protected String PASS;


    @FXML
    private PasswordField Passwordfield2;

    @FXML
    private TextField email_address;

    @FXML
    private TextField idfield2;

    @FXML
    private Button sec_submit;

    @FXML
    void email_address_box(ActionEvent event) {

    }

    @FXML
    void sign_up_pass(ActionEvent event) {

    }

    @FXML
    void sign_up_submit(ActionEvent event) throws IOException {

        ID =idfield2.getText();
        System.out.println(ID);

        PASS = Passwordfield2.getText();
        System.out.println(PASS);

        FileWriter fw =new FileWriter("src\\main\\resources\\Files\\DATA.txt");
        PrintWriter out  =new PrintWriter(fw);
        out.write(ID);
        out.write(PASS);
        out.close();





        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginController.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void signup_user_id(ActionEvent event) {

    }

}
