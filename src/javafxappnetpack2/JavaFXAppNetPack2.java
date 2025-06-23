package javafxappnetpack2;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXAppNetPack2 extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = getClass().getClassLoader().getResource("view/viewNP.fxml");
        HBox hb = FXMLLoader.<HBox>load(url);
        Scene sc = new Scene(hb);
        sc.getStylesheets().add("view/viewnp.css");
        primaryStage.setScene(sc);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
