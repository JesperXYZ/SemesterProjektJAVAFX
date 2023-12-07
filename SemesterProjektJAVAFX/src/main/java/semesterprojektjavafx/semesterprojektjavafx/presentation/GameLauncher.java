package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import semesterprojektjavafx.semesterprojektjavafx.domain.*;

import java.io.IOException;

public class GameLauncher extends Application {

    private static final String INTRODUCTION_FILE = "/semesterprojektjavafx/semesterprojektjavafx/introduction.fxml";

    private Stage stage;
    private Scene scene;
    private Parent root;

    // returner det nuværende rum (Space) Game.context.getCurrent();
    // returner de tilgængelige items i rummet (String[]) Game.context.getCurrentAvailableItems();
    // returner den tilgængelige aktivitet i rummet (String) Game.context.getCurrentActivity();

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(INTRODUCTION_FILE));
        Parent root = loader.load();
        IntroductionController controller = loader.getController();
        controller.setStage(primaryStage);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        public static void main(String[] args) {
            launch(args);
        }
    }

