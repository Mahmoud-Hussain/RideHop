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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;






public class loginController {

    @FXML
    private Label Label_front;

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


       // if(idfield.getText()=="maher"&& Passwordfield.getText()=="123"){
           // System.out.println("id and pass matched");

                    Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml")));
                    Scene scene3 = new Scene(parent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene3);
                    window.show();

        }

//        if (!idfield.getText().isBlank() && !Passwordfield.getText().isBlank()) {
//
//           // Login_connect(event);
//
//        } else {
//
//            Label_front.setText("Enter Your Id and Password");
//
//        }

    }

 //   public void Login_connect(ActionEvent event) {
//        DataBase connecting = new DataBase();
//        Connection connect_DataBase = connecting.getConnection();
//        String Check_Login ="SELECT count(1) FROM useraccount WHERE ID = '"+ idfield.getText()+"' AND passsword ='"+Passwordfield.getText()+"'";
//        try {
//            Statement statement= connect_DataBase.createStatement();
//            ResultSet queryResult = statement.executeQuery(Check_Login);
//
//            while (queryResult.next()){
//                if(queryResult.getInt(1)==1){
//
//
//                    Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml")));
//                    Scene scene3 = new Scene(parent);
//                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                    window.setScene(scene3);
//                    window.show();
//
//
//                }
//                else {
//
//                    Label_front.setText("Wrong Id or Password! Please Enter Again");
//
//                }
//
//            }
//
//
//        }
//
//        catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }


   // }
