package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroductionController {
    @FXML private Label introductionLabel;
    @FXML private Label introductionLabel2;
    @FXML private Label introductionLabel1;
    @FXML private Label introductionLabel11;
    @FXML private Button startGameButton;
    @FXML private Button quitButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize() {
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void startGameButtonClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/houseEntry.fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void quitButtonClicked() {
        stage.close();
    }
}
