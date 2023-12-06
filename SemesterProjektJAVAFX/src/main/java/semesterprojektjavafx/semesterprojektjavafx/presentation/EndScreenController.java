package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import semesterprojektjavafx.semesterprojektjavafx.domain.*;

import java.io.IOException;
import java.net.URL;

public class EndScreenController {
    private Stage stage;
    Scene scene;
    Parent root;
    String[] gameOverText = {"You did not eat enough so you starved", "You ate more than you could", "Your glucose level got too low", "Your glucose level got too high", "You have mastered diabetes!"};
    @FXML private Label gameOverLabel;
    @FXML private Button playAgain;
    @FXML private Button quit;

    public int value(){
        if(ItemsDescription.getHungerLevelInt()<=0){
            return 0;
        } else if(ItemsDescription.getHungerLevelInt()>10){
            return 1;
        } else if (ItemsDescription.getGlucoseLevel() <= 3){
            return 2;
        } else if (ItemsDescription.getGlucoseLevel() >= 8){
            return 3;
        } else if (DayCount.getDay() == 6){
            return 4;
        } else {
            return 0;
        }
    }

    public void initialize() {
        String msg = (gameOverText[value()]);
        gameOverLabel.setText(msg);
    }

    @FXML
    void beginPlayAgain(ActionEvent event) throws IOException {
        ItemsDescription.resetGlucoseLevel();
        ItemsDescription.resetHungerLevel();
        DayCount.restDay();
        CommandBegin.setActivityDone(false);

        root = FXMLLoader.load(getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/houseEntry.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        Game.context.transition("houseEntry");
    }

    @FXML
    void beginQuit(ActionEvent event){
        Stage stage = (Stage) quit.getScene().getWindow();
        stage.close();
    }
}