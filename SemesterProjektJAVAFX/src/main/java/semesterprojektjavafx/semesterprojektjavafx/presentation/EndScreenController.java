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

    public void clearInventory(){
        String[] items = {"milk", "almonds", "ice tea", "apple", "insulininjector", "glucosemeter"};
        while (Context.getCurrentInventory().contains("milk")||Context.getCurrentInventory().contains("almonds")||Context.getCurrentInventory().contains("ice tea")||Context.getCurrentInventory().contains("apple")||Context.getCurrentInventory().contains("insulininjector")||Context.getCurrentInventory().contains("glucosemeter")) {
            for (int i = 0; i < items.length; i++) {
                if (Context.getCurrentInventory().contains(items[i])) {
                    Context.getCurrentInventory().remove(items[i]);
                    break;
                }
            }
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
        clearInventory();

        if(Context.getCurrent().getName()=="School"||Context.getCurrent().getName()=="Work"||Context.getCurrent().getName()=="Football"||Context.getCurrent().getName()=="Club"||Context.getCurrent().getName()=="Birthday party"){
            Game.context.transition("home");
        } else if(Context.getCurrent().getName()=="The Corridor"){
            Game.context.transition("houseEntry");
        } else if(Context.getCurrent().getName()=="The Garden"){
            Game.context.transition("corridor");
            Game.context.transition("houseEntry");
        }
        root = FXMLLoader.load(getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/houseEntry.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void beginQuit(ActionEvent event){
        Stage stage = (Stage) quit.getScene().getWindow();
        stage.close();
    }
}