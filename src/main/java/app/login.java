package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;

public class login extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("loginController.fxml")));
        Scene scene = new Scene(fxmlLoader.load(), Color.WHITE);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


    }
}
