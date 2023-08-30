package application;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;



public class loginController2  implements Initializable {

    @FXML
    private ImageView image2;
    @FXML
    private ImageView gif;

    @FXML
    private Button Back_button;

    @FXML
    private PasswordField Passwordfield2;

    @FXML
    private TextField email_address;

    @FXML
    private TextField idfield2;

    @FXML
    private Button sec_submit;

    @FXML
    private ImageView Close;


    @FXML
    private Label Label2_register;

    @FXML
    private TextField universityname;

    @FXML
    private TextField username;
    @FXML
    private ImageView image;

    @FXML
    private Button ChangePassword;





    @FXML
    void Back_button(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginController1.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void sign_up_submit(ActionEvent event)  {

        if (username.getText().isEmpty()|| idfield2.getText().isEmpty()||Passwordfield2.getText().isEmpty()||email_address.getText().isEmpty()||universityname.getText().isEmpty()) {
            Label2_register.setText("Please fill up the all Field");
        }

        else {

            Create_Account();

        }


    }


    public  void Create_Account(){
        Database connecting = new Database();
        Connection connect_Database = connecting.getConnection();


        String Name =username.getText();
        String Id = idfield2.getText();
        String Password = Passwordfield2.getText();
        String Email =  email_address.getText();
        String University_Name = universityname.getText();



        String insert_Fields = "INSERT INTO rider (User_name,userid,password,email,universityname ) VALUES ('";
        String insertValues = Name +"','"+Id+"','"+Password+"','"+Email+"','"+University_Name+"')";

        String insertToRegister = insert_Fields + insertValues;


        String Check1 = "SELECT userid FROM rider WHERE userid = '"+Id+"'";

        try {
            Statement statement = connect_Database .createStatement();
            ResultSet rs1 = statement.executeQuery(Check1);

            if (rs1.next()){
                Label2_register.setText("ID Already exists");
            }

            else {
                statement.executeUpdate(insertToRegister);
                Label2_register.setText("Done!");
            }

        }
        catch (Exception e){
            e.printStackTrace();

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
