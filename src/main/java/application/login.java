package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;




public class login extends Application {
    @Override
    public void start(Stage Primary_stage) throws IOException, InterruptedException {





        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("loginController1.fxml")));
        Primary_stage.getIcons().add(new Image(Objects.requireNonNull(login.class.getResourceAsStream("/image/sl.png"))));
        Scene scene = new Scene(fxmlLoader.load(), Color.WHITE);
        Primary_stage.setTitle("Ride Hop");
        scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
        Primary_stage.setScene(scene);
        Primary_stage.initStyle(StageStyle.UNDECORATED);
        Primary_stage.centerOnScreen();
        Primary_stage.show();

      //  Server server = new Server();



    }
}
