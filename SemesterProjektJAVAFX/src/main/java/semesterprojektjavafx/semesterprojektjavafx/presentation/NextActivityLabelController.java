package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import semesterprojektjavafx.semesterprojektjavafx.domain.CommandBegin;
import semesterprojektjavafx.semesterprojektjavafx.domain.DayCount;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;

public class NextActivityLabelController {
    @FXML
    Label nextActivity;
    public void initialize() {
        String todaysActivity = CommandBegin.getActivity();
        if (CommandBegin.getActivityDone()) {
            todaysActivity = "sleep";
        }
        nextActivity.setText("The next activity for today is: "+todaysActivity);
    }
}
