package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import semesterprojektjavafx.semesterprojektjavafx.domain.DayCount;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;

public class HungerLevelController {
    @FXML
    Label hungerLevel;
    public void initialize() {
        hungerLevel.setText(""+ ItemsDescription.getHungerLevel());
    }
}
