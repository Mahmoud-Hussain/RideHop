package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;



public class loginController2  {



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
    private Label Label2_register;

    @FXML
    private TextField universityname;

    @FXML
    private TextField username;



    @FXML
    void Back_button(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginController.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();

    }

    @FXML
    void sign_up_submit(ActionEvent event)  {



        if(idfield2.getText().isBlank() && Passwordfield2.getText().isBlank()){

            Label2_register.setText("Enter Your Id and Password");

        }
        else if (!idfield2.getText().isBlank() && Passwordfield2.getText().isBlank() || idfield2.getText().isBlank() && !Passwordfield2.getText().isBlank()) {

            Label2_register.setText("Enter Your Id and Password");
        }
        else{

           // Create_Account();

            Label2_register.setText("Signup Successful");

        }

    }

//    public  void Create_Account(){
//        DataBase connecting = new DataBase();
//        Connection connect_DataBase = connecting.getConnection();
//
//        String id = idfield2.getText();
//        String Password = Passwordfield2.getText();
//        String Email =  email_address.getText();
//
//        String insert_Fields = "INSERT INTO useraccount (ID , passsword ) VALUES ('";
//        String insertValues = id +"','"+Password+"')";
//        String insertToRegister = insert_Fields + insertValues;
//
//        try {
//            Statement statement = connect_DataBase .createStatement();
//            statement.executeUpdate(insertToRegister);
//        }
//
//
//        catch (Exception e){
//            e.printStackTrace();
//
//        }



//    }


}
