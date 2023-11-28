package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import semesterprojektjavafx.semesterprojektjavafx.domain.Context;
import semesterprojektjavafx.semesterprojektjavafx.domain.Space;

import java.io.IOException;

public class GameController extends Application {

    private static final String HOUSEENTRY_FILE = "/semesterprojektjavafx/semesterprojektjavafx/houseEntry.fxml";
    private static final String CORRIDOR_FILE = "/semesterprojektjavafx/semesterprojektjavafx/corridor.fxml";
    private static final String GARDEN_FILE = "/semesterprojektjavafx/semesterprojektjavafx/garden.fxml";
    private static final String BEDROOM_FILE = "/semesterprojektjavafx/semesterprojektjavafx/bedroom.fxml";
    private static final String KITCHEN_FILE = "/semesterprojektjavafx/semesterprojektjavafx/kitchen.fxml";
    private static final String CLUB_FILE = "/semesterprojektjavafx/semesterprojektjavafx/club.fxml";
    private static final String BIRTHDAYPARTY_FILE = "/semesterprojektjavafx/semesterprojektjavafx/birthdayParty.fxml";
    private static final String SCHOOL_FILE = "/semesterprojektjavafx/semesterprojektjavafx/school.fxml";
    private static final String FOOTBALL_FILE = "/semesterprojektjavafx/semesterprojektjavafx/football.fxml";


    @FXML
    Stage game = new Stage();
    /*@FXML
    Parent parent = new Parent() {
        @Override
        protected ObservableList<Node> getChildren() {
            return super.getChildren();
        }
    };
    @FXML
    SubScene    kitchen = new SubScene(parent,600,400),
            corridor = new SubScene(parent,600,400),
            bedroom = new SubScene(parent,600,400),
            houseEntry = new SubScene(parent,600,400),
            garden = new SubScene(parent,600,400);*/

    @FXML
    Pane kitchenPane = new Pane();

    void goLeft(){
        if(Context.getCurrent().getName()=="The Kitchen")
        {
            Space next = Context.getCurrent().followEdge("The Corridor");
            //game.setScene(corridor.getScene());
        }
        if(Context.getCurrent().getName()=="The Corridor")
        {
            Space next = Context.getCurrent().followEdge("The Bedroom");
            //game.setScene(bedroom.getScene());
        }
    }
    void goUp(){
        if(Context.getCurrent().getName()=="The Corridor") {
            Space next = Context.getCurrent().followEdge("House entry");
            //game.setScene(houseEntry.getScene());
        }
        if(Context.getCurrent().getName()=="The Garden") {
            Space next = Context.getCurrent().followEdge("The Corridor");
            //game.setScene(corridor.getScene());
        }
    }
    void goRight() {
        if (Context.getCurrent().getName() == "The Corridor") {
            Space next = Context.getCurrent().followEdge("The Kitchen");
            //game.setScene(kitchen.getScene());
        }
    }
    void goDown() throws IOException {
        if (Context.getCurrent().getName() == "The Corridor") {
            Space next = Context.getCurrent().followEdge("The Garden");
            //game.setScene(garden.getScene());
        }
        if (Context.getCurrent().getName() == "House entry") {
            Space next = Context.getCurrent().followEdge("The Corridor");
            Parent root = FXMLLoader.load(getClass().getResource(CORRIDOR_FILE));
            //game = (Stage) ((Node)event.getSource()).
            Scene scene = new Scene(root);
            game.setScene(scene);
            game.show();
        }
    }
    @FXML
    public void keyPressed(javafx.scene.input.KeyEvent keyEvent) throws IOException {
        KeyCode keyCode = keyEvent.getCode();
        if(keyCode==KeyCode.KP_LEFT){
            goLeft();
        }
        if(keyCode==KeyCode.KP_UP)
        {
            goUp();
        }
        if(keyCode==KeyCode.KP_RIGHT){
            goRight();
        }
        if(keyCode==KeyCode.KP_DOWN){
            goDown();
        }
    }

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
    @Override
    public void start(Stage stage) throws Exception {
        root = (Parent) FXMLLoader.load(getClass().getResource(HOUSEENTRY_FILE));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        /*game = FXMLLoader.load(getClass().getResource(HOUSEENTRY_FILE));
        game.show();*/
    }
    public static void main(String[] args){
        launch(args);
    }
}