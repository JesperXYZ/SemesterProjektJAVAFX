package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GlucoseLevelController {

    @FXML
    Label getGlucoseLevel;
    String glucoseLevel = "Tal";
    public void initialize() {
        this.glucoseLevel = GetGlucoseLevelController.glucoseLevelString;
        getGlucoseLevel.setText(this.glucoseLevel);
    }
}
