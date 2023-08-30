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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;



public class loginController1 implements Initializable {

    @FXML
    private ImageView close;
    @FXML
    private Label Rider_Button;
    @FXML
    private Label Driver_button;

    @FXML
    private HBox Hbox_Login;

    @FXML
    private ImageView Image_login;

    @FXML
    private AnchorPane Image_slide;

    @FXML
    private Label Label_front;

    @FXML
    private Pane Pane_Login;

    @FXML
    private PasswordField Passwordfield;

    @FXML
    private Pane Top_pane;

    @FXML
    private TextField idfield;

    @FXML
    private Button loginbutton;

    @FXML
    private Button signupbutton;

    @FXML
    private Pane whole_pane;
    public String pass_id1;

    private BufferedWriter BW1;










    @FXML
    void signupaction(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginController2.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.centerOnScreen();
        window.show();
    }


    @FXML
    void Log_in_panel(ActionEvent event) {
        if (!idfield.getText().isBlank() && !Passwordfield.getText().isBlank()) {

            Login_connect(event);

        } else {

            Label_front.setText("Enter Your Email and Password");
        }
    }

    public void Login_connect(ActionEvent event) {



        Database connecting = new Database();
        Connection connect_DataBase = connecting.getConnection();
        String Check_Login ="SELECT count(1) FROM rider WHERE userid = '"+ idfield.getText()+"' AND password ='"+Passwordfield.getText()+"'";
        try {
            Statement statement= connect_DataBase.createStatement();
            ResultSet queryResult = statement.executeQuery(Check_Login);

            while (queryResult.next()){
                if(queryResult.getInt(1)==1){

                    Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Dashboard.fxml")));
                    Scene scene2 = new Scene(parent);
                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    window.setScene(scene2);
                    window.show();
                    window.centerOnScreen();
                    pass_id1 = idfield.getText();

                    User_Information();

                    Client client = new Client("localhost",33333);

                }
                else {

                    Label_front.setText("Wrong Email or Password! Please Enter Again");

                }

            }


        }

        catch (Exception e){
            e.printStackTrace();
        }

    }


    public void User_Information() throws IOException, SQLException {

        Database connecting = new Database();
        Connection connect_DataBase = connecting.getConnection();

        BufferedWriter BW = new BufferedWriter(new FileWriter("Info_Store.txt"));
        BW1 =new BufferedWriter(new FileWriter("onlyname.txt"));


        String String_data = "select name,userid,password,email,universityname from rider where userid = ?";
        PreparedStatement st = connect_DataBase.prepareStatement(String_data);

        st.setString(1, pass_id1);
        ResultSet rs = st.executeQuery();




        if (rs.next()) {

            BW.write(rs.getString("name"));
            BW.newLine();
            BW.write(rs.getString("userid"));
            BW.newLine();
            BW.write(rs.getString("password"));
            BW.newLine();
            BW.write(rs.getString("email"));
            BW.newLine();
            BW.write(rs.getString("universityname"));
            BW.close();


            if (BW1 != null) {
                BW1.close();
            }

            BW1 =new BufferedWriter(new FileWriter("onlyname.txt"));



            try {
                BW1.write(rs.getString("name"));
                BW1.close();


            } catch (IOException e) {
                e.printStackTrace();
            }


            catch (Exception e) {
                System.out.println(e);
            } finally {
                try {

                    if (BW1 != null) {
                        BW1.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }










        } else {
            System.out.println("DATA NOT FOUND!!!!");
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        close.setOnMouseClicked(event -> {
            System.exit(0);
        });

        Image_slide.setTranslateX(0);
        Driver_button.setOnMouseClicked(event ->{
            TranslateTransition slide = new TranslateTransition();
            slide.setNode(Image_slide);
            slide.setToX(+500);
            slide.play();

            Image_slide.setTranslateX(0);
            slide.setOnFinished((ActionEvent e) -> {
                Driver_button.setVisible(false);
               Rider_Button.setVisible(true);
            });
        });
        Rider_Button.setOnMouseClicked(event ->{
            TranslateTransition slide = new TranslateTransition();

            slide.setNode(Image_slide);
            slide.setToX(0);
            slide.play();

            Image_slide.setTranslateX(-500);
            slide.setOnFinished((ActionEvent e) -> {
                Driver_button.setVisible(true);
                Rider_Button.setVisible(false);
            });
        });

    }
}

