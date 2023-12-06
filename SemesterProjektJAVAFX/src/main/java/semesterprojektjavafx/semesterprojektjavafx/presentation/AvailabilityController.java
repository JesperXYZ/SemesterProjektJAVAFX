package semesterprojektjavafx.semesterprojektjavafx.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import semesterprojektjavafx.semesterprojektjavafx.domain.*;

import java.io.IOException;
import java.util.Objects;

public class AvailabilityController {
    @FXML
    MenuItem item1;
    @FXML
    MenuItem item2;
    @FXML
    MenuItem item3;
    @FXML
    MenuItem item4;
    @FXML
    MenuButton availableItems;
    public void initialize() {
        availableItems.setText("Available items");
        item1.setDisable(true);
        item2.setVisible(false);
        item3.setVisible(false);
        item4.setVisible(false);
        item1.setText("No items are currently available");

        if(Objects.equals(Game.context.getCurrent().getName(), "The Bedroom"))
        {
            item1.setVisible(true);
            item2.setVisible(true);
            item3.setVisible(false);
            item4.setVisible(false);
            item1.setText("Glucose meter");
            item2.setText("Insulin injector");
            item1.setDisable(false);
        }
        if(Objects.equals(Game.context.getCurrent().getName(), "The Kitchen"))
        {
            item1.setVisible(true);
            item2.setVisible(true);
            item3.setVisible(true);
            item4.setVisible(true);
            item1.setText("Milk (250 ml)");
            item2.setText("Almonds (15 g)");
            item3.setText("Ice tea (250 ml)");
            item4.setText("Apple (110)");
            item1.setDisable(false);
        }
    }

    @FXML
    void grabItem1(ActionEvent event) throws IOException
    {
        if(Objects.equals(Game.context.getCurrent().getName(), "The Bedroom"))
        {
            CommandPickUp.grabWhat("glucosemeter");
        }
        if(Objects.equals(Game.context.getCurrent().getName(), "The Kitchen"))
        {
            CommandPickUp.grabWhat("milk");
        }
        reloadScene(event);
    }

    @FXML
    void grabItem2(ActionEvent event) throws IOException
    {
        if(Objects.equals(Game.context.getCurrent().getName(), "The Bedroom"))
        {
            CommandPickUp.grabWhat("insulininjector");
        }
        if(Objects.equals(Game.context.getCurrent().getName(), "The Kitchen"))
        {
            CommandPickUp.grabWhat("almonds");
        }
        reloadScene(event);
    }
    @FXML
    void grabItem3(ActionEvent event) throws IOException
    {
        if(Objects.equals(Game.context.getCurrent().getName(), "The Kitchen"))
        {
            CommandPickUp.grabWhat("ice tea");
        }
        reloadScene(event);
    }
    @FXML
    void grabItem4(ActionEvent event) throws IOException
    {
        if(Objects.equals(Game.context.getCurrent().getName(), "The Kitchen"))
        {
            CommandPickUp.grabWhat("apple");
        }
        reloadScene(event);
    }
    private void reloadScene(ActionEvent event) throws IOException {
        //Logic to convert the currentSpaceName to the absolute path of its fxml file
        Space currentSpace = Game.context.getCurrent();
        String currentSpaceName = currentSpace.getName();
        String nameWithoutTHE;
        if (currentSpaceName.contains("The ")) {
            nameWithoutTHE = currentSpaceName.substring(4);
        } else {
            nameWithoutTHE = currentSpaceName;
        }
        String nameWithoutTHELowerCase = nameWithoutTHE.toLowerCase();
        String nameWithoutTHELowerCaseWithoutSpace = nameWithoutTHELowerCase.replace(" ", "");
        String nameWithoutTHELowerCaseWithoutSpace2;
        if (nameWithoutTHELowerCaseWithoutSpace.contains("entry")) {
            nameWithoutTHELowerCaseWithoutSpace2 = "houseEntry";
        } else if (nameWithoutTHELowerCaseWithoutSpace.contains("party")) {
            nameWithoutTHELowerCaseWithoutSpace2 = "birthdayParty";
        } else {
            nameWithoutTHELowerCaseWithoutSpace2 = nameWithoutTHELowerCaseWithoutSpace;
        }
        String pathName = "/semesterprojektjavafx/semesterprojektjavafx/" + nameWithoutTHELowerCaseWithoutSpace2 + ".fxml";

        // Reloads the scene to initialize the label in GlucoseLabelController immediately
        FXMLLoader loader = new FXMLLoader(getClass().getResource(pathName));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();

        stage.setScene(scene);
        stage.show();
    }
}
