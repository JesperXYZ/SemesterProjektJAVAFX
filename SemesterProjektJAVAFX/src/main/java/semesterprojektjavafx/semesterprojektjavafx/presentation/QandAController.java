package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import semesterprojektjavafx.semesterprojektjavafx.domain.CommandBegin;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;

import java.io.IOException;

public class QandAController {

    @FXML
    private Label activityLabel;
    @FXML
    private Button choice1;
    @FXML
    private Button choice2;

    //initialize is a method that is called when the FXML is loaded
    public void initialize(){
        String activityDescription = (CommandBegin.getBegun()+"\n"+CommandBegin.getQuestion());
        activityLabel.setText(activityDescription);

        String choice1Description = (CommandBegin.getChoice1());
        String choice2Description = (CommandBegin.getChoice2());
        choice1.setText(choice1Description);
        choice2.setText(choice2Description);
    }

    public void picked1(ActionEvent event){
        ItemsDescription.setGlucoseLevel(CommandBegin.getGlucose1());
        ItemsDescription.setHungerLevel(CommandBegin.getHuger1());
    }

    public void picked2(ActionEvent event){
        ItemsDescription.setGlucoseLevel(CommandBegin.getGlucose2());
        ItemsDescription.setHungerLevel(CommandBegin.getHuger2());
    }
}
