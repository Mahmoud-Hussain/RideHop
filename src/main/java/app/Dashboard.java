package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;


public class Dashboard implements Initializable {

    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    @FXML
    private Button Home_button;

    @FXML
    private Button Home_button1;

    @FXML
    private Button Home_button2;

    @FXML
    private Button Home_button3;

    @FXML
    private Button Home_button4;

    @FXML
    private Pane deep_ineer_logo_menu;

    @FXML
    private HBox hbox;

    @FXML
    private Pane inner_pane;

    @FXML
    private VBox linebox;

    @FXML
    private Button menu1_button;

    @FXML
    private Button menu1_button1;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private TextField search_field;

    @FXML
    private AnchorPane side_anchor;

    @FXML
    private Pane last_pane;


    @FXML
    private AnchorPane map_anchor;




    @FXML
    private TextField DKM;


    @FXML
    private Pane cost_pane;

    @FXML
    private Button reset;

    @FXML
    private Pane chatting;

    @FXML
    private VBox schol_vbox;
    @FXML
    private TextField chat_field;

    @FXML
    private Button chat_send;

    @FXML
    private ScrollPane scrool_pane;

    @FXML
    private Text costing;

    @FXML
    public WebView web1;

    private WebEngine engine;


  void costplan(){

      double km_value;
      double per_cost = 0.58;
      double real_value = Double.parseDouble(DKM.getText());
      double cost_value = (real_value * per_cost);
      String formattedValue = decimalFormat.format(cost_value);
      costing.setText(String.valueOf(formattedValue));

 }



    @FXML
    void Home_button2_action(ActionEvent event) {
        costplan();


    }



    @Override
    public void initialize(URL arg0,ResourceBundle arg1) {


        engine= web1.getEngine();
        maps_load();

    }

     public void maps_load() {
        engine.load("https://www.google.com/maps/@23.798032,90.4208093,11.5z?entry=ttu");


    }

    void reset_things(){
        DKM.setText(null);
        costing.setText(String.valueOf(0));


    }


    @FXML
    void reset_action(ActionEvent event) {
      reset_things();


    }
    void mapssend(){
        String maps_search;
        maps_search = search_field.getText();
        engine.load("https://www.google.com/maps/place/"+maps_search);

    }


    @FXML
    void search_mapss(ActionEvent event) {
      mapssend();

    }






    @FXML
    void Exit(ActionEvent event) {

       Stage stage;

        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
       alert.setHeaderText("Are You Sure To Logout?");
      alert.setContentText("If No then Press Cancel");

       if(alert.showAndWait().get()== ButtonType.OK)
       {
           stage = (Stage) hbox.getScene().getWindow();
           stage.close();
       }

    }



}

























