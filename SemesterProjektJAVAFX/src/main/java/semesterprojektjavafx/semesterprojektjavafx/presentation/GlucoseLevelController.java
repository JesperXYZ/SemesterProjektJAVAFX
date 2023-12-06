package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import semesterprojektjavafx.semesterprojektjavafx.domain.Inventory;

public class GlucoseLevelController {

    @FXML
    Label getGlucoseLevel;
    String glucoseLevel = "Tal";
    public void initialize() {
        this.glucoseLevel = GetGlucoseLevelController.glucoseLevelString;
        getGlucoseLevel.setText(this.glucoseLevel);
        if (!Inventory.inventoryStorage.contains("glucosemeter")) {
            getGlucoseLevel.setText("N/A");
        }
    }
}
