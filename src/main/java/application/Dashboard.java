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
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.ResourceBundle;

public class Dashboard  implements Initializable {


    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    BigDecimal bigdecimal = new BigDecimal(String.format("%.2f", 0.0));

    @FXML
    private ImageView Login_Image_design;
    @FXML
    private Button About_us;

    @FXML
    private Button Account;

    @FXML
    private TextField DKM;

    @FXML
    private ImageView Map;

    @FXML
    private AnchorPane SlideNav;

    @FXML
    private ImageView aboutus;

    @FXML
    private Pane cost_pane;

    @FXML
    private Text costing;

    @FXML
    private ImageView exit;

    @FXML
    private ImageView imgaccount;

    @FXML
    private ImageView logout;

    @FXML
    private Button logoutb;

    @FXML
    private Button map;

    @FXML
    private AnchorPane main_anchor;

    @FXML
    private Label menu;

    @FXML
    private Label menuback;

    @FXML
    private Button reset;

    @FXML
    private Button submit_km;

    @FXML
    private Pane distance_pane;

    @FXML
    private Line line;
    @FXML
    private TextField place_name1;

    @FXML
    private TextField place_name2;

    @FXML
    private Button place_reset;

    @FXML
    private Button place_submit;


    @FXML
    private Button finding_ride;

    @FXML
    private ProgressBar progress_bar;
    @FXML
    private Button cancel_progress;
    double progress;
    int progress_found;
    @FXML
    private Label progress_label;

    @FXML
    private ProgressBar progress_bar2;

    @FXML
    private Label percent_label;

    @FXML
    private Pane pament_method;

    @FXML
    private Pane pro_bar_pane;

    @FXML
    private Button bikash_pament;


    @FXML
    private Label pement_method_label;


    @FXML
    private Button ride_compleated;



    @FXML
    public WebView wb;
    private WebEngine we;





    @Override
    public void initialize(URL location, ResourceBundle resources) {


         pament_method.setVisible(false);


         we = wb.getEngine();


        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        SlideNav.setTranslateX(-192);
        menu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setNode(SlideNav);
            slide.setToX(0);
            slide.play();

            SlideNav.setTranslateX(-192);
            slide.setOnFinished((ActionEvent e) -> {
                menu.setVisible(false);
                menuback.setVisible(true);
            });
        });
        menuback.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();

            slide.setNode(SlideNav);
            slide.setToX(-192);
            slide.play();

            SlideNav.setTranslateX(0);
            slide.setOnFinished((ActionEvent e) -> {
                menu.setVisible(true);
                menuback.setVisible(false);
            });
        });

    }


    @FXML
    void maps_load() {

        we.load("https://www.google.com/maps");
        place_name1.setText(null);
        place_name2.setText(null);

    }


    @FXML
    void Account_action(ActionEvent event) throws IOException {



        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Account.fxml")));
        Scene scene2 = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();


    }


    @FXML
    void place_reset(ActionEvent event) {
        place_name1.setText(null);
        place_name2.setText(null);

    }

    @FXML
    void place_submit(ActionEvent event) {
        String from_place;
        String to_place;
        from_place = place_name1.getText();
        to_place = place_name2.getText();
        we.load("https://www.google.com/maps/dir/" + from_place + "/" + to_place);

    }


    @FXML
    void reset_action(ActionEvent event) {
        DKM.setText(null);
        costing.setText(String.valueOf(0));

    }


    @FXML
    void submit_km(ActionEvent event) {

        double km_value;
        double per_cost = 0.58;
        double real_value = Double.parseDouble(DKM.getText());
        double cost_value = (real_value * per_cost);
        String formattedValue = decimalFormat.format(cost_value);
        costing.setText(String.valueOf(formattedValue));


    }


    @FXML
    void finding_ride(ActionEvent event) {

        progress_found++;

        progress_bar.setProgress(-1);
        progress_label.setText("Finding,Please wait.....");

        if (progress_found % 2 == 0) {
            progress_label.setText("Found Your Ride");
            progress_bar.setProgress(1);
        }

    }


    @FXML
    void cancel_progress(ActionEvent event) {

        progress_bar.setProgress(0);
        progress_label.setText(null);
        progress_bar2.setProgress(0);

    }


    @FXML
    void ride_compleated(ActionEvent event) {
        if (bigdecimal.doubleValue() < 1) {
            bigdecimal = new BigDecimal(String.format("%.2f", bigdecimal.doubleValue() + 0.2));

            progress_bar2.setProgress(bigdecimal.doubleValue());
            percent_label.setText(Integer.toString((int) Math.round(bigdecimal.doubleValue() * 100)) + "%");


            if (bigdecimal.doubleValue() == 1) {
                pament_method.setVisible(true);


            }


        }

    }

    @FXML
    void bikash_pament(ActionEvent event) {
        pement_method_label.setText("Payment Successful");
        System.out.println(pement_method_label);

    }


    @FXML
    void logoutb(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loginController1.fxml")));
        Scene scene3 = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();


    }

    @FXML
    void About_us(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("About_us.fxml")));
        Scene scene3 = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();

    }



}