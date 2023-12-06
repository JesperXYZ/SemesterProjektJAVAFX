package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import semesterprojektjavafx.semesterprojektjavafx.domain.DayCount;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;

public class EndScreenController {
    String[] gameOverText = {"You did not eat enough so you starved", "You ate more than you could", "Your glucose level got too low", "Your glucose level got too high", "You have mastered diabetes!"};
    @FXML
    private Label gameOverLabel;

    public void initialize() {
        if(ItemsDescription.getHungerLevelInt()<=0){
            gameOverLabel.setText("You did not eat enough so you starved");
        } else if(ItemsDescription.getHungerLevelInt()>10){
            gameOverLabel.setText("You ate more than you could");
        } else if (ItemsDescription.getGlucoseLevel() <= 3){
            gameOverLabel.setText("Your glucose level got too low");
        } else if (ItemsDescription.getGlucoseLevel() >= 8){
            gameOverLabel.setText("Your glucose level got too high");
        } else if (DayCount.getDay() == 6){
            gameOverLabel.setText("You have mastered diabetes!");
        }
    }
}