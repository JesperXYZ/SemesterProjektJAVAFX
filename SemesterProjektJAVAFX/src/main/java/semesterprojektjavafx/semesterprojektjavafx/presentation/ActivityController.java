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

    //initialize er en metode der er kaldt hver gang en FMXL fil er loaded
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

        boolean gameOn=true;
        if(ItemsDescription.getHungerLevelInt() <= 0||ItemsDescription.getHungerLevelInt() > 10||ItemsDescription.getGlucoseLevel() <=3||ItemsDescription.getGlucoseLevel() >=8||DayCount.getDay() == 6){
            gameOn=false;
        }
        if(gameOn==false) {
            root = FXMLLoader.load((getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/endScreen.fxml")));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
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

        boolean gameOn=true;
        if(ItemsDescription.getHungerLevelInt() <= 0||ItemsDescription.getHungerLevelInt() > 10||ItemsDescription.getGlucoseLevel() <=3||ItemsDescription.getGlucoseLevel() >=8||DayCount.getDay() == 6){
            gameOn=false;
        }
        if(gameOn==false) {
            root = FXMLLoader.load((getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/endScreen.fxml")));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
