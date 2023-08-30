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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;


public class Account implements Initializable {


    @FXML
    private PasswordField New_Password;
    @FXML
    private Pane Slidepane;

    @FXML
    private Button New_Password_button;

    @FXML
    private Button Reveal;

    @FXML
    private Button back_das;

    @FXML
    private Label chaange_password_label;

    @FXML
    private Label l1;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private Label l4;

    @FXML
    private Label l5;

    @FXML
    private AnchorPane main_account;
    @FXML
    private Button Information;
    @FXML
    private Button ChangePassword;

    @FXML
    private ImageView Close;

    String newPass;


    int count=1;



    String User_name,User_id,User_password,User_email,User_universityname;



    void Info_data_retrive() throws IOException {
        BufferedReader BR = new BufferedReader(new FileReader("Info_Store.txt"));

        User_name = BR.readLine();
        User_id= BR.readLine();
        User_password= BR.readLine();
        User_email = BR.readLine();
        User_universityname = BR.readLine();
        BR.close();

        newPass=User_password;


//        System.out.println(User_name);
//        System.out.println(User_id);
//        System.out.println(User_password);
//        System.out.println(User_email);
//        System.out.println(User_universityname);


    }







    @FXML
    void Reveal(ActionEvent event) {
          count++;


          if (count%2==0) {
              l3.setText(newPass);
          }

          else{
              l3.setText("***********");

          }
    }




    @FXML
    void New_Password_button(ActionEvent event) throws SQLException {

        Database connecting = new Database();
        Connection connect_DataBase = connecting.getConnection();

        String Change_pass = "SELECT count(1) FROM rider WHERE userid='" + User_id + "' AND password='" + User_password + "'";



        try {
            Statement st= connect_DataBase.createStatement();
            ResultSet rs = st.executeQuery(Change_pass);


            if (rs.next()){

                st.executeUpdate("update rider set password ='"+ New_Password.getText()+"'where userid='"+User_id+"'");


                chaange_password_label.setText("Password Change Successful");
                newPass= New_Password.getText();


                }
                else {

                    chaange_password_label.setText("Password Not Change !!!");

                }


        }

        catch (Exception e){
            e.printStackTrace();
        }


    }


    @FXML
    void back_das(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml")));
        Scene scene3 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.centerOnScreen();
        window.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Info_data_retrive();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        l1.setText(User_name);
        l2.setText(User_id);
        l3.setText("***********");
        l4.setText(User_email);
        l5.setText(User_universityname);


    Close.setOnMouseClicked(event -> {
        System.exit(0);
    });
        Slidepane.setTranslateX(0);
        ChangePassword.setOnMouseClicked(event -> {
        TranslateTransition slide = new TranslateTransition();
        slide.setNode(Slidepane);
        slide.setToX(-598);
        slide.play();
        Slidepane.setTranslateX(-598);
        slide.setOnFinished((ActionEvent e) -> {
            ChangePassword.setVisible(false);
            Information.setVisible(true);
        });
    });
        Information.setOnMouseClicked(event -> {
        TranslateTransition slide = new TranslateTransition();
        slide.setNode(Slidepane);
        slide.setToX(+0);
        slide.play();
        Slidepane.setTranslateX(+598);
        slide.setOnFinished((ActionEvent e) -> {
            ChangePassword.setVisible(true);
            Information.setVisible(false);
        });
    });


}}
