package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import semesterprojektjavafx.semesterprojektjavafx.domain.Game;
import semesterprojektjavafx.semesterprojektjavafx.domain.Inventory;
import semesterprojektjavafx.semesterprojektjavafx.domain.ItemsDescription;
import semesterprojektjavafx.semesterprojektjavafx.domain.Space;

import java.io.IOException;

public class GetGlucoseLevelController {
    Stage stage;
    Scene scene;
    Parent root;
    static String glucoseLevelString = "N/A";
    public void initialize() {
        if (!Inventory.inventoryStorage.contains("glucosemeter")) {
            glucoseLevelString = "N/A";
        }
    }
    @FXML
    void UseGlucoseMeter(ActionEvent event) throws IOException {
        if (Inventory.inventoryStorage.contains("glucosemeter")) {
            glucoseLevelString = ""+ItemsDescription.getGlucoseLevel();
        }

        //Logic to convert the currentSpaceName to the absolute path of its fxml file
        Space currentSpace = Game.context.getCurrent();
        String currentSpaceName = currentSpace.getName();
        String nameWithoutTHE;
        if (currentSpaceName.contains("The ")) {
            nameWithoutTHE = currentSpaceName.substring(4);
        }
        else {
            nameWithoutTHE = currentSpaceName;
        }
        String nameWithoutTHELowerCase = nameWithoutTHE.toLowerCase();
        String nameWithoutTHELowerCaseWithoutSpace = nameWithoutTHELowerCase.replace(" ", "");
        String nameWithoutTHELowerCaseWithoutSpace2;
        if (nameWithoutTHELowerCaseWithoutSpace.contains("entry")) {
            nameWithoutTHELowerCaseWithoutSpace2 = "houseEntry";
        }
        if (nameWithoutTHELowerCaseWithoutSpace.contains("party")) {
            nameWithoutTHELowerCaseWithoutSpace2 = "birthdayParty";
        }
        else {
            nameWithoutTHELowerCaseWithoutSpace2 = nameWithoutTHELowerCaseWithoutSpace;
        }
        String pathName = "/semesterprojektjavafx/semesterprojektjavafx/"+nameWithoutTHELowerCaseWithoutSpace2+".fxml";

        //reloads the scene to initialize the label in GlucoseLabelController immediately
        root = FXMLLoader.load(getClass().getResource(pathName));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
