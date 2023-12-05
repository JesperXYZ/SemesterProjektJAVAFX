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
import semesterprojektjavafx.semesterprojektjavafx.domain.CommandBegin;
import semesterprojektjavafx.semesterprojektjavafx.domain.DayCount;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;

import java.io.IOException;

public class ActivityController {
    String[] room = {"school", "work", "football", "garden", "birthdayParty", "club"};
    Stage stage;
    Scene scene;
    Parent root;

    String roomPath = ("/semesterprojektjavafx/semesterprojektjavafx/"+room[DayCount.getDay()]+".fxml");

    @FXML private Label activityLabel;
    @FXML private Button choice1;
    @FXML private Button choice2;

    //initialize is a method that is called when the FXML is loaded
    public void initialize(){
        String activityDescription = (CommandBegin.getBegun()+"\n"+CommandBegin.getQuestion());
        activityLabel.setText(activityDescription);

        String choice1Description = (CommandBegin.getChoice1());
        String choice2Description = (CommandBegin.getChoice2());
        choice1.setText(choice1Description);
        choice2.setText(choice2Description);

    }

    public void picked1(ActionEvent event) throws IOException {
        ItemsDescription.setGlucoseLevel(CommandBegin.getGlucose1());
        ItemsDescription.setHungerLevel(CommandBegin.getHuger1());
        CommandBegin.setActivityDone(true);

        root = FXMLLoader.load(getClass().getResource(roomPath));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void picked2(ActionEvent event) throws IOException {
        ItemsDescription.setGlucoseLevel(CommandBegin.getGlucose2());
        ItemsDescription.setHungerLevel(CommandBegin.getHuger2());
        CommandBegin.setActivityDone(true);

        root = FXMLLoader.load(getClass().getResource(roomPath));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
