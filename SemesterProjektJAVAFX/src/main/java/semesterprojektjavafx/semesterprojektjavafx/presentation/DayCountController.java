package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import semesterprojektjavafx.semesterprojektjavafx.domain.DayCount;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;

public class DayCountController {
    @FXML
    Label dayCount;
    public void initialize() {
        dayCount.setText(""+ DayCount.getDay());
    }
}
