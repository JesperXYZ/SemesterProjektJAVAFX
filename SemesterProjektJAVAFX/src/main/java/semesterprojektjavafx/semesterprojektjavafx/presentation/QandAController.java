package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import semesterprojektjavafx.semesterprojektjavafx.domain.CommandBegin;

public class QandAController {

    @FXML
    private Label activityLabel;
    private Button choice1;
    private Button choice2;

    //initialize is a method that is called when the FXML is loaded
    public void initialize(){
        String activityDescription = (CommandBegin.getBegun()+"\n"+CommandBegin.getQuestion());
        activityLabel.setText(activityDescription);
    }
}
