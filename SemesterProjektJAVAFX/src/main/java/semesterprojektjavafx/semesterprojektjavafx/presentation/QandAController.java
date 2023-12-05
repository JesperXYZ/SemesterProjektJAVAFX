package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import semesterprojektjavafx.semesterprojektjavafx.domain.CommandBegin;
import semesterprojektjavafx.semesterprojektjavafx.domain.DayCount;

import java.io.IOException;

public class QandAController {

    Stage stage;
    Scene scene;
    Parent root;

    @FXML private Label sleepLabel;

    //initialize is a method that is called when the FXML is loaded
    public void initialize(){
        String nightQuestion = (CommandBegin.getNightQuestion());
        sleepLabel.setText(nightQuestion);
    }

    public void nightChoice1(ActionEvent event) throws IOException {
        if("1".equals(CommandBegin.getRightNightChoice())){
            System.out.println("That is the right choice!");
        } else {
            System.out.println("That is not the right answer...\nIf you keep playing you might learn it");
        }
        DayCount.plusDay(1);
        CommandBegin.setActivityDone(false);

        root = FXMLLoader.load(getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/bedroom.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void nightChoice2(ActionEvent event) throws IOException {
        if("2".equals(CommandBegin.getRightNightChoice())){
            System.out.println("That is the right choice!");
        } else {
            System.out.println("That is not the right answer...\nIf you keep playing you might learn it");
        }
        DayCount.plusDay(1);
        CommandBegin.setActivityDone(false);

        root = FXMLLoader.load(getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/bedroom.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void nightChoice3(ActionEvent event) throws IOException {
        if("3".equals(CommandBegin.getRightNightChoice())){
            System.out.println("That is the right choice!");
        } else {
            System.out.println("That is not the right answer...\nIf you keep playing you might learn it");
        }
        DayCount.plusDay(1);
        CommandBegin.setActivityDone(false);

        root = FXMLLoader.load(getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/bedroom.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void nightChoice4(ActionEvent event) throws IOException {
        if("4".equals(CommandBegin.getRightNightChoice())){
            System.out.println("That is the right choice!");
        } else {
            System.out.println("That is not the right answer...\nIf you keep playing you might learn it");
        }
        DayCount.plusDay(1);
        CommandBegin.setActivityDone(false);

        root = FXMLLoader.load(getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/bedroom.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
