package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameLauncher extends Application {

    private static final String HOUSEENTRY_FILE = "/semesterprojektjavafx/semesterprojektjavafx/houseEntry.fxml";

    Scene scene;
    Parent root;

// Metode for at sætte scenen når spillet launcher. Spiller starter ved houseEntry, da det er FMXL filen der er loaded
    @Override
    public void start(Stage stage) throws Exception {
        root = (Parent) FXMLLoader.load(getClass().getResource(HOUSEENTRY_FILE));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args){
        launch(args);
    }

}