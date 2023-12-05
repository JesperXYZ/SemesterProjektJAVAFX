package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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

    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    void goCorridor(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(CORRIDOR_FILE));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goHouseEntry(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(HOUSEENTRY_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goGarden(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(GARDEN_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goKitchen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(KITCHEN_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goBedroom(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(BEDROOM_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goClub(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(CLUB_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goBirthdayParty(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(BIRTHDAYPARTY_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goSchool(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(SCHOOL_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void goFootball(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource(FOOTBALL_FILE));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
