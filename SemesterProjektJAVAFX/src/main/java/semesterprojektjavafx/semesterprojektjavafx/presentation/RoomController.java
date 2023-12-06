package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import semesterprojektjavafx.semesterprojektjavafx.domain.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

public class RoomController {
    private static final String HOUSEENTRY_FILE = "/semesterprojektjavafx/semesterprojektjavafx/houseEntry.fxml";
    private static final String CORRIDOR_FILE = "/semesterprojektjavafx/semesterprojektjavafx/corridor.fxml";
    private static final String GARDEN_FILE = "/semesterprojektjavafx/semesterprojektjavafx/garden.fxml";
    private static final String BEDROOM_FILE = "/semesterprojektjavafx/semesterprojektjavafx/bedroom.fxml";
    private static final String KITCHEN_FILE = "/semesterprojektjavafx/semesterprojektjavafx/kitchen.fxml";
    private static final String CLUB_FILE = "/semesterprojektjavafx/semesterprojektjavafx/club.fxml";
    private static final String BIRTHDAYPARTY_FILE = "/semesterprojektjavafx/semesterprojektjavafx/birthdayParty.fxml";
    private static final String SCHOOL_FILE = "/semesterprojektjavafx/semesterprojektjavafx/school.fxml";
    private static final String FOOTBALL_FILE = "/semesterprojektjavafx/semesterprojektjavafx/football.fxml";
    private static final String WORK_FILE = "/semesterprojektjavafx/semesterprojektjavafx/work.fxml";

    Stage stage;
    Scene scene;
    Parent root;
    public boolean checkGame(){
        boolean gameOn=true;
        if(ItemsDescription.getHungerLevelInt() <= 0||ItemsDescription.getHungerLevelInt() > 10||ItemsDescription.getGlucoseLevel() <=3||ItemsDescription.getGlucoseLevel() >=8||DayCount.getDay() == 6){
            gameOn=false;
            return gameOn;
        }
        return gameOn;
    }

    public void gameOver() throws IOException {
        root = FXMLLoader.load((getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/ButtonsAndPanes/endScreen.fxml")));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goCorridor(ActionEvent event) throws IOException {
        if(checkGame()==false){
            gameOver();
        }
        Game.context.transition("corridor");
        root = FXMLLoader.load(getClass().getResource(CORRIDOR_FILE));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goHouseEntry(ActionEvent event) throws IOException {
        if(Objects.equals(Game.context.getCurrent().getName(), "The Corridor"))
        {
            Game.context.transition("houseEntry");
        }
        else {
            Game.context.transition("home");
        }
        root = FXMLLoader.load(getClass().getResource(HOUSEENTRY_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goGarden(ActionEvent event) throws IOException {
        Game.context.transition("garden");
        root = FXMLLoader.load(getClass().getResource(GARDEN_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goKitchen(ActionEvent event) throws IOException {
        Game.context.transition("kitchen");
        root = FXMLLoader.load(getClass().getResource(KITCHEN_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goBedroom(ActionEvent event) throws IOException {
        Game.context.transition("bedroom");
        root = FXMLLoader.load(getClass().getResource(BEDROOM_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goClub(ActionEvent event) throws IOException {
        Game.context.transition("club");
        root = FXMLLoader.load(getClass().getResource(CLUB_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goBirthdayParty(ActionEvent event) throws IOException {
        Game.context.transition("birthdayParty");
        root = FXMLLoader.load(getClass().getResource(BIRTHDAYPARTY_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goSchool(ActionEvent event) throws IOException {
        Game.context.transition("school");
        root = FXMLLoader.load(getClass().getResource(SCHOOL_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goFootball(ActionEvent event) throws IOException {
        Game.context.transition("football");
        root = FXMLLoader.load(getClass().getResource(FOOTBALL_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goWork(ActionEvent event) throws IOException {
        Game.context.transition("work");
        root = FXMLLoader.load(getClass().getResource(WORK_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void beginActivity(ActionEvent event) throws IOException {
        if (Context.getCurrent() != null) {
            if (Context.getCurrentActivity() != null) {
                if (Context.getCurrentActivity().equals(CommandBegin.getActivity())) {
                    if(CommandBegin.getActivityDone()==false) {
                        root = FXMLLoader.load((getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/activity.fxml")));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }else{
                        System.out.println("You have finished todays activity");
                    }
                }
                else if (Context.getCurrentActivity().equals("sleep")) {
                    if (CommandBegin.getActivityDone() == false) {
                        System.out.println("You have to finish " + CommandBegin.getActivity() + " before you can sleep");
                    }else{
                        root = FXMLLoader.load((getClass().getResource("/semesterprojektjavafx/semesterprojektjavafx/night.fxml")));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                } else{
                    System.out.println("You can't do this activity today");
                }
            }else{
                System.out.println("No activity here");
            }
        }else {
            System.out.println("Current==null");
        }
    }
}
